package mp;

import mp.A.AvatarInterface;
import mp.A.BridgeScene;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags("CoordinatedAnimator")
public class CoordinatedAnimator extends Animator{
	BroadcastingClearanceManager bcm=SingletonsCreator.createManager();
	@Override
	@Tags("animateAvatar")
	public synchronized void animateAvatar(AvatarInterface av) {
		if(av.getHead().getImageFileName().equals(BridgeScene.GUARD_IMAGEFFILE)) {
			int k=0;
			while(k<=10) {
				close(av.getArms(),-Math.PI/2);
				bcm.proceedAll();
				ThreadSupport.sleep(200);
				open(av.getArms(),0.0,0.0);
				ThreadSupport.sleep(500);
				k++;
			}
			open(av.getArms(),ANG1,ANG2);
		}
		else {
			int i=0;
			while(i<=10) {
				bcm.waitForProceed();
				close(av.getLegs(),CLOSE);
				av.move(xStep,yStep);
				ThreadSupport.sleep(200);
				open(av.getLegs(),ANG1,ANG2);
				ThreadSupport.sleep(120);
				i++;
			}
			open(av.getLegs(),ANG1,ANG2);
		}
	}
}
