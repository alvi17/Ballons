package alvi17.ballon_popper;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import alvi17.ballon_popper.Tools.Assets;
import alvi17.ballon_popper.Tools.Settings;
import alvi17.ballon_popper.screens.SplashScreen;

public class Balloons extends Game {
	public static final String TITLE = "Ballons et couleurs";
	public static int width = 1280;
	public static int height = 720;
	public SpriteBatch batch;
	
	@Override
	public void create () {
		this.batch = new SpriteBatch();

		Assets.load();
		Settings.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	public void dispose()
	{
		Assets.dispose();
	}
}
