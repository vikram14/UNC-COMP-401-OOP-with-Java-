package mp;

import util.annotations.ComponentWidth;
import util.annotations.Row;
import util.annotations.Tags;
@Tags("BroadcastingClearanceManager")
public class ABroadcastingClearanceManager extends AClearanceManager 
					implements BroadcastingClearanceManager {

	@Row(1)
	@ComponentWidth(100)
	public synchronized void proceedAll() {
		notifyAll(); // not notify, hover over the method and see Java's explanation for it		
	}
}
