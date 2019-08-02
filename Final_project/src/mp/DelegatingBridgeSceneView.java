package mp;

import java.awt.Component;

import javax.swing.JFrame;

import util.annotations.Tags;

@Tags("DelegatingBridgeSceneView")
public class DelegatingBridgeSceneView implements DelegatingBridgeSceneViewInterface{
	ObservableBridgeScenePainterInterface obsp;static DelegatingBridgeSceneViewInterface delegator;
    PaintListener arthurView=new ArthurView();
	PaintListener galView=new GalahadView();
	PaintListener robView=new RobinView();
	PaintListener lanView=new LancelotView();
	PaintListener guardView=new GuardView();
	PaintListener backgroundView=new BackgroundView();
	public DelegatingBridgeSceneView() {
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
		obsp.addPaintListener(backgroundView);
		obsp.addPaintListener(arthurView);
		obsp.addPaintListener(galView);
		obsp.addPaintListener(robView);
		obsp.addPaintListener(lanView);
		obsp.addPaintListener(guardView);
	}
	public  void edit() {
		JFrame frame = new JFrame("Bridge Scene");
		// so we add the graphics view to the top level frame
		SingletonsCreator.createBridgeSceneController();
		frame.add((Component) obsp);
		frame.setSize(500,600);
		frame.setVisible(true);
	}
}
