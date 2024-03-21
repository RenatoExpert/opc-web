package com.shogunautomacao.app;

import com.shogunautomacao.app.Talker;
import com.shogunautomacao.app.Display;

public class App {
	public static void main(String[] args) throws Exception {
		Talker talker = new Talker();
		talker.talk();
		Display display = new Display();
		System.out.println("Converting int to hex");
		display.integer(59);
		System.out.println("Converting ascii to hex");
		display.ascii("F");
	}
}
