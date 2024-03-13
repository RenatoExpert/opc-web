package com.shogunautomacao.app;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfig;
//import org.eclipse.milo.opua.stack.core.types.enumerated.MessageSecurityMode;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;



/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
	String endpoint = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
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
