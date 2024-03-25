package com.shogunautomacao.app;

import com.shogunautomacao.app.Chunk;
import com.shogunautomacao.app.Encoder;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws Exception {
		String protocol = "opc.tcp";
		//String host = "ec2-3-93-58-9.compute-1.amazonaws.com";
		String host = "server";
		int port = 4844;
		String url = String.format("%s://%s:%d/", protocol, host, port);
		Chunk chunk = new Chunk(url);
		byte[] hello = chunk.get_chunk();

		System.out.println("\nConnecting to " + url);
		try (Socket socket = new Socket(host, port)) {
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			writer.println(hello);
			//socket.close();
			/*
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			System.out.println("\nReading from server...");
			Encoder encoder = new Encoder();
			while((line = reader.readLine()) != null) {
				System.out.println("Test");
				System.out.println(line);
			}
			*/
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("IO Error: " + ex.getMessage());
		}
	}
}

