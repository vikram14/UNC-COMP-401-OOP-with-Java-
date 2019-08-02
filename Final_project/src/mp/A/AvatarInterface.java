package mp.A;

import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags("Avatar")
public interface AvatarInterface {

	public ImageShape getHead();
	public StringShape getStringShape();
	public AngleShapeInterface getArms();
	public AngleShapeInterface getLegs();
	public Line getBody();
	public void scale(double s);
	public void align();
	public void move(int x,int y);
	public void addPropertyChangeListener(Line line, PropertyChangeListener pcl);
	public void addPropertyChangeListener(StringShape stringShape, PropertyChangeListener pcl);
	public void addPropertyChangeListener(AngleShapeInterface angle, PropertyChangeListener pcl);
}
