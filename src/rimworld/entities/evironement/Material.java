package rimworld.entities.evironement;

import rimworld.entities.GameObjectRimWorld;

import rimworld.entities.spec.Surface;
import rimworld.entities.spec.Type;

public class Material extends GameObjectRimWorld {
	private Type type;
	private Surface surface;
	private int life;
	
	public Material with(int life) {
		this.life = life;
		return this;
	}
	public Material with(Type ty) {
		type = ty;
		return this;
	}
	public Material with(Surface sur) {
		surface = sur;
		return this;
	}
	
	public int getLife() {
		return life;
	}
	public Type getType() {
		return type;
	}
	public Surface getSurface() {
		return surface;
	}
	
}
