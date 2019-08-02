package mp;

import java.beans.PropertyChangeListener;


import java.lang.Thread;
import util.annotations.ComponentWidth;
import util.annotations.Row;
import util.annotations.Tags;
import util.models.AListenableVector;
import util.models.ListenableVector;
import bus.uigen.ObjectEditor;
import mp.A.PropertyListenerSupport;
import mp.A.PropertyListenerSupportInterface;
/*
 Does the println after notify ever not follow the println before notify?
 Does the println after wait ever not follow the println before wait?
 Does the wait ended message ever not follow wait started?
 Does the same thread ever execute both wait and notify?
 */
@Tags("ClearanceManager")
public class AClearanceManager implements ClearanceManager {
	ListenableVector waitingThreads = new AListenableVector<>();
	PropertyListenerSupportInterface propertyListenerSupport = new PropertyListenerSupport();
	@Row(0)
	@ComponentWidth(100)
	public synchronized void proceed() {
		System.out.println( Thread.currentThread() + ": before notify");
		notify(); // Defined in call Object. Hover over it to see its explanation. Think of a monitor as simply an object.
		System.out.println( Thread.currentThread() + ": after notify");
	}
	public 
//		 Comment out the synchronized keyword. What error do you get? 
		synchronized 
			void waitForProceed() {
			try {
				String aThreadID = Thread.currentThread().toString();
				System.out.println( aThreadID + ": before wait");
				waitingThreads.addElement(aThreadID);
				wait(); // Defined in call Object. Hover over it to see its explanation. Think of a monitor as simply an object.
				System.out.println( aThreadID + ": after wait");
				waitingThreads.removeElement(aThreadID);
			} catch (Exception e) {
				e.printStackTrace();
			}
//		}
	}
	@Row(2)
	public ListenableVector getWaitingThreads() {
		return waitingThreads;

	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		propertyListenerSupport.addElement(arg0);
	}

}
