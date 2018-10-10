package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.A.BridgeScene;
import util.misc.ThreadSupport;

public class tester {
	public static void main(String args[]) {
	/*	AngleShapeInterface as= new AngleShape();
		CharacterSpeak gs=new CharacterSpeak("hello",100,50);
		CharacterHead gallahad=new CharacterHead("C:\\Users\\vikram14\\eclipse-workspace\\Assignment5\\images\\data\\robin.jpg",25,50);
		Avatar a= new Avatar(gallahad);*/
		BridgeScene bs= new BridgeScene();
		OEFrame oeFrame=ObjectEditor.edit(bs);
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bs.getGalahad().scale(1.5);
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bs.getGalahad().getArms().getRightLine().rotate(-2);	
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bs.getGalahad().getArms().getRightLine().rotate(1);
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
	}
}
