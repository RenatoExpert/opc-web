package com.shogunautomacao.app;

import java.util.ArrayList;

public class Display {
	private static void compare(String before, String after) {
		String message = String.format("%s => %s", before, after);
		System.out.println(message);
	}
	public static byte[] integer(int num) {
		byte[] big_endian = ByteBuffer.allocate(4).putInt(num).array();
		ArrayList<byte> little_endian = new ArrayList<byte>();
		for(int i = big_endian.length; i > 0; i--) {
			little_endian.add(big_endian[i - 1]); 
		}
		return litte_endian.toArray();
	}
	public static byte[] ascii(String text) {
		return text.getBytes();
	}
}

