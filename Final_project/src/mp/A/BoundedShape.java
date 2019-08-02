package mp.A;

import util.annotations.PropertyNames;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.beans.PropertyChangeEvent;
import util.models.PropertyListenerRegisterer;
import util.annotations.Tags;

@PropertyNames({"X","Y","Width","Height"})
@Tags("BoundedShape")
public class BoundedShape implements BoundedShapeInterface,PropertyListenerRegisterer {
	int x,y,width, height;
	PropertyListenerSupportInterface pls= new PropertyListenerSupport();

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
	public int getWidth() {
		return width;
	}
	public void setWidth(int newVal) {
		int oldWidth=width;
		width=newVal;
		pls.notifyAllListeners(new PropertyChangeEvent(this,"Width",oldWidth,getWidth()));
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int newVal) {
		int oldHeight=height;
		height=newVal;
		pls.notifyAllListeners(new PropertyChangeEvent(this,"Height",oldHeight,getHeight()));
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		pls.addElement(pcl);
	}
	public List<PropertyChangeListener> getPropertyChangeListeners () {
		return pls.returnList();
	}
}
