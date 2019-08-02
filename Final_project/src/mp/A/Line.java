package mp.A;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"RotatingLine"})
public interface Line extends BoundedShapeInterface{	
	@Tags({"rotate"})
	public void rotate(int newVal);
	public double getRadius();
	public void setRadius(double newVal);
	public double getAngle();
	public void setAngle(double newVal);
}
