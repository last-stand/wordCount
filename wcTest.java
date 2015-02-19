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

    @Test
    public void optionChecker_returns_true_if_given_option_is_matched_with_array_of_options(){
        String[] option = {"-l","-w","--help"};
        WCLibrary wc1 = new WCLibrary(option[0]);
        WCLibrary wc2 = new WCLibrary(option[1]);
        WCLibrary wc3 = new WCLibrary(option[2]);
        assertTrue("option should be matched", wc1.optionChecker(option[0]));
        assertTrue("option should be matched", wc2.optionChecker(option[1]));
        assertTrue("option should be matched", wc3.optionChecker(option[2]));
    };

    @Test
    public void optionChecker_returns_false_if_given_option_is_not_matched_with_array_of_options(){
        String[] option = {"-u","-W","--HELP"};
        WCLibrary wc1 = new WCLibrary(option[0]);
        WCLibrary wc2 = new WCLibrary(option[1]);
        WCLibrary wc3 = new WCLibrary(option[2]);
        assertFalse("option should not be matched", wc1.optionChecker(option[0]));
        assertFalse("option should not be matched", wc2.optionChecker(option[1]));
        assertFalse("option should not be matched", wc3.optionChecker(option[2]));
    };

    @Test
    public void dashChecker_returns_true_if_it_matches_dash_in_the_starting_of_option(){
        String option1 = "--help";
        String option2 = "help";
        WCLibrary wc1 = new WCLibrary(option1);
        WCLibrary wc2 = new WCLibrary(option2);
        assertTrue("dash should be matched", wc1.dashChecker(option1));
        assertFalse("dash should not be matched", wc2.dashChecker(option2));
    }

    @Test
    public void dashChecker_returns_false_if_dash_is_at_the_end_of_option(){
        String option = "w-";
        WCLibrary wc = new WCLibrary(option);
        assertFalse("dash in end should not be matched", wc.dashChecker(option));
    }

    @Test
    public void optionHandler_returns_number_of_lines_in_given_text_with_l_option(){
        String option = "-l";
        String text1 = "Hello, my name is Raj.\n Naam to suna hi hoga.\n";
        String text2 = "\tHello, my name is Raj.\r\n";
        WCLibrary wc1 = new WCLibrary(text1);
        WCLibrary wc2 = new WCLibrary(text2);
        assertSame("should be same", 2, wc1.optionHandler(option));
        assertFalse("should not be same", 2 == wc2.optionHandler(option));
    }

    @Test
    public void optionHandler_returns_number_of_words_in_given_text_with_w_option(){
        String option = "-w";
        String text1 = "Cowards die many times before their death but brave dies once.";
        String text2 = "Impossible is the word in the dictionary of fools.";
        WCLibrary wc1 = new WCLibrary(text1);
        WCLibrary wc2 = new WCLibrary(text2);
        assertSame("should be same", 11, wc1.optionHandler(option));
        assertFalse("should not be true", 11 == wc2.optionHandler(option));
    }

    @Test
    public void optionHandler_returns_number_of_characters_in_given_text_with_c_option(){
        String option = "-c";
        String text1 = "Cowards die many times before their death but brave dies once.\r\n";
        String text2 = "Impossible is the word in the dictionary of fools.\r\n";
        WCLibrary wc1 = new WCLibrary(text1);
        WCLibrary wc2 = new WCLibrary(text2);
        assertSame("should be same", 64, wc1.optionHandler(option));
        assertFalse("should not be true", 64 == wc2.optionHandler(option));
    }

    @Test
    public void countMaxLine_returns_0__if_text_is_empty(){
        String text = "";
        WCLibrary wc = new WCLibrary(text);
        assertSame("should be same", 0, wc.countMaxLine());
    }

    @Test
    public void countMaxLine_returns_0_if_there_is_only_new_line(){
        String text = "\n\n\n";
        WCLibrary wc = new WCLibrary(text);
        assertSame("should be same", 0, wc.countMaxLine());
    }

    @Test
    public void countMaxLine_returns_number_of_characters_of_line_if_that_is_only_line_in_text(){
        String text1 = "A person who never made a mistake never tried anything new.";
        String text2 = "\tIn order to succeed, your desire for success should be greater than your fear of failure.\n";
        WCLibrary wc1 = new WCLibrary(text1);
        WCLibrary wc2 = new WCLibrary(text2);
        assertSame("should be same", 59, wc1.countMaxLine());
        assertFalse("should not be true", 59 == wc2.countMaxLine());
    }

    @Test
    public void countMaxLine_also_works_on_numbers(){
        String text1 = "007\n8976543210";
        String text2 = "980764";
        WCLibrary wc1 = new WCLibrary(text1);
        WCLibrary wc2 = new WCLibrary(text2);
        assertSame("should be same", 10, wc1.countMaxLine());
        assertFalse("should not be true", 10 == wc2.countMaxLine());
    }

    @Test
    public void countMaxLine_returns_number_of_characters_in_longtest_line_in_given_multiline_text(){
        String text1 = "I didn’t fail the test. "+
                    "\nI just found 100 ways to do it wrong.";
        String text2 = "The only way to do great work is to love what you do.\n";
        WCLibrary wc1 = new WCLibrary(text1);
        WCLibrary wc2 = new WCLibrary(text2);
        assertSame("should be same", 37, wc1.countMaxLine());
        assertFalse("should not be true", 37 == wc2.countMaxLine());
    }

    @Test
    public void readFile_should_return_null_if_wrong_fileName_is_passed(){
        String str = "hello, this is a good day.\n" + "What do you think?\n";
        MyFileReader mfr = new MyFileReader("one.txt");
        assertSame("strings are equal", 0, str.compareTo(mfr.readFile()));
    }

    @Test
    public void readFile_will_not_throw_any_exception_if_file_exists() { 
        MyFileReader mfr = new MyFileReader("one.txt");
        Exception ex = null;
        try{
            mfr.readFile();
        }
        catch (Exception e) {
            ex = e;
        }
        assertEquals(null,ex);
    }
}