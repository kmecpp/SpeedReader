package com.kmecpp.speedreader;

import org.lwjgl.Version;

public class Start {

	static {
		System.setProperty("-Dorg.lwjgl.librarypath", "/lib/natives");
	}

	public static void main(String[] args) {
		System.out.println("Starting " + SpeedReader.NAME + " v" + SpeedReader.VERSION + " with LWJGL " + Version.getVersion());

		new SpeedReader().start();
	}

	//	public static void unpackNatives() {
	//		Path path = Paths.get("lib" + File.separator + "natives");
	//		System.out.println(path.toFile().getAbsolutePath());
	//	}

}
