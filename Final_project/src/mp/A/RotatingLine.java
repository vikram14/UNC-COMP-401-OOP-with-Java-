package mp.A;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@ StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"RotatingLine"})
public class RotatingLine extends BoundedShape implements Line{
	double radius, angle;
	public RotatingLine() {//double r, double a, int xa, int ya) {
		setRadius(0.0);
		setAngle(0.0);
		setX(0);
		setY(0);
		setWidth((int)Math.round ((getRadius()*Math.cos(getAngle()))));
		setHeight((int)Math.round ((getRadius()*Math.sin(getAngle()))));
	}
	public RotatingLine(double r, double a, int xa, int ya) {
		setRadius(r);
		setAngle(a);
		setX(xa);
		setY(ya);
		setWidth((int)Math.round ((getRadius()*Math.cos(getAngle()))));
		setHeight((int)Math.round ((getRadius()*Math.sin(getAngle()))));
	}

	@Tags({"rotate"})
	public void rotate(int newVal) {
		setWidth((int)Math.round ((getRadius()*Math.cos(getAngle()+(Math.PI*newVal/(16))))));
		setHeight((int)Math.round ((getRadius()*Math.sin(getAngle()+(Math.PI*newVal/(16))))));	
		setAngle(getAngle()+(Math.PI*newVal/(16)));
	}	
	public double getRadius() {
		return radius;
	}	
	public void setRadius(double newVal) {
		radius=newVal;
		setWidth((int)Math.round ((getRadius()*Math.cos(getAngle()))));
		setHeight((int)Math.round ((getRadius()*Math.sin(getAngle()))));
	}	
	public double getAngle() {
		return angle;
	}	
	public void setAngle(double newVal) {
		angle=newVal;
		setWidth((int)Math.round ((getRadius()*Math.cos(getAngle()))));
		setHeight((int)Math.round ((getRadius()*Math.sin(getAngle()))));
	}	
}
