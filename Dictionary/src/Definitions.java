public class Definitions {
	private String definition; 
	private String partOfSpeech;
	
	public Definitions(String definition, String partOfSpeech) {
		this.definition = definition; 
		this.partOfSpeech = partOfSpeech; 
	}
	
	public void setDefintions(String definition) {
		this.definition = definition; 
	}
	
	public String getDefinition() {
		return this.definition;
	}
	
}