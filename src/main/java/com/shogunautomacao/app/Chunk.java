package com.shogunautomacao.app;

import com.shogunautomacao.app.Encoder;

public class Chunk {
	private byte[] get_content(String url) {
		Encoder encoder = new Encoder();

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
		byte[] endpoint = encoder.string(url);
		encoder.display(endpoint);

		byte[] content = encoder.concat(protocol_version, receiver_size, send_size, max_message_size, max_chunk, endpoint);
		return content;
	}
	public byte[] get_chunk(String url) {
		byte[] content = get_content(url);
		byte[] header = get_header(content.length);
		byte[] chunk = encoder.concat(header, content);
		return chunk;
	}
}

