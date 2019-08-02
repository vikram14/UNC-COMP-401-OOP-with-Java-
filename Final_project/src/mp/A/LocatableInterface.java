package mp.A;

import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.Tags;

@Tags("Locatable")
public interface LocatableInterface {
	public void setX(int val);
	public void setY(int val);
	public int getX();
	public int getY();
	public void addPropertyChangeListener(PropertyChangeListener pcl);
	public List<PropertyChangeListener> getPropertyChangeListeners ();
}
