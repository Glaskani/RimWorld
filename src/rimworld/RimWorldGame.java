package rimworld;

import gameengine.app.GameApp;
import gameengine.app.GameSetting;
import gameengine.entities.GameObject;
import gameengine.entities.builder.BuilderGameObject;
import gameengine.entities.builder.BuilderGameObjectFactory;
import gameengine.entities.builder.WrapperGameObject;
import gameengine.entities.texture.Texture;
import gameengine.input.UserEvent;
import gameengine.particule.Emitter;
import gameengine.particule.FireEmitter;
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
		setting.setWidth(1720);
		setting.setHeight(880);
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
						.is("Test")
						.with(0);
			}
		}));
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("1",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				
				return BuilderGameObject.createGameObject()
						.with(new Dimension2D(32, 32))
						.with(new Texture("cactus"))
						.is("Test")
						.with(4);
			}
		}));
		gc = BuilderGameObject.createGameObject()
				.with(new Dimension2D(32, 32))
				.with(new Texture("bonjour"))
				.is("Perso")
				.with(4);
				
				
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("3",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				
				return gc;
			}
		}));
	}
	@Override
	public void initParticle() {
		Emitter feu = new FireEmitter();
		feu.at(new Point2D(1.0,1.0)).with(8).with(new Point2D(0.0,0.0));
		System.out.println(getManager());
		getManager().getParticuleEngine().addEmitter(feu);
		
	}
	@Override
	public void initCamera(Camera camera) {
		camera.setPosition(gc.getPosition());
		camera.setGameObjectBinded(gc);
	}
	@Override
	public void initTest() {
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void initInput() {
		getInput().addEvent(new UserEvent("ZoomOut") {
			@Override
			public void onUpdate() {
				getManager().getCamera().setZoom(getManager().getCamera().getZoom()-0.1);
			}
			@Override
			public void onEnd() {
			}
			@Override
			public void onBegin() {
				getManager().getCamera().setZoom(getManager().getCamera().getZoom()-0.1);
			}
		}, KeyCode.SUBTRACT);
		getInput().addEvent(new UserEvent("ZoomIn") {
			@Override
			public void onUpdate() {
				getManager().getCamera().setZoom(getManager().getCamera().getZoom()+0.1);
			}
			@Override
			public void onEnd() {
			}
			@Override
			public void onBegin() {
				getManager().getCamera().setZoom(getManager().getCamera().getZoom()+0.1);
			}
		}, KeyCode.ADD);
		getInput().addEvent(new UserEvent("Left") {
			@Override
			public void onUpdate() {
			}
			@Override
			public void onEnd() {
				gc.getVelocity().sub(-0.05,0.0);
			}
			@Override
			public void onBegin() {
				gc.getVelocity().add(-0.05,0.0);
			}
		}, KeyCode.Q);
		getInput().addEvent(new UserEvent("Down") {
			@Override
			public void onUpdate() {
			}
			@Override
			public void onEnd() {
				gc.getVelocity().sub(0.0,0.05);
			}
			@Override
			public void onBegin() {
				gc.getVelocity().add(0.0,0.05);
			}
		}, KeyCode.S);
		getInput().addEvent(new UserEvent("Right") {
			@Override
			public void onUpdate() {
			}
			@Override
			public void onEnd() {
				gc.getVelocity().sub(0.05,0.0);
			}
			@Override
			public void onBegin() {
				gc.getVelocity().add(0.05,0.0);
			}
		}, KeyCode.D);
		getInput().addEvent(new UserEvent("Up") {
			@Override
			public void onUpdate() {
			}
			@Override
			public void onEnd() {
				gc.getVelocity().sub(0.0,-0.05);
			}
			@Override
			public void onBegin() {
				gc.getVelocity().add(0.0,-0.05);
			}
		}, KeyCode.Z);
	}

}
