package mp;

import util.annotations.Tags;

@Tags("ProceedAllCommand")
public class ProceedAllCommand implements Runnable {
	BroadcastingClearanceManager bcm;
	public ProceedAllCommand() {
		bcm=SingletonsCreator.createManager();
	}

	@Override
	public void run() {
		bcm.proceedAll();
	}
}
