package com.shogunautomacao.app;

import com.shogunautomacao.app.Chunk;

public class App {
	public static void main(String[] args) throws Exception {
		String url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
		Chunk chunk = new Chunk(url);
		chunk.get_chunk();
	}
}

