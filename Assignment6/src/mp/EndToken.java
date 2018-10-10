package mp;
import util.annotations.Tags;
@Tags({"End"})
public class EndToken implements TokenInterface {
	String Input;
	public EndToken(String s) {
		Input=s;
	}
	public void setInput(String str) {
		Input=str;
	}
	public String getInput() {
		return Input;
	}
}
