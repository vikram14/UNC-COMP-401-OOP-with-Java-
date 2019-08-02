package mp;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import mp.A.BridgeSceneInterface;
import util.annotations.Tags;

@Tags("BridgeSceneController")
public class BridgeSceneController implements BridgeSceneControllerInterface {
	int x,y; boolean mouseClicked=false; BridgeSceneInterface bs; Component obsp;
	public BridgeSceneController(Component c) {
		bs=SingletonsCreator.createBridgeScene();
		obsp=c;
		obsp.addKeyListener(this);
		obsp.addMouseListener(this);
		obsp.setFocusable(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		x= (int) (Math.round(arg0.getPoint().getX()));
		y=(int) (Math.round(arg0.getPoint().getY()));
		mouseClicked=true;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		char ch= arg0.getKeyChar();
		//if(mouseClicked) {
			switch (ch) {
			case 'a':
				bs.getArthur().move(x-bs.getArthur().getHead().getX(),y-bs.getArthur().getHead().getY());
				bs.getArthur().align();
				break;
			case 'g':
				bs.getGalahad().move(x-bs.getGalahad().getHead().getX(),y-bs.getGalahad().getHead().getY());
				bs.getGalahad().align();
				break;
			case 'r':
				bs.getRobin().move(x-bs.getRobin().getHead().getX(),y-bs.getRobin().getHead().getY());
				bs.getRobin().align();
				break;
			case 'l':
				bs.getLancelot().move(x-bs.getLancelot().getHead().getX(),y-bs.getLancelot().getHead().getY());
				bs.getLancelot().align();
				break;
			default:
				break;
			}
	//	}
		if(arg0.getKeyChar()=='o')
			bs.reset();
		mouseClicked=false;


	}

}
