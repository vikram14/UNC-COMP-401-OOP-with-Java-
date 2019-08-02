package mp;
import util.annotations.Tags;
@Tags({"Word"})
public class Word extends Token implements WordInterface {

	public Word(String s) {
		super(s);
	}

	public String getValue() {
		Value=Input.toLowerCase();
		return Value;
	}
}
