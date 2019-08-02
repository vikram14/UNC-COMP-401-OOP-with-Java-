package mp;

import util.annotations.Tags;

@Tags("UndoCommand")
public class UndoCommand implements Runnable {

	private Undoer undoer;
	public UndoCommand() {
		undoer=SingletonsCreator.createUndoer();
	}
	@Override
	public void run() {
		undoer.undo();
	}

}
