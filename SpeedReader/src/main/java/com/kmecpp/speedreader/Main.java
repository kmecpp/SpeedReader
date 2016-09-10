package com.kmecpp.speedreader;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.lwjgl.Version;

public class Main {

	static {
		System.setProperty("-Dorg.lwjgl.librarypath", "/lib/natives");
	}

	public static void main(String[] args) {
		System.out.println("Starting " + SpeedReader.NAME + " v" + SpeedReader.VERSION + " with LWJGL " + Version.getVersion());

		SpeedReader app = new SpeedReader();
		try {
			app.init();
			while (!app.getWindow().shouldClose()) {
				app.loop();
			}
		} finally {
			app.dispose();
		}
	}

	public static void unpackNatives() {
		Path path = Paths.get("lib" + File.separator + "natives");
		System.out.println(path.toFile().getAbsolutePath());
	}

}
