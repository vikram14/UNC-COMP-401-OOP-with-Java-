package mp;

public class Token implements TokenInterface{
	String Input,Value;
    
    public Token(String str) {
    	setInput(str);
    }
	public void setInput(String str) {
		Input=str;
	}

	public String getInput() {
		return Input;
	}

}
