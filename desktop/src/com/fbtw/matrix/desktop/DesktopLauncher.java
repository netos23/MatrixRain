package com.fbtw.matrix.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fbtw.matrix.GameMain;

public class DesktopLauncher {

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = GameMain.WINDOW_HEIGHT;
		config.width =	GameMain.WINDOW_WIDTH;
		new LwjglApplication(new GameMain(), config);
	}
}
