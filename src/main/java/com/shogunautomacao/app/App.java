package com.shogunautomacao.app;

import com.shogunautomacao.app.Chunk;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws Exception {
		String protocol = "opc.tcp";
		String host = "ec2-3-93-58-9.compute-1.amazonaws.com";
		int port = 4840;
		String url = String.format("%s://%s:%d/", protocol, host, port);
		Chunk chunk = new Chunk(url);
		byte[] hello = chunk.get_chunk();

		System.out.println("\nConnecting to " + url);
		try (Socket socket = new Socket(host, port)) {
		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("IO Error: " + ex.getMessage());
		}
	}
}

