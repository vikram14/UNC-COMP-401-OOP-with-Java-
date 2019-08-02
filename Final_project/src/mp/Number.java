package mp;
import util.annotations.Tags;
@Tags({"Number"})
public class Number extends Token implements NumInterface{
 int intValue;
	public Number(String str) {
		super(str);
	}
	
	public int getValue() {
		 intValue=Integer.parseInt(Input);
		 return intValue;
	}

}
