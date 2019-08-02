package mp.A;

import util.annotations.StructurePattern;
import util.annotations.Tags;

@StructurePattern("Bean Pattern")
@Tags("Gorge")
public class Gorge implements GorgeInterface{
	Line vertical_left,vertical_right, horizontal_top, horizontal_bottom,effect_3D1,effect_3D2,effect_3D3,effect_3D4,effect_3D5;
	static final int VERTICAL_LINE_LENGTH=800,HORIZONTAL_LINE_LENGTH=300,
			V_BRIDGE_X=1000,V_BRIDGE_Y=100,HORIZONTAL_WIDTH=80,EFFECT_3D_LINE_LENGTH=75,EFFECT_3D3_LINE_LENGTH=600,DISTANCE_BW_VERTICAL=80,
			hbridgeX=V_BRIDGE_X;
	 static final int H_BRIDGE_Y=V_BRIDGE_Y+VERTICAL_LINE_LENGTH/2;
	public Gorge () {
		vertical_left = new RotatingLine(VERTICAL_LINE_LENGTH,Math.PI/2,V_BRIDGE_X,V_BRIDGE_Y);
		vertical_right = new RotatingLine(VERTICAL_LINE_LENGTH,Math.PI/2,V_BRIDGE_X+HORIZONTAL_LINE_LENGTH,V_BRIDGE_Y);
		horizontal_top = new RotatingLine(HORIZONTAL_LINE_LENGTH,0,hbridgeX,H_BRIDGE_Y);
		horizontal_bottom= new RotatingLine(HORIZONTAL_LINE_LENGTH,0,hbridgeX,H_BRIDGE_Y+HORIZONTAL_WIDTH);
		effect_3D1 = new RotatingLine(EFFECT_3D_LINE_LENGTH,13*Math.PI/12,V_BRIDGE_X,V_BRIDGE_Y);
		effect_3D2 = new RotatingLine(EFFECT_3D_LINE_LENGTH,11*Math.PI/12,V_BRIDGE_X,V_BRIDGE_Y+VERTICAL_LINE_LENGTH);
		effect_3D3 = new RotatingLine(EFFECT_3D3_LINE_LENGTH,Math.PI/2,V_BRIDGE_X+DISTANCE_BW_VERTICAL,V_BRIDGE_Y+(VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2);
		effect_3D4 =new RotatingLine(Math.sqrt(Math.pow((VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2,2)+Math.pow(HORIZONTAL_WIDTH, 2)),Math.PI+Math.atan2((VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2,HORIZONTAL_WIDTH),V_BRIDGE_X+DISTANCE_BW_VERTICAL,V_BRIDGE_Y+(VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2);
		effect_3D5 = new RotatingLine(Math.sqrt(Math.pow((VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2,2)+Math.pow(HORIZONTAL_WIDTH, 2)),Math.PI/2+Math.atan2(HORIZONTAL_WIDTH, (VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2),V_BRIDGE_X+DISTANCE_BW_VERTICAL,V_BRIDGE_Y+(VERTICAL_LINE_LENGTH-EFFECT_3D3_LINE_LENGTH)/2+EFFECT_3D3_LINE_LENGTH);
	}
	public Line getVerticalLeft() {return vertical_left;}
	public Line getVerticalRight() {return vertical_right;}
	public Line getHorizontalTop() {return horizontal_top;}
	public Line getHorizontalBottom() {return horizontal_bottom;}
	public Line getEffect3D1() {return effect_3D1;}
	public Line getEffect3D2() {return effect_3D2;}
	public Line getEffect3D3() {return effect_3D3;}
	public Line getEffect3D4() {return effect_3D4;}
	public Line getEffect3D5() {return effect_3D5;}
	public void move(int x, int y){
		vertical_left.setX(vertical_left.getX()+x);
		vertical_left.setY(vertical_left.getY()+y);
		vertical_right.setX(vertical_right.getX()+x);
		vertical_right.setY(vertical_right.getY()+y);
		horizontal_top.setX(horizontal_top.getX()+x);
		horizontal_top.setY(horizontal_top.getY()+y);
		horizontal_bottom.setX(horizontal_bottom.getX()+x);
		horizontal_bottom.setY(horizontal_bottom.getY()+y);
		effect_3D1.setX(effect_3D1.getX()+x);
		effect_3D1.setY(effect_3D1.getY()+y);
		effect_3D2.setX(effect_3D2.getX()+x);
		effect_3D2.setY(effect_3D2.getY()+y);
		effect_3D3.setX(effect_3D3.getX()+x);
		effect_3D3.setY(effect_3D3.getY()+y);
		effect_3D4.setX(effect_3D4.getX()+x);
		effect_3D4.setY(effect_3D4.getY()+y);
		effect_3D5.setX(effect_3D5.getX()+x);
		effect_3D5.setY(effect_3D5.getY()+y);
	}
}
