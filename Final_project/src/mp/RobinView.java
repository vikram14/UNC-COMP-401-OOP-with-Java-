package mp;

import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.A.AngleShapeInterface;
import mp.A.BridgeSceneInterface;
import mp.A.ImageShape;
import mp.A.Line;

public class RobinView implements PropertyChangeListener, PaintListener{
	BridgeSceneInterface bs;ObservableBridgeScenePainterInterface obsp;
	public RobinView() {
		bs=SingletonsCreator.createBridgeScene();
		bs.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		bs.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		bs.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		bs.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getRobin().getBody().addPropertyChangeListener(this);
		bs.getRobin().getHead().addPropertyChangeListener(this);
		bs.getRobin().getStringShape().addPropertyChangeListener(this);
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
	}

	public void paint(Graphics2D g) {
		draw(g,bs.getRobin().getArms());
		draw(g,bs.getRobin().getLegs());
		draw(g,bs.getRobin().getBody());
		drawHead(g,bs.getRobin().getHead());
		g.drawString(bs.getRobin().getStringShape().getText(), bs.getRobin().getStringShape().getX(), bs.getRobin().getStringShape().getY());
	}

	public void propertyChange(PropertyChangeEvent evt) {
		((Component) obsp).repaint();
	}

	public void draw(Graphics2D g,AngleShapeInterface av) {
		draw(g,av.getLeftLine());
		draw(g,av.getRightLine());
	}
	public void draw(Graphics2D g, Line aLine ) {
		g.drawLine(aLine.getX(),aLine.getY(),aLine.getX()+aLine.getWidth(),aLine.getY()+aLine.getHeight());
	}
	public void drawHead(Graphics2D g, ImageShape head) {
		Image img = Toolkit.getDefaultToolkit().getImage(head.getImageFileName());
		g.drawImage(img, head.getX(), head.getY(), null);
	}
}
