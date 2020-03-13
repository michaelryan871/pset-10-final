public class Words {
	private String word; 
	private Definitions[] definitions; 
	private String[] synonyms; 
	private String[] antonyms; 
	
	public Words(String word, Definitions[] definitions, String[] synonyms, String[] antonyms) {
		this.word = word;
		this.definitions = definitions; 
		this.synonyms = synonyms; 
		this.antonyms = antonyms; 
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
}