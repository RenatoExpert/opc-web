package com.shogunautomacao.app;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.sdk.client.api.identity.IdentityProvider;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Security;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.stack.client.security.DefaultClientCertificateValidator;
import org.eclipse.milo.opcua.stack.core.Stack;
import org.eclipse.milo.opcua.stack.core.security.DefaultTrustListManager;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.Unsigned.uint;

public class App {
    public static void main( String[] args ) {
	String endpoint_url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
	SecurityPolicy policy = SecurityPolicy.Basic256Sha256;
        OpcUaClient client = OpcUaClient.create(
            endpoint_url,
            endpoints ->
                endpoints.stream()
                    .filter(e -> getSecurityPolicy().getUri().equals(e.getSecurityPolicyUri()))
                    .findFirst(),
            configBuilder ->
                configBuilder
                    .setApplicationName(LocalizedText.english("eclipse milo opc-ua client"))
                    .setApplicationUri("urn:eclipse:milo:examples:client")
                    .setKeyPair(loader.getClientKeyPair())
                    .setCertificate(loader.getClientCertificate())
                    .setCertificateChain(loader.getClientCertificateChain())
                    .setCertificateValidator(certificateValidator)
                    .setIdentityProvider(clientExample.getIdentityProvider())
                    .setRequestTimeout(uint(5000))
                    .build()
        );
        System.out.println( "Hello World!" );
    }
}


/*
    private OpcUaClient createClient() throws Exception {
        Path securityTempDir = Paths.get(System.getProperty("java.io.tmpdir"), "client", "security");
        Files.createDirectories(securityTempDir);
        if (!Files.exists(securityTempDir)) {
            throw new Exception("unable to create security dir: " + securityTempDir);
        }

        File pkiDir = securityTempDir.resolve("pki").toFile();

        LoggerFactory.getLogger(getClass())
            .info("security dir: {}", securityTempDir.toAbsolutePath());
        LoggerFactory.getLogger(getClass())
            .info("security pki dir: {}", pkiDir.getAbsolutePath());

        KeyStoreLoader loader = new KeyStoreLoader().load(securityTempDir);

        trustListManager = new DefaultTrustListManager(pkiDir);

        DefaultClientCertificateValidator certificateValidator =
            new DefaultClientCertificateValidator(trustListManager);

    }

    public void run() {
        try {
            OpcUaClient client = createClient();

            if (serverRequired) {
                // For the sake of the examples we will create mutual trust between the client and
                // server, so we can run them with security enabled by default.
                // If the client example is pointed at another server then the rejected certificate
                // will need to be moved from the security "pki/rejected" directory to the
                // "pki/trusted/certs" directory.

                // Make the example server trust the example client certificate by default.
                client.getConfig().getCertificate().ifPresent(
                    certificate ->
                        exampleServer.getServer().getConfig().getTrustListManager().addTrustedCertificate(certificate)
                );

                // Make the example client trust the example server certificate by default.
                exampleServer.getServer().getConfig().getCertificateManager().getCertificates().forEach(
                    certificate ->
                        trustListManager.addTrustedCertificate(certificate)
                );
            }

            future.whenCompleteAsync((c, ex) -> {
                if (ex != null) {
                    logger.error("Error running example: {}", ex.getMessage(), ex);
                }

                try {
                    client.disconnect().get();
                    if (serverRequired && exampleServer != null) {
                        exampleServer.shutdown().get();
                    }
                    Stack.releaseSharedResources();
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Error disconnecting: {}", e.getMessage(), e);
                }

                try {
                    Thread.sleep(1000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            try {
                clientExample.run(client, future);
                future.get(15, TimeUnit.SECONDS);
            } catch (Throwable t) {
                logger.error("Error running client example: {}", t.getMessage(), t);
                future.completeExceptionally(t);
            }
        } catch (Throwable t) {
            logger.error("Error getting client: {}", t.getMessage(), t);

            future.completeExceptionally(t);

            try {
                Thread.sleep(1000);
                System.exit(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(999_999_999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
*/
