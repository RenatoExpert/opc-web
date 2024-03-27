package com.shogunautomacao.app;

public class Decoder {
	public static int integer(byte[4] array) {
		int sum = 0;
		for(int i = 0; i < 4; i++) {
			sum += array[3 - i] * (2 ** (8 * i));
		}
		return sum;
	}
	public static int get_chunk_lenght(byte[8] header) {
		byte[4] field = new byte[4];
		for(int i = 0; i < 4; i++) {
			field[i] = header[i + 4];
		}
		int length = integer(field);
		return lenght;
	}
}

