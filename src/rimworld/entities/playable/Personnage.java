package rimworld.entities.playable;

import rimworld.entities.item.Ressource;
import rimworld.entities.item.Tool;
import rimworld.entities.spec.Gear;
import rimworld.entities.spec.ID;

public class Personnage extends Playable {
	private ID id;

	public ID getId() {
		return id;
	}

	public Personnage with(ID id) {
		this.id = id;
		return this;
	}
	public Personnage with(Gear gear) {
		this.gear = gear;
		return this;
	}
	public Personnage addRessource(Ressource... r) {
		for (Ressource rs : r) {
			this.lstRessource.add(rs);
		}
		return this;
	}
	public Personnage removeRessource(Ressource... r) {
		for (Ressource rs : r) {
			this.lstRessource.remove(rs);
		}
		return this;
	}
	public Personnage addTool(Tool... t) {
		for (Tool ts : t) {
			this.lstTool.add(ts);
		}
		return this;
	}
	public Personnage removeTool(Tool... t) {
		for (Tool ts : t) {
			this.lstTool.remove(ts);
		}
		return this;
	}

}
