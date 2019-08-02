package mp;

import java.util.List;

import util.annotations.Tags;

public interface ObservableBridgeScenePainterInterface {
	@Tags("addPaintListener")
	public void addPaintListener(PaintListener pl);
	public List<PaintListener> getPaintListeners();
}
