package mp;

import mp.A.AvatarInterface;
import util.annotations.Tags;
@Tags("CoordinatedAnimationCommand")
public class CoordinatedAnimationCommand extends AnimatingCommand {
	public CoordinatedAnimationCommand(CoordinatedAnimator an, AvatarInterface a) {
		super(an, a, true);
	}
	@Override
	public void run() {
	//	bcm.waitForProceed();
	    ((CoordinatedAnimator)ani).animateAvatar(av);
		
	}

}
