package rimworld.entities.item;

import rimworld.entities.GameObjectRimWorld;

public class Item extends GameObjectRimWorld {

	protected int stackMax;
	protected int stack;
	
	public int getStackMax() {
		return stackMax;
	}
	public void setStackMax(int stackMax) {
		this.stackMax = stackMax;
	}
	public int getStack() {
		return stack;
	}
	public void setStack(int stack) {
		this.stack = stack;
	}
}
