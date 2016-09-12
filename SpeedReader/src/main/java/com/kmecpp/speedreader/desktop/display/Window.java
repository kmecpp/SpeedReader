package com.kmecpp.speedreader.desktop.display;

import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.system.MemoryUtil;

import com.kmecpp.speedreader.Timer;

public class Window {

	static {
		GLFW.glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err));

		if (!GLFW.glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}
	}

	private static GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

	public static final int DISPLAY_WIDTH = vidmode.width();
	public static final int DISPLAY_HEIGHT = vidmode.height();

	public static final int DEFAULT_WIDTH = 1280;
	public static final int DEFAULT_HEIGHT = 720;

	private final Timer timer = new Timer();

	private long window;

	private int width = DEFAULT_WIDTH;
	private int height = DEFAULT_HEIGHT;

	public Window() {
		this("");
	}

	public Window(String title) {
		glfwWindowHint(GLFW_RESIZABLE, GL11.GL_TRUE);

		this.window = glfwCreateWindow(DEFAULT_WIDTH,
				DEFAULT_HEIGHT,
				title,
				MemoryUtil.NULL,
				MemoryUtil.NULL);

		glfwSetFramebufferSizeCallback(window, (window, width, height) -> {
			this.width = width;
			this.height = height;
			onResize(width, height); //CALL
		});

		//		glfwSetFramebufferSizeCallback(window, References.store(GLFWFramebufferSizeCallback.create((window, width, height) -> {
		//			this.width = width;
		//			this.height = height;
		//			onResize(width, height); //CALL
		//		})));

		center();

		glfwMakeContextCurrent(window);
		GL.createCapabilities();

		onInit(); //CALL
	}

	public final void updateWindow() {
		glfwPollEvents();
		glfwSwapBuffers(window);

		onUpdate(timer.update()); //CALL
	}

	public final boolean shouldClose() {
		return glfwWindowShouldClose(window);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public final void clear() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}

	public void center() {
		setPos((vidmode.width() - DEFAULT_WIDTH) / 2,
				(vidmode.height() - DEFAULT_HEIGHT) / 2);
	}

	public void setPos(int x, int y) {
		glfwSetWindowPos(window, x, y);
	}

	public void resize(int width, int height) {
		glfwSetWindowSize(window, width, height);
	}

	public void maximize() {
		glfwMaximizeWindow(window);
	}

	public void minimize() {
		glfwIconifyWindow(window);
	}
	
	public void background(Color c){
		
	}

	/**
	 * Sets the window title
	 * 
	 * @param title
	 *            the new title for the window
	 */
	public void setTitle(String title) {
		glfwSetWindowTitle(window, title);
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
	 * Called when a window is created
	 */
	public void onInit() {
	}

	/**
	 * Called when a window is updated
	 */
	public void onUpdate(double delta) {
		clear();
	}

}
