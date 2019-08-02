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

public class GuardView implements PropertyChangeListener, PaintListener{
	BridgeSceneInterface bs;ObservableBridgeScenePainterInterface obsp;
	public GuardView() {
		bs=SingletonsCreator.createBridgeScene();
		bs.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		bs.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		bs.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		bs.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getGuard().getBody().addPropertyChangeListener(this);
		bs.getGuard().getHead().addPropertyChangeListener(this);
		bs.getGuard().getStringShape().addPropertyChangeListener(this);
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
	}

	public void paint(Graphics2D g) {
		draw(g,bs.getGuard().getArms());
		draw(g,bs.getGuard().getLegs());
		draw(g,bs.getGuard().getBody());
		drawHead(g,bs.getGuard().getHead());
		g.drawString(bs.getGuard().getStringShape().getText(), bs.getGuard().getStringShape().getX(), bs.getGuard().getStringShape().getY());
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
