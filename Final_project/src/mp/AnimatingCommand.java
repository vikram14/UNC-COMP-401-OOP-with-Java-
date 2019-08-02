package mp;

import mp.A.AvatarInterface;
import util.annotations.Tags;
@Tags("AnimatingCommand")
public class AnimatingCommand implements Runnable{
	AvatarInterface av; Animator ani; boolean waiting;BroadcastingClearanceManager bcm;
	public AnimatingCommand(Animator an,AvatarInterface a, boolean w){
		av=a;
		ani=an;
		waiting=w;
	    bcm= SingletonsCreator.createManager();
	}
	@Override
	public void run() {
		if(waiting)
			bcm.waitForProceed();
		ani.animateAvatar(av);
	}

}
