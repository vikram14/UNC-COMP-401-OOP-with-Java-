package mp;


import mp.A.BridgeSceneInterface;
import util.annotations.Tags;
@Tags("FailCommand")
public class FailCommand implements Runnable {
	BridgeSceneInterface bs1;
	public FailCommand(BridgeSceneInterface bs) {
		bs1=bs;
	}

	@Override
	public void run() {
		bs1.failed();
	}

}
