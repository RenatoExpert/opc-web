package com.shogunautomacao.app;

import com.shogunautomacao.app.Encoder;

public class Chunk {
	String url;
	public Chunk(String endpoint) {
		url = endpoint;
	}
	public byte[] get_chunk() {
		Encoder encoder = new Encoder();

		System.out.println("\n\tContent");
		byte[] content = get_content();
		System.out.println("Content Bytes");
		encoder.display(content);

		System.out.println("\n\tHeader");
		byte[] header = get_header(content.length);
		System.out.println("Header Bytes");
		encoder.display(header);

		System.out.println("\n\tFull Chunk");
		byte[] chunk = encoder.concat(header, content);
		encoder.display(chunk);
		return chunk;
	}
	private byte[] get_content() {
		Encoder encoder = new Encoder();
		System.out.println("Protocol Version");
		byte[] protocol_version = encoder.integer(0);
		encoder.display(protocol_version);

		System.out.println("Receiver Buffer Size");
		byte[] receiver_size = encoder.integer(8192);
		encoder.display(receiver_size);

		System.out.println("Send Buffer Size");
		byte[] send_size = encoder.integer(8192);
		encoder.display(send_size);

		System.out.println("Max Message Size");
		byte[] max_message_size = encoder.integer(0);
		encoder.display(max_message_size);

		System.out.println("Max Chunk");
		byte[] max_chunk = encoder.integer(0);
		encoder.display(max_chunk);

		System.out.println("Endpoint URL");
		byte[] endpoint = encoder.string(url);
		encoder.display(endpoint);

		byte[] content = encoder.concat(protocol_version, receiver_size, send_size, max_message_size, max_chunk, endpoint);
		return content;
	}
	private byte[] get_header(int length) {
		Encoder encoder = new Encoder();
		System.out.println("Message type");
		byte[] message_type = encoder.ascii("HEL");
		encoder.display(message_type);

		System.out.println("Reserved Byte");
		byte[] reserved_byte = encoder.ascii("F");
		encoder.display(reserved_byte);

		System.out.println("Message Size");
		byte[] message_size = encoder.integer(length + 8);
		encoder.display(message_size);

		byte[] header = encoder.concat(message_type, reserved_byte, message_size);
		return header;
	}
}

