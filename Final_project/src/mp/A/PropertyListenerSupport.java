package mp.A;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class PropertyListenerSupport implements PropertyListenerSupportInterface {
	List<PropertyChangeListener> propertyChangeListeners =new ArrayList<PropertyChangeListener>();
	public void addElement(PropertyChangeListener k) {
		propertyChangeListeners.add(k);
	}
	public void removeElement( PropertyChangeListener k) {
		propertyChangeListeners.remove(k);
	}
	public void elementAt(int i) {
		propertyChangeListeners.get(i);
	}
	public void notifyAllListeners(PropertyChangeEvent evt) {
		for(PropertyChangeListener pcl :propertyChangeListeners ) {
			pcl.propertyChange(evt);
		}
	}
	public List<PropertyChangeListener> returnList() {
		return propertyChangeListeners;
	}
}
