package mp;

import mp.A.AvatarInterface;
import mp.A.BridgeSceneInterface;
import util.annotations.Tags;
@Tags("ApproachCommand")
public class ApproachCommand implements Runnable {
	BridgeSceneInterface bs1; AvatarInterface a;
	public ApproachCommand(BridgeSceneInterface bs, AvatarInterface av) {
		bs1=bs;
		a=av;
	}

	@Override
	public void run() {
		bs1.approach(a);
	}

}
