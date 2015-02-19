import org.junit.Test;
import static org.junit.Assert.*;

public class WCTest {

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_spaces() {
    	String str = "hello, this is a good day.";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 6, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_tabs() {
    	String str = "hello,	this is a good	day.";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 6, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_tabs_and_spaces() {
    	String str = "hello,	this 	is a 	good	day.";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 6, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_newLines() {
    	String str = "Twinkle, twinkle, little star"+
			    	 "\nHow I wonder what you are"+
			    	 "\nUp above the world so high"+
			    	 "\nLike a diamond in the sky";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 22, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_carriage_return(){
    	String str = "Jack and Jill went up the hill"+
			    	 "\r\nTo fetch a pail of water."+
			    	 "\r\nJack fell down and broke his crown,"+
			    	 "\r\nAnd Jill came tumbling after";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 25, wc.countWords());
    }

    @Test
    public void countWords_should_count_number_of_words_in_given_string_excluding_all_WhiteSpaces_and_tabs() {
    	String str = "Twinkle,	twinkle, 	little star"+
			    	 "\r\nHow I wonder what you are"+
			    	 "\nUp above the	world 	so high"+
			    	 "\nLike a diamond  in the sky";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 22, wc.countWords());
    }

    @Test
    public void countWords_treats_number_as_word(){
		String str1 = "10";
		String str2 = "007 420 1001";
		WCLibrary wc1 = new WCLibrary(str1);
		WCLibrary wc2 = new WCLibrary(str2);
		assertSame("should be same", 1, wc1.countWords());
		assertFalse("failure - should be false", 0 == wc1.countWords());
		assertSame("should be same", 3, wc2.countWords());
		assertFalse("failure - should be false", 0 == wc2.countWords());
	};

	@Test
    public void countWords_treats_special_characters_as_word(){
		String str1 = "@";
		String str2 = "+-*/ #@&$ .,<>";
		WCLibrary wc1 = new WCLibrary(str1);
		WCLibrary wc2 = new WCLibrary(str2);
		assertSame("should be same", 1, wc1.countWords());
		assertFalse("failure - should be false", 0 == wc1.countWords());
		assertSame("should be same", 3, wc2.countWords());
		assertFalse("failure - should be false", 0 == wc2.countWords());
	};

	@Test
    public void countWords_should_return_0_if_string_is_empty(){
    	String str = "";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 0, wc.countWords());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_with_spaces() {
    	String str = "hello, this is a good day.";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 26, wc.countChars());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_with_tabs() {
    	String str = "hello, 	this is a good 	day.	";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 29, wc.countChars());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_including_newLines() {
    	String str = "Twinkle, twinkle, little star"+
			    	 "\nHow I wonder what you are"+
			    	 "\nUp above the world so high"+
			    	 "\nLike a diamond in the sky";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 108, wc.countChars());
    }

    @Test
    public void countChars_should_count_number_of_characters_in_given_string_with_all_WhiteSpaces_and_tabs() {
    	String str = "Twinkle,	twinkle, 	little star"+
			    	 "\r\nHow I wonder what you are"+
			    	 "\nUp above the	world 	so high"+
			    	 "\nLike a diamond  in the sky";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 112, wc.countChars());
    }

    @Test
    public void countChars_should_return_0_if_string_is_empty(){
    	String str = "";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 0, wc.countChars());
    }

    @Test
    public void countNewLines_returns_0_if_given_string_has_one_line_without_new_line(){
    	String str = "My name is Khan.";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 0, wc.countNewLines(str));
    }

    @Test
    public void countNewLines_returns_number_of_new_lines_from_the_given_string(){
    	String str1 = "My name is Khan.\n";
    	String str2 = "My name is Khan.\n And I am not a terrorist.\n";
    	WCLibrary wc1 = new WCLibrary(str1);
    	WCLibrary wc2 = new WCLibrary(str2);
    	assertSame("should be same", 1, wc1.countNewLines(str1));
    	assertSame("should be same", 2, wc2.countNewLines(str2));
    }

    @Test
    public void countNewLines_returns_all_occurences_of_new_line_from_string(){
    	String str = "My name is Khan.\r\n \r\n \r\n \r\n  And I am not a terrorist.\r\n \r\n";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 6, wc.countNewLines(str));
    }

    @Test
    public void countLines_returns_0_if_given_string_has_one_line_without_new_line(){
    	String str1 = "My name is Khan.";
    	String str2 = "My name is Khan.\n";
    	WCLibrary wc1 = new WCLibrary(str1);
    	WCLibrary wc2 = new WCLibrary(str2);
    	assertSame("should be same", 0, wc1.countLines());
    	assertFalse("failure - should be false", 0 == wc2.countLines());
    }

    @Test
    public void countLines_returns_number_of_lines_if_given_string_has_lines_with_new_line(){
    	String str1 = "My name is Khan.\n";
    	String str2 = "My name is Khan. \n And I am not a terrorist";
    	WCLibrary wc1 = new WCLibrary(str1);
    	WCLibrary wc2 = new WCLibrary(str2);
    	assertSame("should be same", 1, wc1.countLines());
    	assertSame("should be same", 1, wc2.countLines());
    	assertFalse("failure - should be false", 2 == wc2.countLines());
    }

    @Test
    public void countLines_returns_all_occurences_of_new_line_from_string(){
    	String str = "My name is Khan.\r\n\r\n\r\n\r\nAnd I am not a terrorist.\r\n\r\n";
    	WCLibrary wc = new WCLibrary(str);
    	assertSame("should be same", 6, wc.countLines());
    }
}