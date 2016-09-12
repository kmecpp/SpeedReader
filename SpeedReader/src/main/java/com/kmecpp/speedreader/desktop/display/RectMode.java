package com.kmecpp.speedreader.desktop.display;

import org.lwjgl.opengl.GL11;

public enum RectMode {

	CORNER,
	//	CORNERS,
	//	RADIUS,
	CENTER;

	private static RectMode mode = CORNER;

	public void use() {
		mode = this;
	}

	public void draw(int x, int y, int width, int height) {
		GL11.glBegin(GL11.GL_QUADS);
		int[][] vertices = getVertices(x, y, width, height);
		GL11.glVertex2i(vertices[0][0], vertices[0][1]);
		GL11.glVertex2i(vertices[1][0], vertices[1][1]);
		GL11.glVertex2i(vertices[2][0], vertices[2][1]);
		GL11.glVertex2i(vertices[3][0], vertices[3][1]);
		GL11.glEnd();
	}

	public int[][] getVertices(int x, int y, int width, int height) {
		switch (mode) {
		case CENTER:
			int halfWidth = width / 2;
			int halfHeight = height / 2;
			return new int[][] {
					{ x - halfWidth, y - halfHeight },
					{ x + halfWidth, y - halfHeight },
					{ x + halfWidth, y + halfHeight },
					{ x - halfWidth, y + halfHeight },
			};
		case CORNER:
			return new int[][] {
					{ x, y },
					{ x + width, y },
					{ x + width, y + height },
					{ x, y + height }
			};
		default:
			throw new Error();
		}

	}

	public static RectMode getMode() {
		return mode;
	}

}
