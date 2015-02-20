public class WCIntegration{
	private String[] options;
	WCIntegration(String[] options){
		this.options = options;
	}

	public String evaluate(){
		return "wc: invalid option -- k";
	}
}