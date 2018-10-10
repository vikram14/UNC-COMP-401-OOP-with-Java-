package mp;
import util.annotations.Tags;
@Tags({"Number"})
public class Number implements TokenInterface,NumInterface{
	String Input; int Value;
	public Number(String str) {
		Input= str;
	}
	public void setInput(String strNum) {
		Input=strNum;
	}
	public String getInput() {
		return Input;
	}
	
	public int getValue() {
		 Value=Integer.parseInt(Input);
		 return Value;
	}

}
