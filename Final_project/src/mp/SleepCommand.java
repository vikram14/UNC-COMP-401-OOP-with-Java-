package mp;

import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags("SleepCommand")
public class SleepCommand implements Runnable {
    long k;
	public SleepCommand(long r) {
		k=r;
	}

	@Override
	public void run() {
		ThreadSupport.sleep(k);
	}
}
