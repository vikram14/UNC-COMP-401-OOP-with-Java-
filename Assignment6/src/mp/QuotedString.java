package mp;
import util.annotations.Tags;
@Tags({"Quote"})
public class QuotedString implements TokenInterface {
	String Input;
	public QuotedString(String s) {
		Input=s;
	}
	public void setInput(String str) {
		Input=str;
	}
	public String getInput() {
		return Input;
	}

}
