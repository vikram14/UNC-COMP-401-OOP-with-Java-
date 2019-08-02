package mp;
import util.annotations.Tags;
@Tags({"Quote"})
public class QuotedString extends Token implements TokenInterface {

	public QuotedString(String s) {
		super(s);
	}
}
