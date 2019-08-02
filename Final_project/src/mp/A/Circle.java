package mp.A;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.OVAL_PATTERN )
@Tags("Circle")
public class Circle extends BoundedShape implements CircleInterface{
	static final int CIRCLE_DIAM=100, INITX=500;
	public Circle() {
		x=INITX;
		y=Gorge.H_BRIDGE_Y;
		height=CIRCLE_DIAM;
		width=CIRCLE_DIAM;
	}
	public void move(int xdir, int ydir) {
		setX(getX()+xdir);
		setY(getY()+ydir);
	}
}
