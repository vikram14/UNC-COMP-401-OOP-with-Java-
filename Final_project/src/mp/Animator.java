package mp;

import mp.A.AngleShapeInterface;
import mp.A.AvatarInterface;
import mp.A.BridgeScene;
import util.annotations.Tags;
import util.misc.ThreadSupport;
@Tags("Animator")
public class Animator {
	final static double CLOSE=Math.PI/2, ANG1=3*Math.PI/4,ANG2=Math.PI/4;
	int xStep=10, yStep=0;
	@Tags("animateAvatar")
	public synchronized void animateAvatar(AvatarInterface av) {
		if(av.getHead().getImageFileName().equals(BridgeScene.GUARD_IMAGEFFILE)) {
			int k=0;
			while(k<=10) {
				close(av.getArms(),-Math.PI/2);
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
				close(av.getLegs(),CLOSE);
				av.move(xStep,yStep);
				ThreadSupport.sleep(80);
				open(av.getLegs(),ANG1,ANG2);
				ThreadSupport.sleep(120);
				i++;
			}
			open(av.getLegs(),ANG1,ANG2);
		}
	}
	public synchronized void close(AngleShapeInterface as,double ang) {
		as.getLeftLine().setAngle(ang);
		as.getRightLine().setAngle(ang);
	}
	public synchronized void open(AngleShapeInterface as,double ang1,double ang2) {
		as.getLeftLine().setAngle(ang1);
		as.getRightLine().setAngle(ang2);
	}
}
