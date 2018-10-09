package rimworld.entities.playable;

import java.util.List;

import rimworld.entities.GameObjectRimWorld;
import rimworld.entities.item.Ressource;
import rimworld.entities.item.Tool;
import rimworld.entities.spec.Gear;

public class Playable extends GameObjectRimWorld {
	protected Gear gear;
	protected List<Tool> lstTool;
	protected List<Ressource> lstRessource;
	
	public Gear getGear() {
		return gear;
	}
	public List<Tool> getLstTool() {
		return lstTool;
	}
	public List<Ressource> getLstRessource() {
		return lstRessource;
	}

}
