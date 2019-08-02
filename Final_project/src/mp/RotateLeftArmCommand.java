package mp;

import mp.A.AvatarInterface;
import util.annotations.Tags;
@Tags("RotateLeftArmCommand")
public class RotateLeftArmCommand implements Runnable{
	AvatarInterface av; int k;
	public RotateLeftArmCommand(AvatarInterface a,int r) {
		av=a;
		k=r;
	}

	@Override
	public void run() {
		av.getArms().getLeftLine().rotate(k);
	}
}

