public class WordCount{
	private String str;
	public WordCount(String str){
		this.str = str;
	}

	public int countWords(){
		String[] words = str.split("\\s+");
		return words.length;
	}

	public int countChars(){
		return str.getBytes().length;
	}
}