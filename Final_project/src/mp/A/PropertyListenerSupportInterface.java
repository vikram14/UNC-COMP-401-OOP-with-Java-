package mp.A;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public interface PropertyListenerSupportInterface {
	public void removeElement( PropertyChangeListener k);
	public void notifyAllListeners(PropertyChangeEvent evt);
	public void elementAt(int i);
	public void addElement(PropertyChangeListener pcl);
	public List<PropertyChangeListener> returnList();
}
