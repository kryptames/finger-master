package com.kryp.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kryp.game.FingerMaster;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = FingerMaster.WIDTH;
        config.height = FingerMaster.HEIGHT;
		new LwjglApplication(new FingerMaster(), config);
	}
}
