package com.shogunautomacao.app;

import com.shogunautomacao.app.Chunk;
import com.shogunautomacao.app.Encoder;
import com.shogunautomacao.app.Decoder;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws Exception {
		String protocol = "opc.tcp";
		String host = "ec2-3-93-58-9.compute-1.amazonaws.com";
		//String host = "server";
		int port = 4840;
		String url = String.format("%s://%s:%d/", protocol, host, port);
		Chunk chunk = new Chunk(url);
		byte[] hello = chunk.get_chunk();

		System.out.println("\nConnecting to " + url);
		try (Socket socket = new Socket(host, port)) {
			OutputStream output = socket.getOutputStream();
			PrintStream writer = new PrintStream(output, true);
			writer.write(hello);
			//	Reading
			Encoder encoder = new Encoder();
			Decoder decoder = new Decoder();
			System.out.println("\nReading from server...");
			InputStream input = socket.getInputStream();
			int bytesRead;
			byte[] buffer = new byte[1];
			int count = 0;
			byte[] header = new byte[8];
			int chunk_length = 16;
			while((bytesRead = input.read(buffer)) > 0 && count < chunk_length) {
				if(count < 8) {		// Header
					header[count] = buffer[0];
				} else {		// Content
					chunk_length = decoder.get_chunk_length(header);
				}
				System.out.println(String.format("Read %d", bytesRead));
				encoder.display(buffer);
				count += bytesRead;
			}
			System.out.println("End!");
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("IO Error: " + ex.getMessage());
		}
	}
}

