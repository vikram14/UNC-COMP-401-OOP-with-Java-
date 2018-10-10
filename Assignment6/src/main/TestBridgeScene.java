package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.A.BridgeScene;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.misc.ThreadSupport;
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class TestBridgeScene {
	public static void main(String args[]) {
		BridgeScene bs= new BridgeScene();
		OEFrame oeFrame=ObjectEditor.edit(bs);
		oeFrame.refresh();
		//ThreadSupport.sleep(5000);
		bs.approach(bs.getGalahad());
		oeFrame.refresh();
		//ThreadSupport.sleep(3000);
		bs.say("name");
		oeFrame.refresh();
		//ThreadSupport.sleep(3000);
		bs.say("Galahad");
		oeFrame.refresh();
		bs.failed();
		bs.approach(bs.getRobin());
		//ThreadSupport.sleep(3000);
		bs.say("quest");
		oeFrame.refresh();
		//ThreadSupport.sleep(2000);
		//ThreadSupport.sleep(1000);
		bs.say("Grail");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bs.say("color");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bs.say("blue");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);
		bs.say("Off you go");
		oeFrame.refresh();
		ThreadSupport.sleep(1000);
		bs.passed();
		oeFrame.refresh();
		ThreadSupport.sleep(1000);
		
	}
}
