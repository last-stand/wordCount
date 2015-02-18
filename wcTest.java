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
    public void countWords_should_count_number_of_words_in_given_string_excluding_allWhiteSpaces_and_tabs() {
    	String str = "Twinkle,	twinkle, 	little star"+
			    	 "\r\nHow I wonder what you are"+
			    	 "\nUp above the	world 	so high"+
			    	 "\nLike a diamond  in the sky";
    	WordCount wc = new WordCount(str);
    	assertSame("should be same", 22, wc.countWords());
    }
}