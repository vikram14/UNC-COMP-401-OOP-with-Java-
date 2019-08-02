package mp;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import util.annotations.Tags;

public class ObservableBridgeScenePainter extends Component implements ObservableBridgeScenePainterInterface {
	List<PaintListener> paint_listeners;
	static ObservableBridgeScenePainterInterface obsp;
	public ObservableBridgeScenePainter() {
		paint_listeners=new ArrayList<PaintListener>();
	}
	
	@Tags("addPaintListener")
	public void addPaintListener(PaintListener pl) {
		paint_listeners.add(pl);
	}
	public List<PaintListener> getPaintListeners(){
		return paint_listeners;
	}
	@Override
	public void paint(Graphics g) {
		for(PaintListener pl: paint_listeners) {
			pl.paint((Graphics2D) g);
		}
	}
}
