package com.shogunautomacao.app;

import com.shogunautomacao.app.Encoder;
import com.shogunautomacao.app.Chunk;
import java.util.Arrays;

public class App {
	public static void main(String[] args) throws Exception {
		String url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		Chunk chunk = new Chunk();

		/*
		Encoder encoder = new Encoder();
		//	Header
		System.out.println("Message type");
		byte[] message_type = encoder.ascii("HEL");
		encoder.display(message_type);

		System.out.println("Reserved Byte");
		byte[] reserved_byte = encoder.ascii("F");
		encoder.display(reserved_byte);

		System.out.println("Message Size");
		byte[] message_size = encoder.integer(52);
		//	Calculate length
		//	*/
	}
}

