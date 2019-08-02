package mp;

import mp.A.AvatarInterface;
import util.annotations.Tags;
@Tags("RotateRightArmCommand")
public class RotateRightArmCommand implements Runnable{
	AvatarInterface av; int k;
	public RotateRightArmCommand(AvatarInterface a,int r) {
		av=a;
		k=r;
	}

	@Override
	public void run() {
		av.getArms().getRightLine().rotate(k);
	}
}
