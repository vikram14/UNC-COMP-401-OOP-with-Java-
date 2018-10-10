package mp;
import util.annotations.Tags;
@Tags({"Word"})
public class Word implements TokenInterface,WordInterface {


	String Input, Value;
	public Word(String s) {
		Input=s;
	}
	public void setInput(String str) {
		Input=str;
	}
	public String getInput() {
		return Input;
	}

	public String getValue() {
		Value=Input.toLowerCase();
		return Value;
	}
}
