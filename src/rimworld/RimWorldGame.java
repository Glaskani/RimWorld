package rimworld;

import gameengine.app.GameApp;
import gameengine.app.GameSetting;
import gameengine.entities.GameObject;
import gameengine.entities.builder.BuilderGameObject;
import gameengine.entities.texture.Texture;
import gameengine.world.Level;
import javafx.geometry.Dimension2D;
import javafx.geometry.Point2D;

public class RimWorldGame extends GameApp{

	@Override
	public void initSetting(GameSetting setting) {
		setting.setWidth(1720);
		setting.setHeight(480);
		setting.setTitle("Hello World!");
	}
	@Override
	public void initLevel() {
		Level l = new Level();
		
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				GameObject gameObject = BuilderGameObject.createGameObject()
						.at(new Point2D(i, j))
						.with(new Dimension2D(32, 32))
						.with(new Texture());
				l.addGameObject(gameObject);
			}
		}
		


		
		getGameWorld().setLevel(l);
		
	}
	@Override
	public void initTest() {
		getManager().drawScene(getGameWorld());
	}
	public static void main(String[] args) {
		launch(args);
	}
	
}
