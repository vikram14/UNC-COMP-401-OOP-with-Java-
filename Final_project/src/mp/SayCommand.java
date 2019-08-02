package mp;

import mp.A.BridgeSceneInterface;
import util.annotations.Tags;
@Tags("SayCommand")
public class SayCommand implements Runnable {
	BridgeSceneInterface bs; String say;
	public SayCommand(BridgeSceneInterface b, String s) {
		bs=b;
		say=s;
	}

	public void run() {
		bs.say(say);
	}

}
