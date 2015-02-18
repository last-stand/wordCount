import org.junit.Test;
import static org.junit.Assert.*;

public class WCTest {

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_spaces() {
    	String str = "hello, this is a good day.";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 6, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_tabs() {
    	String str = "hello,	this is a good	day.";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 6, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_tabs_and_spaces() {
    	String str = "hello,	this 	is a 	good	day.";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 6, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_newLines() {
    	String str = "Twinkle, twinkle, little star"+
			    	 "\nHow I wonder what you are"+
			    	 "\nUp above the world so high"+
			    	 "\nLike a diamond in the sky";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 22, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_carriage_return(){
    	String str = "Jack and Jill went up the hill"+
			    	 "\r\nTo fetch a pail of water."+
			    	 "\r\nJack fell down and broke his crown,"+
			    	 "\r\nAnd Jill came tumbling after";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 25, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_all_WhiteSpaces_and_tabs() {
    	String str = "Twinkle,	twinkle, 	little star"+
			    	 "\r\nHow I wonder what you are"+
			    	 "\nUp above the	world 	so high"+
			    	 "\nLike a diamond  in the sky";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 22, wc.countWords());
    }

    @Test
    public void count_word_treats_number_as_word(){
		String str1 = "10";
		String str2 = "007 420 1001";
		WordCount wc1 = new WordCount(str1);
		WordCount wc2 = new WordCount(str2);
		assertSame("should be same", 1, wc1.countWords());
		assertFalse("failure - should be false", 0 == wc1.countWords());
		assertSame("should be same", 3, wc2.countWords());
		assertFalse("failure - should be false", 0 == wc2.countWords());
	};

	@Test
    public void count_word_treats_special_characters_as_word(){
		String str1 = "@";
		String str2 = "+-*/ #@&$ .,<>";
		WordCount wc1 = new WordCount(str1);
		WordCount wc2 = new WordCount(str2);
		assertSame("should be same", 1, wc1.countWords());
		assertFalse("failure - should be false", 0 == wc1.countWords());
		assertSame("should be same", 3, wc2.countWords());
		assertFalse("failure - should be false", 0 == wc2.countWords());
	};

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_with_spaces() {
    	String str = "hello, this is a good day.";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 26, wc.countChars());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_with_tabs() {
    	String str = "hello, 	this is a good 	day.	";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 29, wc.countChars());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_including_newLines() {
    	String str = "Twinkle, twinkle, little star"+
			    	 "\nHow I wonder what you are"+
			    	 "\nUp above the world so high"+
			    	 "\nLike a diamond in the sky";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 108, wc.countChars());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_with_all_WhiteSpaces_and_tabs() {
    	String str = "Twinkle,	twinkle, 	little star"+
			    	 "\r\nHow I wonder what you are"+
			    	 "\nUp above the	world 	so high"+
			    	 "\nLike a diamond  in the sky";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 112, wc.countChars());
    }
}