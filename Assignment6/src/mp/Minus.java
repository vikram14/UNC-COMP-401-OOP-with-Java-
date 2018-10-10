package mp;
import util.annotations.Tags;
@Tags({"Minus"})
public class Minus implements TokenInterface {
	String Input;
	public Minus(String s) {
		Input=s;
	}
	public void setInput(String str) {
		Input=str;
	}
	public String getInput() {
		return Input;
	}
}
