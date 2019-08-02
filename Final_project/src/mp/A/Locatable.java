package mp.A;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import util.annotations.PropertyNames;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@PropertyNames({"X","Y"})
@Tags("Locatable")
public class Locatable implements LocatableInterface,PropertyListenerRegisterer {
	PropertyListenerSupportInterface pls= new PropertyListenerSupport();
	int x,y;
	public void setX(int val) {
		int oldX=x;
		x=val;
		pls.notifyAllListeners(new PropertyChangeEvent(this,"X",oldX,getX()));
	}
	public void setY(int val) {
		int oldY=y;
		y=val;
		pls.notifyAllListeners(new PropertyChangeEvent(this,"Y",oldY,getY()));
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pls.addElement(pcl);
	}
	public List<PropertyChangeListener> getPropertyChangeListeners () {
		return pls.returnList();
	}
}
