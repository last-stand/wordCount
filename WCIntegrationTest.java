import org.junit.Test;
import static org.junit.Assert.*;

public class WCIntegrationTest{
	@Test
    public void evaluate_should_return_error_message_if_invalid_option_is_passed_to_it(){
    	String[] args = {"-k"};
    	String str = "wc: invalid option -- k";
    	WCIntegration wci = new WCIntegration(args);
    	assertTrue("should be true",0 == str.compareTo(wci.evaluate()));
    }
}