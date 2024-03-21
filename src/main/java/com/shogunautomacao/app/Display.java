package com.shogunautomacao.app;

import java.util.ArrayList;

public class Display {
	private static void compare(String before, String after) {
		String message = String.format("%s => %s", before, after);
		System.out.println(message);
	}
	public static void integer(int num) {
		String hex = String.format("%08x", num);
		ArrayList<String> hexs = new ArrayList<String>();
		for(int i = 0; i < 4; i++) {
			int from = 6 - (i * 2);
			int to = from + 2;
			hexs.add(hex.substring(from, to));
		}
		String result = String.join(" ", hexs);
		compare(Integer.toString(num), result);
	}
	public static void ascii(String text) {
		ArrayList<String> hexs = new ArrayList<String>();
		for(char symbol: text.toCharArray()) {
			int value = symbol;
			String hex = String.format("%02x", value);
			hexs.add(hex);
		}
		String result = String.join(" ", hexs);
		compare(text, result);
	}
}

