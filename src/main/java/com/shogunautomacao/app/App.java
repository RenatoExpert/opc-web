package com.shogunautomacao.app;

import com.shogunautomacao.app.Chunk;
import java.net.Socket;

public class App {
	public static void main(String[] args) throws Exception {
		String protocol = "opc.tcp";
		String host = "c2-3-93-58-9.compute-1.amazonaws.com";
		int port = 4840;
		String url = String.format("%s://%s:%d/", protocol, host, port);
		Chunk chunk = new Chunk(url);
		byte[] hello = chunk.get_chunk();
		Socket socket = new Socket(host, port);
	}
}

