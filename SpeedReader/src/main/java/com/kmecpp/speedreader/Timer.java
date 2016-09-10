package com.kmecpp.speedreader;

import org.lwjgl.glfw.GLFW;

public class Timer {

	private double lastTime;

	public Timer() {
		lastTime = currentTimeMillis();
	}

	public double getLastTime() {
		return lastTime;
	}

	/**
	 * Updates the timer by setting its last time value to the current time and
	 * returning the difference from its original value to its new one
	 * 
	 * @return the time passed since the timers last update
	 */
	public double update() {
		double currentTime = currentTimeMillis();
		double deltaTime = currentTime - lastTime;
		lastTime = currentTime;
		return deltaTime;
	}

	/*
	 * STATIC
	 */

	public double getTime() {
		return GLFW.glfwGetTime();
	}

	public double currentTimeMillis() {
		return getTime() * 1000;
	}

	public double nanoTime() {
		return currentTimeMillis() * 1000 * 1000;
	}

}
