package rimworld;

import java.io.IOException;
import java.util.logging.FileHandler;
//import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
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
import gameengine.physic.Dimension3D;
import gameengine.physic.Point2D;
import gameengine.physic.collision.HandleCollision;
import gameengine.physic.collision.aabb.AABB;
import gameengine.render.Camera;
import gameengine.world.Level;
import gameengine.world.builder.BuilderLevel;
import javafx.geometry.Point3D;
import javafx.scene.input.KeyCode;
import rimworld.entities.evironement.Material;
import rimworld.entities.evironement.builder.BuilderMaterial;
import rimworld.entities.spec.Surface;


public class RimWorldGame extends GameApp {
	GameObject gc;
	Emitter feu;
	private static final Logger LOGGER = Logger.getGlobal();
	
	
	@Override
	public void initSetting(GameSetting setting) {
		setting.setWidth(1720);
		setting.setHeight(880);
		setting.setTitle("Hello World!");
	}
	@Override
	public void initLevel() {
		Level l = BuilderLevel.buildLevel("test", "lvl1.txt",1);		
		getGameWorld().setLevel(l);
		
	}
	
	@Override
	public void initGameObject() {
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("0",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				return BuilderGameObject.createGameObject()
						.with(new Dimension3D(32.0, 32.0, 0.0))
						.with(new Texture("57"))
						.is("Test")
						.with(3.0);
			}
		}));
		Dimension3D d1 = new Dimension3D(32.0, 32.0,32.0);
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("1",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				return BuilderGameObject.createGameObject()
						.with(d1)
						.with(new Texture("cactus"))
						.is("test")
						.with(4.0)
						.with(new AABB(new Point3D(0.0, 0.0, 0.0),d1))
						.with(BuilderMaterial.createMaterial()
								.with(20)
								.with(Surface.WALL));
			}
		}));
		Dimension3D d = new Dimension3D(32.0, 32.0,32.0);
		gc = BuilderGameObject.createGameObject()
				.with(d)
				.with(new Texture("bonjour"))
				.is("personnage")
				.with(4.0)
				.with(new AABB(new Point3D(0.0, 0.0, 0.0),d))
				.with(BuilderMaterial.createMaterial()
						.with(18));
				
				
		BuilderLevel.addWrapperGameObject(new WrapperGameObject("3",new BuilderGameObjectFactory() {
			@Override
			public GameObject createGameObject() {
				
				return gc;
			}
		}));
	}
	@Override
	public void initParticle() {
		feu = new FireEmitter();
		feu.at(gc.getPosition()).with(8.0).with(new Point2D(0.0,0.0));		
		
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
		/*try {
            FileHandler hdl = new FileHandler("crash.log");
            hdl.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(hdl);
            
            Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> {
                LOGGER.log(Level.SEVERE,"Exeption Uncaught : ",e);
            });       
            launch(args);
        } catch (IOException | SecurityException ex) {
            Logger.getLogger(RimWorldGame.class.getName()).log(Level.SEVERE, null, ex);
        }*/		
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
		}, KeyCode.PAGE_DOWN);
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
		}, KeyCode.PAGE_UP);
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
	@Override
	public void initCollision() {
		getGameEngine().getCm().addHandleCollision(new HandleCollision("test","personnage") {
			@Override
			public void onCollisionEnd(GameObject g1, GameObject g2) {
				getManager().getParticuleEngine().removeEmitter(feu);
				System.out.println("EN");
			}
			@Override
			public void onCollisionBegin(GameObject g1, GameObject g2) {
				System.out.println("IN");
				getManager().getParticuleEngine().addEmitter(feu);
				Material m = (Material) g1.getObject();
				System.out.println("dkjfhgfjdgkjdfhgkjdfhgkjdfhgkldhfkjghdfklghdfk"+m.getLife()+m.getSurface());
			}
			@Override
			public void onCollision(GameObject g1, GameObject g2) {
				
			}
		});
	}
}
