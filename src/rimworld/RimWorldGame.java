package rimworld;

import gameengine.app.GameApp;
import gameengine.app.GameSetting;
import gameengine.entities.GameObject;
import gameengine.entities.builder.BuilderGameObject;
import gameengine.entities.texture.Texture;
import gameengine.input.UserEvent;
import gameengine.physic.Point2D;
import gameengine.render.Camera;
import gameengine.world.Level;
import javafx.geometry.Dimension2D;
import javafx.scene.input.KeyCode;


public class RimWorldGame extends GameApp {
	GameObject gc;
	
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
				.at(new Point2D(1.0, 1.0))
				.with(new Dimension2D(32, 32))
				.with(new Texture("57"))
				.with(new Point2D(0.01,0.0));
		
		GameObject gameObject2 = BuilderGameObject.createGameObject()
				.at(new Point2D(2.0, 2.0))
				.with(new Dimension2D(32, 32))
				.with(new Texture("57"))
				.is("Test");
		gc = gameObject;
		l.addGameObject(gameObject, gameObject2);
		
		getGameWorld().setLevel(l);
		
	}
	@Override
	public void initCamera(Camera camera) {
		camera.setPosition(gc.getPosition());
		camera.setGameObjectBinded(gc);
	}
	@Override
	public void initTest() {
//		getManager().getScene().setOnKeyPressed((event) ->{
//			if(event.getCode().equals(KeyCode.Z)) {
//				getManager().getCamera().setZoom(getManager().getCamera().getZoom()+0.1);
//			}
//		});
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void initInput() {
		getInput().addEvent(new UserEvent() {
			
			@Override
			public void onUpdate() {
				System.out.println("on presse Z");
			}
			
			@Override
			public void onEnd() {
				System.out.println("on release Z");
			}
			
			@Override
			public void onBegin() {
				System.out.println("on commence a appuyerz Z");
			}
		}, KeyCode.A);
	}

}
