package mp.A;

import java.beans.PropertyChangeEvent;

import util.annotations.PropertyNames;
import util.annotations.Tags;

@PropertyNames({"X","Y","Text"})
@Tags("CharacterSpeak")
public class CharacterSpeak extends Locatable implements StringShape {
	String text;

	public CharacterSpeak(String initText, int initX, int initY) {
		text = initText;
		x = initX;
		y = initY;
	}

	public String getText() {
		return text;
	}


	public void setText(String newVal) {
		String oldText=text;
		text=newVal;
		pls.notifyAllListeners(new PropertyChangeEvent(this,"Text",oldText,getText()));
		System.out.println(text);
	}

}
