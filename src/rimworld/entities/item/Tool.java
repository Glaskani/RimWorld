package rimworld.entities.item;

public class Tool extends Item {
	private String toolName;

	public String getToolName() {
		return toolName;
	}

	public Tool is(String toolName) {
		this.toolName = toolName;
		return this;
	}
	
	
	
}
