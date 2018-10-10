package mp.A;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@ StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Angle"})
@PropertyNames({"LeftLine","RightLine"})
public class AngleShape implements AngleShapeInterface {
	Line leftLine,rightLine;

    public AngleShape() {
    	leftLine=new RotatingLine(100.0,3*Math.PI/4,70,50);
    	rightLine=new RotatingLine(100.0,Math.PI/4,70,50);
    }
	
	public Line getLeftLine() {
		return leftLine;
	}

	
	public Line getRightLine() {
		return rightLine;
	}
	
	public void move(int x, int y) {
		getLeftLine().setX(getLeftLine().getX()+x);
		getLeftLine().setY(getLeftLine().getY()+y);
		getRightLine().setX(getRightLine().getX()+x);
		getRightLine().setY(getRightLine().getY()+y);

	}

}
