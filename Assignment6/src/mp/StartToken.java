package mp;
import util.annotations.Tags;
@Tags({"Start"})
public class StartToken implements TokenInterface {
	String Input;
	public StartToken(String s) {
		Input=s;
	}
	public void setInput(String str) {
		Input=str;
	}
	public String getInput() {
		return Input;
	}
}
