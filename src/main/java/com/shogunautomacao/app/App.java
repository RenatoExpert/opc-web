package com.shogunautomacao.app;

import com.shogunautomacao.app.Encoder;
import java.util.Arrays;

public class App {
	public static void main(String[] args) throws Exception {
		Encoder encoder = new Encoder();
		System.out.println("Converting int to hex");
		//	Message
		System.out.println("Protocol Version");
		byte[] protocol_version = encoder.integer(0);
		encoder.display(protocol_version);

		System.out.println("Receiver Buffer Size");
		byte[] receiver_size = encoder.integer(8192);
		encoder.display(receiver_size);

		System.out.println("Send Buffer Size");
		byte[] send_size = encoder.integer(8192);
		System.out.println(Arrays.toString(send_size));
		encoder.display(send_size);

		System.out.println("Max Message Size");
		byte[] max_message_size = encoder.integer(0);
		encoder.display(max_message_size);

		System.out.println("Max Chunk");
		byte[] max_chunk = encoder.integer(0);
		encoder.display(max_chunk);

		System.out.println("Endpoint URL");
		String url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		byte[] endpoint = encoder.string(url);
		encoder.display(endpoint);

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
	}
}

