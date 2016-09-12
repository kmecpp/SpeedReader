package com.kmecpp.speedreader.desktop.display;

import org.lwjgl.opengl.GL11;

public class Shapes {

	public static void rect(int x, int y, int width, int height) {
		load2d();
		RectMode.getMode().draw(x, y, width, height);
	}

	private static void load2d() {
		//		STBImage.stbi_load_from_memory(ByteBuffer.allocate(1), x, y, comp, req_comp)
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Window.DISPLAY_WIDTH, 0, Window.DISPLAY_HEIGHT, -1, 1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

}
