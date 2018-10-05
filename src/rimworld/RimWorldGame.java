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
		setting.setWidth(720);
		setting.setHeight(480);
		setting.setTitle("Hello World!");
	}
	@Override
	public void initLevel() {
		Level l = new Level();
		
		/*for (int i = 0; i < 0; i++) {
			for (int j = 0; j < 0; j++) {
				GameObject gameObject = BuilderGameObject.createGameObject()
						.at(new Point2D(i, j))
						.with(new Dimension2D(32, 32))
						.with(new Texture());
				l.addGameObject(gameObject);
			}
		}*/
				
		GameObject gameObject = BuilderGameObject.createGameObject()
				.at(new Point2D(1, 1))
				.with(new Dimension2D(32, 32))
				.with(new Texture());
		
		GameObject gameObject2 = BuilderGameObject.createGameObject()
				.at(new Point2D(2, 2))
				.with(new Dimension2D(64, 32))
				.with(new Texture())
				.is("Test");
		l.addGameObject(gameObject, gameObject2);
		
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
