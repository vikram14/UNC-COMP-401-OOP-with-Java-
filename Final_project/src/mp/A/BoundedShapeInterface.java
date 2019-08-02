package mp.A;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.Tags;

@Tags("BoundedShape")
public interface BoundedShapeInterface {
	public void setX(int val);
	public void setY(int val);
	public int getX();
	public int getY();
	public int getWidth();
    public void setWidth(int newVal);
    public int getHeight();
    public void setHeight(int newVal);
    public void addPropertyChangeListener(PropertyChangeListener pcl);
    public List<PropertyChangeListener> getPropertyChangeListeners ();
}
