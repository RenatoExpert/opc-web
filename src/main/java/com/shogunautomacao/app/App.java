package com.shogunautomacao.app;

import com.shogunautomacao.app.Encoder;

public class App {
	public static void main(String[] args) throws Exception {
		Encoder encoder = new Encoder();
		System.out.println("Converting int to hex");
		//	Message
		System.out.println("Protocol Version");
		System.out.println("Receiver Buffer Size");
		System.out.println("Send Buffer Size");
		System.out.println("Message Size");
		System.out.println("Max Chunk");
		System.out.println("Endpoint URL");
		//	Header
		System.out.println("Message type");
		System.out.println("Reserved Byte");
		String url = "opc.tcp://ec2-3-93-58-9.compute-1.amazonaws.com:4840/";
	}
}

/*
# HEADER
#	MESSAGE TYPE	HEL								x48 x45 x4c
#	RESERVED	F								x46
#	MESSAGE SIZE	81								x51 x00
#	MESSAGE SIZE	85								x55 x00
# MESSAGE
#	PROTOCOL VER	0								x00 x00
#	REC BUF SIZE	8192								x20 x00
#	SND BUF SIZE	8192								x20 x00
#	MESSAGE SIZE	0								x00 x00
#	MAX CHUNK	0								x00 x00
	#	x35 x00 x00 x00
#	ENDPOINT URL		0x6f 0x70 0x63 0x2e 0x74 0x63 0x70 0x3a 0x2f 0x2f 0x65 0x63 0x32 0x2d 0x33 0x2d 0x39 0x33 0x2d 0x35 0x38 0x2d 0x39 0x2e 0x63 0x6f 0x6d 0x70 0x75 0x74 0x65 0x2d 0x31 0x2e 0x61 0x6d 0x61 0x7a 0x6f 0x6e 0x61 0x77 0x73 0x2e 0x63 0x6f 0x6d 0x3a 0x34 0x38 0x34 0x30 0x2f
*/
