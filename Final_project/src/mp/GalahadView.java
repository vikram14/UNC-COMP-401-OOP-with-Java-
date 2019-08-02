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

public class GalahadView implements PropertyChangeListener, PaintListener{
	BridgeSceneInterface bs;ObservableBridgeScenePainterInterface obsp;
	public GalahadView() {
		bs=SingletonsCreator.createBridgeScene();
		bs.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		bs.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		bs.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		bs.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getGalahad().getBody().addPropertyChangeListener(this);
		bs.getGalahad().getHead().addPropertyChangeListener(this);
		bs.getGalahad().getStringShape().addPropertyChangeListener(this);
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
	}

	public void paint(Graphics2D g) {
		draw(g,bs.getGalahad().getArms());
		draw(g,bs.getGalahad().getLegs());
		draw(g,bs.getGalahad().getBody());
		drawHead(g,bs.getGalahad().getHead());
		g.drawString(bs.getGalahad().getStringShape().getText(), bs.getGalahad().getStringShape().getX(), bs.getGalahad().getStringShape().getY());
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
