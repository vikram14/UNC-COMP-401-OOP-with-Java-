package mp;

import mp.A.AvatarInterface;
import util.annotations.Tags;
@Tags("MoveCommand")
public class MoveCommand implements UndoableCommand {
	int x,y; AvatarInterface av;int oldx,oldy;
	public MoveCommand(AvatarInterface a,int xoffset,int yoffset) {
		av=a;
		x=xoffset;
		y=yoffset;
		oldx=av.getHead().getX();
		oldy=av.getHead().getY();
	}
	@Override
	public void run() {
		av.move(x, y);
	}
	@Override
	public void undo() {
		av.getHead().setX(oldx);
		av.getHead().setY(oldy);
		av.align();
	}
}
