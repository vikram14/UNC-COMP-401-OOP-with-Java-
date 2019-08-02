package mp;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;


import mp.A.AngleShapeInterface;
import mp.A.AvatarInterface;
import mp.A.BridgeScene;
import mp.A.BridgeSceneInterface;
import mp.A.GorgeInterface;
import mp.A.ImageShape;
import mp.A.Line;
import util.annotations.Tags;
@Tags("InheritingBridgeScenePainter")
public class InheritingBridgeScenePainter extends Component implements InheritingBridgeScenePainterInterface {
	BridgeSceneInterface bs; TableInterface table;static final String ARR[]= {"arthur","galahad","robin","lancelot","guard"};
	public InheritingBridgeScenePainter() {
		table=SingletonsCreator.createTableInterface();
		bs=SingletonsCreator.createBridgeScene();
		initTable();
		for(int i=0;i<ARR.length;i++) {
			BridgeScene.addPropertyChangeListener((AvatarInterface) table.get(ARR[i]), this);
		}
		BridgeScene.addPropertyChangeListenerToBackground(bs.getGuardArea(),bs.getKnightArea(),bs.getGorge() ,this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		repaint();
	}
	@Override
	public void paint(Graphics g) {
		for(int i=0;i<ARR.length;i++) {
			draw(g,((AvatarInterface)(table.get(ARR[i]))).getArms());
			draw(g, ((AvatarInterface)(table.get(ARR[i]))).getLegs());
			drawHead(g,((AvatarInterface)(table.get(ARR[i]))).getHead());
			g.drawLine(((AvatarInterface)(table.get(ARR[i]))).getBody().getX(), ((AvatarInterface)(table.get(ARR[i]))).getBody().getY(), ((AvatarInterface)(table.get(ARR[i]))).getBody().getX()+((AvatarInterface)(table.get(ARR[i]))).getBody().getWidth(),((AvatarInterface)(table.get(ARR[i]))).getBody().getY()+((AvatarInterface)(table.get(ARR[i]))).getBody().getHeight());
		}
		drawCircles(g);
		drawGorge(g,bs.getGorge());
		
	}
	public void draw(Graphics g,AngleShapeInterface av) {
		draw(g,av.getLeftLine());
		draw(g,av.getRightLine());
	}
	public void draw(Graphics g, Line aLine ) {
		g.drawLine(aLine.getX(),aLine.getY(),aLine.getX()+aLine.getWidth(),aLine.getY()+aLine.getHeight());
	}
	public void drawHead(Graphics g, ImageShape head) {
		Image img = Toolkit.getDefaultToolkit().getImage(head.getImageFileName());
		g.drawImage(img, head.getX(), head.getY(), this);
	}
	public void drawCircles(Graphics g) {
		g.drawOval(bs.getGuardArea().getX(), bs.getGuardArea().getY(), bs.getGuardArea().getWidth(),bs.getGuardArea().getHeight());
		g.drawOval(bs.getKnightArea().getX(), bs.getKnightArea().getY(), bs.getKnightArea().getWidth(),bs.getKnightArea().getHeight());
	}
	public void drawGorge(Graphics g, GorgeInterface gorge) {
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


	public void initTable() {
		table.put("lancelot", bs.getLancelot());
		table.put("robin", bs.getRobin());
		table.put("guard", bs.getGuard());
		table.put("galahad", bs.getGalahad());
		table.put("arthur", bs.getArthur());
	}


}
