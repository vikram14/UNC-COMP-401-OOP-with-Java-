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

public class LancelotView implements PropertyChangeListener, PaintListener{
	BridgeSceneInterface bs;ObservableBridgeScenePainterInterface obsp;
	public LancelotView() {
		bs=SingletonsCreator.createBridgeScene();
		bs.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		bs.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		bs.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		bs.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		bs.getLancelot().getBody().addPropertyChangeListener(this);
		bs.getLancelot().getHead().addPropertyChangeListener(this);
		bs.getLancelot().getStringShape().addPropertyChangeListener(this);
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
	}

	public void paint(Graphics2D g) {
		draw(g,bs.getLancelot().getArms());
		draw(g,bs.getLancelot().getLegs());
		draw(g,bs.getLancelot().getBody());
		drawHead(g,bs.getLancelot().getHead());
		g.drawString(bs.getLancelot().getStringShape().getText(), bs.getLancelot().getStringShape().getX(), bs.getLancelot().getStringShape().getY());
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
