package com.kmecpp.speedreader.desktop.display;

import org.lwjgl.opengl.GL11;

public class Colors {

	//Defaults
	private static int max = 255;
	//	private static Color fill = Color.WHITE;

	public static void setRange(int max) {
		Colors.max = max;
	}

	public static void fill(int red, int green, int blue) {
		GL11.glColor3f(convert(red), convert(green), convert(blue));
	}

	public static void fill(Color color) {
		GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
	}

	public static void noFill() {
	}

	public static void stroke(Color color) {

	}

	public static void noStroke() {
	}

	public void setFill(Colors fill) {
	}

	public static Color get(int red, int green, int blue) {
		return new Color(convert(red), convert(green), convert(blue));
	}

	private static float convert(int color) {
		return color / max;
	}

}
