package mp;

import mp.A.AvatarInterface;
import util.annotations.Tags;

public class UndoableMoveCommand implements UndoableMoveCommandInterface {
	MoveCommand moveCommand; Undoer undoer=SingletonsCreator.createUndoer();
	int x,y; AvatarInterface av;int oldx,oldy;
	public UndoableMoveCommand(MoveCommand mc) {
		moveCommand=mc;
	}
	@Override
	public void run() {
		undoer.execute(moveCommand);
	}
	/*@Override
	public void undo() {
		undoer.undo();
	}*/
}
