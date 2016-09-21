package WordCountCommand;

public class WordCountResult {
	
	private int wordCount = 0;
	private int linesCount = 0;
	private int charactersCount = 0;
	
	public WordCountResult() {
	}
	
	public WordCountResult(int wordCount, int linesCount, int charactersCount){
		this.wordCount = wordCount;
		this.linesCount = linesCount;
		this.charactersCount = charactersCount;
	}
	
	public int getWordCount(){
		return wordCount;
	}
	
	public int getLinesCount(){
		return linesCount;
	}
	
	public int getCharactersCount(){
		return charactersCount;
	}
	
	public void setWordCount(int wordCount){
		this.wordCount = wordCount;
	}
	
	public void setLinesCount(int linesCount){
		this.linesCount = linesCount;
	}
	
	public void setCharactersCount(int charactersCount){
		this.charactersCount = charactersCount;
	}

}
