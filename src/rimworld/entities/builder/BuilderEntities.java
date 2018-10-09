package rimworld.entities.builder;

import rimworld.entities.evironement.Decor;
import rimworld.entities.evironement.Material;
import rimworld.entities.evironement.builder.BuilderDecor;
import rimworld.entities.evironement.builder.BuilderMaterial;
import rimworld.entities.item.Ressource;
import rimworld.entities.item.Tool;
import rimworld.entities.item.builder.BuilderRessource;
import rimworld.entities.item.builder.BuilderTool;
import rimworld.entities.playable.Animal;
import rimworld.entities.playable.Ennemie;
import rimworld.entities.playable.Personnage;
import rimworld.entities.playable.builder.BuilderAnimal;
import rimworld.entities.playable.builder.BuilderEnnemie;
import rimworld.entities.playable.builder.BuilderPersonnage;
import rimworld.entities.worldobject.Furniture;
import rimworld.entities.worldobject.Utilitie;
import rimworld.entities.worldobject.builder.BuilderFurniture;
import rimworld.entities.worldobject.builder.BuilderUtilitie;

public class BuilderEntities {
	
	public static Material createMaterial() {
		return BuilderMaterial.createMaterial();
	}
	public static Decor createDecor() {
		return BuilderDecor.createDecor();
	}
	public static Tool createTool() {
		return BuilderTool.createTool();
	}
	public static Ressource createRessource() {
		return BuilderRessource.createRessource();
	}
	public static Animal createAnimal() {
		return BuilderAnimal.createAnimal();
	}
	public static Ennemie createEnnemie() {
		return BuilderEnnemie.createEnnemie();
	}
	public static Personnage createPersonnage() {
		return BuilderPersonnage.createPersonnage();
	}
	public static Furniture createFurniture() {
		return BuilderFurniture.createFurniture();
	}
	public static Utilitie createUtilitie() {
		return BuilderUtilitie.createUtilitie();
	}
	
}
