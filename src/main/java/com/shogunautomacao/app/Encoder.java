package com.shogunautomacao.app;

import java.util.ArrayList;
import java.nio.ByteBuffer;

public class Encoder {
	public static void display(byte[] input) {
		ArrayList<String> hexs = new ArrayList<String>();
		for(byte value: input) {
			hexs.add(String.format("%02x", value));
		}
		String result = String.join(" ", hexs);
		System.out.println(result);
	}
	public static byte[] integer(int num) {
		byte[] big_endian = ByteBuffer.allocate(4).putInt(num).array();
		byte[] little_endian = new byte[4];
		for(int i = 0; i < 4; i++) {
			little_endian[i] = big_endian[3 - i]; 
		}
		return little_endian;
	}
	public static byte[] ascii(String text) {
		return text.getBytes();
	}
}

