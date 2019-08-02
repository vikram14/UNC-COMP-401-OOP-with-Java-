package mp;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mp.A.AngleShapeInterface;
import mp.A.BridgeSceneInterface;
import mp.A.GorgeInterface;
import mp.A.ImageShape;
import mp.A.Line;

public class BackgroundView implements PropertyChangeListener, PaintListener{
	BridgeSceneInterface bs;ObservableBridgeScenePainterInterface obsp;
	public BackgroundView() {
		bs=SingletonsCreator.createBridgeScene();
		bs.getGuardArea().addPropertyChangeListener(this);
		bs.getKnightArea().addPropertyChangeListener(this);
		bs.getGorge().getEffect3D1().addPropertyChangeListener(this);
		bs.getGorge().getEffect3D2().addPropertyChangeListener(this);
		bs.getGorge().getEffect3D3().addPropertyChangeListener(this);
		bs.getGorge().getEffect3D4().addPropertyChangeListener(this);
		bs.getGorge().getEffect3D5().addPropertyChangeListener(this);
		bs.getGorge().getHorizontalBottom().addPropertyChangeListener(this);
		bs.getGorge().getHorizontalTop().addPropertyChangeListener(this);
		bs.getGorge().getVerticalRight().addPropertyChangeListener(this);
		bs.getGorge().getVerticalLeft().addPropertyChangeListener(this);
		obsp=SingletonsCreator.createObservableBridgeScenePainter();
	}

	public void paint(Graphics2D g) {
	
		drawCircles(g);
		drawGorge(g,bs.getGorge());
	}
	public void draw(Graphics2D g, Line aLine ) {
		g.drawLine(aLine.getX(),aLine.getY(),aLine.getX()+aLine.getWidth(),aLine.getY()+aLine.getHeight());
	}

	public void propertyChange(PropertyChangeEvent evt) {
		((Component) obsp).repaint();
	}

	public void drawCircles(Graphics2D g) {
		g.drawOval(bs.getGuardArea().getX(), bs.getGuardArea().getY(), bs.getGuardArea().getWidth(),bs.getGuardArea().getHeight());
		g.drawOval(bs.getKnightArea().getX(), bs.getKnightArea().getY(), bs.getKnightArea().getWidth(),bs.getKnightArea().getHeight());
	}
	public void drawGorge(Graphics2D g, GorgeInterface gorge) {
		draw(g,gorge.getEffect3D1());
		draw(g,gorge.getEffect3D2());
		draw(g,gorge.getEffect3D3());
		draw(g,gorge.getEffect3D4());
		draw(g,gorge.getEffect3D5());
		draw(g,gorge.getHorizontalBottom());
		draw(g,gorge.getHorizontalTop());
		draw(g,gorge.getVerticalLeft());
		draw(g,gorge.getVerticalRight());
	}
}
