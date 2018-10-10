package mp.A;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.OVAL_PATTERN )
public class Circle implements CircleInterface{
	static final int circle_diameter=100; int x=500,y;
	public Circle() {
		y=Gorge.hbridgeY;
	}
	public void setX(int newVal) {x=newVal;}
	public void setY(int newVal) {y=newVal;}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getHeight() {return circle_diameter;}
	public int getWidth() {return circle_diameter;}
	public void move(int x, int y) {
		setX(getX()+x);
		setY(getY()+y);
	}
}
