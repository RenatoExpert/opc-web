package com.shogunautomacao.app;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.identity.AnonymousProvider;
import org.eclipse.milo.opcua.sdk.client.api.identity.IdentityProvider;
import org.eclipse.milo.opcua.stack.core.security.SecurityPolicy;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;

public class App {
    public static void main( String[] args ) {
	String endpoint = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
        System.out.println( "Hello World!" );
    }
}
