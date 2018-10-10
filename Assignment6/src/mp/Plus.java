package mp;
import util.annotations.Tags;
@Tags({"Plus"})
public class Plus implements TokenInterface {
	String Input;
	public Plus(String s) {
		Input=s;
	}
	public void setInput(String str) {
		Input=str;
	}
	public String getInput() {
		return Input;
	}
}
