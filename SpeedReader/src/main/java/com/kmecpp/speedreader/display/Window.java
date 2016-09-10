package com.kmecpp.speedreader.display;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import com.kmecpp.speedreader.References;
import com.kmecpp.speedreader.Timer;

public class Window {

	private static GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

	public static final int SCREEN_WIDTH = vidmode.width();
	public static final int SCREEN_HEIGHT = vidmode.height();

	public static final int DEFAULT_WIDTH = 1280;
	public static final int DEFAULT_HEIGHT = 720;

	private final Timer timer = new Timer();

	private long window;

	private int width;
	private int height;

	public Window() {
	}

	public Window(String title) {
		glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);

		this.window = glfwCreateWindow(DEFAULT_WIDTH,
				DEFAULT_HEIGHT,
				title,
				MemoryUtil.NULL,
				MemoryUtil.NULL);

		glfwSetFramebufferSizeCallback(window, References.store(GLFWFramebufferSizeCallback.create((window, width, height) -> {
			this.width = width;
			this.height = height;
			onResize(width, height);
		})));

		glfwSetWindowPos(window,
				(vidmode.width() - DEFAULT_WIDTH) / 2,
				(vidmode.height() - DEFAULT_HEIGHT) / 2);

		glfwMakeContextCurrent(window);
		GL.createCapabilities();
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public final void update() {
		glfwPollEvents();
		glfwSwapBuffers(window);
		onUpdate(timer.update());
	}

	public final boolean shouldClose() {
		return glfwWindowShouldClose(window) == GL11.GL_TRUE;
	}

	/**
	 * Called when a window is resized
	 * 
	 * @param width
	 *            the new width
	 * @param height
	 *            the new height
	 */
	public void onResize(int width, int height) {
	}

	/**
	 * Called when a window is updated
	 */
	public void onUpdate(double delta) {

	}

}
