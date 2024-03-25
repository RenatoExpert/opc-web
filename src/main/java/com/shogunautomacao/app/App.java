package com.shogunautomacao.app;

import com.shogunautomacao.app.Chunk;
import com.shogunautomacao.app.Encoder;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			int response;
			System.out.println("\nReading from server...");
			Encoder encoder = new Encoder();
			while((response = reader.read())) {
				System.out.println("Test " + response);
				//encoder.display(response);
			}
			System.out.println("End!");
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("IO Error: " + ex.getMessage());
		}
	}
}

