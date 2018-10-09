package rimworld.entities;

import gameengine.entities.GameObject;

public abstract class GameObjectRimWorld{
	protected int lifeleft;

	public int getLifeleft() {
		return lifeleft;
	}

	public void setLifeleft(int lifeleft) {
		this.lifeleft = lifeleft;
	}
}
