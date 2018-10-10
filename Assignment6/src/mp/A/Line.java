package mp.A;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"RotatingLine"})
public interface Line {	
    public int getX(); 
    public void setX(int newVal);
    public int getY();
    public void setY(int newVal);
    public int getWidth();
    public void setWidth(int newVal);
    public int getHeight() ;
    public void setHeight(int newVal);
    @Tags({"rotate"})
    public void rotate(int newVal);
    public double getRadius();
    public void setRadius(double newVal);
    public double getAngle();
    public void setAngle(double newVal);
}
