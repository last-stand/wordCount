public class WordCount{
	private String str;
	public WordCount(String str){
		this.str = str;
	}

	public int countWords(){
		if(str == "") return 0;
		String[] words = str.split("\\s+");
		return words.length;
	}

	public int countChars(){
		return str.length();
	}

	public int countLines(){
		return countNewLines(str);
	}

	public static int countNewLines(String str){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '\n')
				count++;
		}
		return count;
	}
}