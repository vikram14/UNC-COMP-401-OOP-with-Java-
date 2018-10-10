package mp.A;

import util.annotations.PropertyNames;

@PropertyNames({"X","Y","Text"})

public class CharacterSpeak implements StringShape {
	String text;
	int x, y;

	public CharacterSpeak(String initText, int initX, int initY) {
		text = initText;
		x = initX;
		y = initY;
	}

	
	public int getX() {
		return x;
	}

	
	public void setX(int newX) {
		x=newX;
	}

	
	public int getY() {
		return y;
	}

	
	public void setY(int newY) {
		y=newY;
	}

	
	public String getText() {
		return text;
	}

	
	public void setText(String newVal) {
		text=newVal;
		System.out.println(text);
	}

}
