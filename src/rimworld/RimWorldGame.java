package rimworld;

import gameengine.app.GameApp;
import gameengine.app.GameSetting;
import gameengine.entities.GameObject;
import gameengine.entities.builder.BuilderGameObject;
import gameengine.entities.builder.BuilderGameObjectFactory;
import gameengine.entities.builder.WrapperGameObject;
import gameengine.entities.texture.Texture;
import gameengine.input.UserEvent;
import gameengine.physic.Point2D;
import gameengine.render.Camera;
import gameengine.world.Level;
import gameengine.world.builder.BuilderLevel;
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
		Level l = BuilderLevel.buildLevel("test", "lvl1.txt",1);
		
		/*for (int i = 0; i < 0; i++) {
			for (int j = 0; j < 0; j++) {
				GameObject gameObject = BuilderGameObject.createGameObject()
						.at(new Point2D(i, j))
						.with(new Dimension2D(32, 32))
						.with(new Texture());
				l.addGameObject(gameObject);
			}
		}*/

//		GameObject gameObject = BuilderGameObject.createGameObject()
//				.at(new Point2D(1.0, 1.0))
//				.with(new Dimension2D(32, 32))
//				.with(new Texture("57"))
//				.with(new Point2D(0.0,0.0));
//		
//		GameObject gameObject2 = BuilderGameObject.createGameObject()
//				.at(new Point2D(2.0, 2.0))
//				.with(new Dimension2D(32, 32))
//				.with(new Texture("57"))
//				.is("Test");
//		gc = gameObject;
//		System.out.println(l.getLstGameObject());
//		l.addGameObject(gameObject, gameObject2);
		
		getGameWorld().setLevel(l);
		
	}
	
	@Override
	public void initGameObject() {
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("0",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				
				return BuilderGameObject.createGameObject()
						.with(new Dimension2D(32, 32))
						.with(new Texture("57"))
						.is("Test");
			}
		}));
		
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("1",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				
				return BuilderGameObject.createGameObject()
						.with(new Dimension2D(32, 32))
						.with(new Texture("cactus"))
						.is("Test");
			}
		}));
	}
	
	@Override
	public void initCamera(Camera camera) {
		gc = getGameWorld().getLevel().getLstGameObject().get(0);
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
		getInput().addEvent(new UserEvent("gauche") {
			
			@Override
			public void onUpdate() {
				gc.with(new Point2D(-0.05,0.0));
			}
			
			@Override
			public void onEnd() {
				gc.with(new Point2D(0.0,0.0));
			}
			
			@Override
			public void onBegin() {
				
			}
		}, KeyCode.Q);
		
		getInput().addEvent(new UserEvent("reculer") {
			
			@Override
			public void onUpdate() {
				gc.with(new Point2D(0.0,0.05));
			}
			
			@Override
			public void onEnd() {
				gc.with(new Point2D(0.0,0.0));
			}
			
			@Override
			public void onBegin() {
				
			}
		}, KeyCode.S);
		getInput().addEvent(new UserEvent("droite") {
			
			@Override
			public void onUpdate() {
				gc.with(new Point2D(0.05,0.0));
			}
			
			@Override
			public void onEnd() {
				gc.with(new Point2D(0.0,0.0));
			}
			
			@Override
			public void onBegin() {
				
			}
		}, KeyCode.D);
		getInput().addEvent(new UserEvent("devant") {
			
			@Override
			public void onUpdate() {
				gc.with(new Point2D(0.0,-0.05));
			}
			
			@Override
			public void onEnd() {
				
			}
			
			@Override
			public void onBegin() {
				
			}
		}, KeyCode.Z);
		
	}

}
