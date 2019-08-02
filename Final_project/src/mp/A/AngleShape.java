package mp.A;

import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@ StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({"Angle"})
@PropertyNames({"LeftLine","RightLine"})
public class AngleShape implements AngleShapeInterface {
	Line leftLine,rightLine; static final double RAD=100.0, ANG1=3*Math.PI/4,ANG2=Math.PI/4;static final int INITX=70,INITY=50;

    public AngleShape() {
    	leftLine=new RotatingLine(RAD,ANG1,INITX,INITY);
    	rightLine=new RotatingLine(RAD,ANG2,INITX,INITY);
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
