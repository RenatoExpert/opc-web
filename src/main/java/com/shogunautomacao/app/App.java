package com.shogunautomacao.app;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;

public class App {
    public static void main( String[] args ) {
	String endpoint_url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
	OpcUaClient client = OpcUaClient.create(endpoint_url);
        System.out.println( "Hello World!" );
    }
}

