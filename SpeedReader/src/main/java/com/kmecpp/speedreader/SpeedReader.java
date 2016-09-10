package com.kmecpp.speedreader;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL11;

import com.kmecpp.speedreader.display.Window;

public class SpeedReader {

	public static final String NAME = "SpeedReader";
	public static final String VERSION = "1.0";

	private Window window;

	public void init() {
		GLFW.glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err));

		if (GLFW.glfwInit() != GL11.GL_TRUE) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		window = new Window(NAME);
	}

	public void loop() {
		window.update();
	}

	public void dispose() {
		GLFW.glfwTerminate();
	}

	public Window getWindow() {
		return window;
	}

}
