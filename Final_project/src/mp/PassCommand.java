package mp;


import mp.A.BridgeSceneInterface;
import util.annotations.Tags;
@Tags("PassCommand")
public class PassCommand implements Runnable {
	BridgeSceneInterface bs1; 
	public PassCommand(BridgeSceneInterface bs) {
		bs1=bs;
	}

	@Override
	public void run() {
		bs1.passed();
	}

}
