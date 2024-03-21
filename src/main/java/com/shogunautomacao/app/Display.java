package com.shogunautomacao.app;

public class Display {
	public static void integer(int input) {
		String hex = String.format("%02x", input);
		System.out.println(hex);
	}
	public static void ascii(String text) {
		for(char symbol: text.toCharArray()) {
			int value = symbol;
			String hex = String.format("%02x", value);
			System.out.println(hex);
		}
	}
}

