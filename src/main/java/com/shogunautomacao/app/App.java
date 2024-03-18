package com.shogunautomacao.app;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.core.types.enumerated.MessageSecurityMode;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.client.UaStackClient;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
	String endpoint = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
	OpcUaClientConfig config = new OpcUaClientConfig();
	UaStackClient stackclient = new UaStackClient();
	OpcUaClient client = OpcUaClient(config, stackclient);
	//OpcUaClientConfig config = OpcUaClientConfigBuilder();
/*
	OpcUaClientConfig client_config = OpcUaClientConfig.builder()
	       .setEndpoint(getEndpoint(endpoint))
                .setSecurityPolicy(SecurityPolicy.None)
                .setSecurityMode(MessageSecurityMode.None)
                .build();
*/
        System.out.println( "Hello World!" );
    }
}
