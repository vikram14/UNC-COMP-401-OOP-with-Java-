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

public class ArthurView implements PropertyChangeListener, PaintListener{
	BridgeSceneInterface bs;ObservableBridgeScenePainterInterface obsp;
	public ArthurView() {
		bs=SingletonsCreator.createBridgeScene();
		bs.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		bs.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		bs.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		bs.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getArthur().getBody().addPropertyChangeListener(this);
		bs.getArthur().getHead().addPropertyChangeListener(this);
		bs.getArthur().getStringShape().addPropertyChangeListener(this);
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
	}

	public void paint(Graphics2D g) {
		draw(g,bs.getArthur().getArms());
		draw(g,bs.getArthur().getLegs());
		draw(g,bs.getArthur().getBody());
		drawHead(g,bs.getArthur().getHead());
	    g.drawString(bs.getArthur().getStringShape().getText(), bs.getArthur().getStringShape().getX(), bs.getArthur().getStringShape().getY());
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
