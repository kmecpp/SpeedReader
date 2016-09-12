package com.kmecpp.speedreader.desktop;

import org.lwjgl.glfw.GLFW;

import com.kmecpp.speedreader.desktop.display.Window;

public abstract class Application extends Window implements Constants {

	//	private Window window;

	//	public abstract Window createWindow();

	public Application() {
	}

	public Application(String title) {
		super(title);
	}

	//Application control
	public void start() {
		try {
			//			init();
			//			window = createWindow();
			//			while (!window.shouldClose()) {
			//				loop();
			//			}
			while (!shouldClose()) {
				loop();
			}
		} finally {
			dispose();
		}
	}

	private void loop() {
		//		window.update();
		updateWindow();
	}

	private void dispose() {
		GLFW.glfwTerminate();
	}

	//	public Window getWindow() {
	//		return window;
	//	}

}
