import java.util.ArrayList;
import java.io.*;

public class WCLibrary{
	private String str;
	public WCLibrary(String str){
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

	public int countNewLines(String str){
		int count = 0;
		for(int i=0; i<str.length(); i++){
			if(str.charAt(i) == '\n')
				count++;
		}
		return count;
	}

	public int countMaxLine(){
		String[] lines = str.split("\n");
		int maxLength = 0;
		for(int i=0; i<lines.length; i++){
			if(lines[i].length() > maxLength)
				maxLength = lines[i].length();
		}
		return maxLength;
	}

	public boolean optionChecker(String option){
		ArrayList<String> options = new ArrayList<String>(5);
		String[] str = {"-l","-w","-c","-L","--help"};
		for (int i=0; i<str.length; i++) {
			options.add(str[i]);
		}
		return options.indexOf(option) >= 0;
	}

	public boolean dashChecker(String option){
		return option.matches("-.*");
	};

	public int optionHandler(String option){
		switch(option){
			case "-l":
				return countLines();
			case "-w":
				return countWords();
			case "-c":
				return countChars();
			case "-L":
				return countMaxLine();
			default:
				return 0;
		}
	}
}

class MyFileReader{
	private String fileName;

	MyFileReader(String fileName){
		this.fileName = fileName;
	}

	public String readFile(){
		String content = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = br.readLine()) != null){
				sb.append(line);
            	sb.append("\n");
			}
			br.close();
			content = sb.toString();
		}
		catch(Exception e){
			System.out.println("wc: "+ fileName +": No such file or directory");
		}
		return content;
	}
}