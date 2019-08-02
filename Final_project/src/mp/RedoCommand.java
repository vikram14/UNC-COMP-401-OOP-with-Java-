package mp;

import util.annotations.Tags;

@Tags("RedoCommand")
public class RedoCommand implements Runnable {

	private Undoer undoer;
	public RedoCommand() {
		undoer=SingletonsCreator.createUndoer();
	}
	@Override
	public void run() {
		undoer.redo();
	}

}
