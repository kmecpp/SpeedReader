package com.kmecpp.speedreader;

import com.kmecpp.jlib.resource.ResourceLocation;
import com.kmecpp.speedreader.desktop.Application;
import com.kmecpp.speedreader.desktop.display.RectMode;
import com.kmecpp.speedreader.desktop.display.Shapes;

public class SpeedReader extends Application {

	public static final String NAME = "SpeedReader";
	public static final String VERSION = "1.0";

	private static ResourceLocation images = new ResourceLocation("image");

	public SpeedReader() {
		super(NAME);
	}

	public static ResourceLocation getImages() {
		return images;
	}

	@Override
	public void onInit() {
		//		GL11.glMatrixMode(GL11.GL_PROJECTION);
		//		GL11.glLoadIdentity();
		//		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		//		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

	@Override
	public void onUpdate(double delta) {
		clear();
		RectMode.CENTER.use();
		Shapes.rect(DISPLAY_WIDTH / 2, DISPLAY_HEIGHT / 2, 100, 100);
	}

}
