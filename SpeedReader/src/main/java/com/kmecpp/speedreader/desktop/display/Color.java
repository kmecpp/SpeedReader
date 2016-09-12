package com.kmecpp.speedreader.desktop.display;

public class Color {

	private float red, green, blue, alpha;

	public static final Color BLACK = Colors.get(0, 0, 0);
	public static final Color DARK_BLUE = Colors.get(0, 0, 170);
	public static final Color DARK_GREEN = Colors.get(0, 170, 0);
	public static final Color DARK_AQUA = Colors.get(0, 170, 170);
	public static final Color DARK_RED = Colors.get(170, 0, 0);
	public static final Color DARK_PURPLE = Colors.get(170, 0, 170);
	public static final Color GOLD = Colors.get(255, 170, 0);
	public static final Color GRAY = Colors.get(170, 170, 170);
	public static final Color DARK_GRAY = Colors.get(85, 85, 85);
	public static final Color BLUE = Colors.get(85, 85, 255);
	public static final Color GREEN = Colors.get(85, 255, 85);
	public static final Color AQUA = Colors.get(85, 255, 255);
	public static final Color RED = Colors.get(255, 85, 85);
	public static final Color LIGHT_PURPLE = Colors.get(255, 85, 255);
	public static final Color YELLOW = Colors.get(255, 255, 85);
	public static final Color WHITE = Colors.get(255, 255, 255);

	public Color(float red, float green, float blue) {
		this(red, green, blue, 0);
	}

	public Color(float red, float green, float blue, float alpha) {
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.alpha = alpha;
	}

	public float getRed() {
		return red;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public float getGreen() {
		return green;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public float getBlue() {
		return blue;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public void setFill() {
		Colors.fill(this);
	}

	public void setStroke() {
		Colors.stroke(this);
	}

}
