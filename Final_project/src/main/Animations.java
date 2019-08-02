package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;

import bus.uigen.ObjectEditor;
import mp.BridgeSceneControllerInterface;
import mp.BroadcastingClearanceManager;
import mp.CommandInterpreterInterface;
import mp.CommandInterpreterMVCComposer;
import mp.ConsoleSceneViewInterface;
import mp.DelegatingBridgeSceneView;
import mp.DelegatingBridgeSceneViewInterface;
import mp.ScannerBeanInterface;
import mp.SingletonsCreator;
import mp.A.BridgeSceneInterface;
import util.annotations.Tags;
import util.misc.ThreadSupport;
@Tags("ProgressBar")
public class Animations {
	BridgeSceneInterface bs=SingletonsCreator.createBridgeScene();
	CommandInterpreterInterface ci= SingletonsCreator.createCommandInterpreter();
	ScannerBeanInterface sci= SingletonsCreator.createScannerBean();
	ConsoleSceneViewInterface csv= SingletonsCreator.createConsoleSceneView();
	BridgeSceneControllerInterface bsc=SingletonsCreator.createBridgeSceneController();
	DelegatingBridgeSceneViewInterface dbsv=SingletonsCreator.createDelegatingBridgeSceneView();
	BroadcastingClearanceManager bcm=SingletonsCreator.createManager();
	JProgressBar pb= new JProgressBar();
	JFrame frame= new JFrame("Progress Bar");
	JPanel panel=new JPanel();
	public void animate() {
		dbsv.edit();
		//CommandInterpreterMVCComposer.edit(ci);		
		OEFrame oe1= ObjectEditor.edit(bcm);
		OEFrame oe= ObjectEditor.edit(ci);
		ci.lockstepArthur();
		ci.lockstepGalahad();
		ci.lockstepLancelot();
		ci.lockstepRobin();
		ci.lockstepGuard();
		ThreadSupport.sleep(1000);
		ci.waitingArthur();
		ci.waitingGalahad();
		ci.waitingLancelot();
		ci.waitingRobin();
		ThreadSupport.sleep(1000);
		ci.setCommand("move arthur 8 10");
		bcm.waitForProceed();
		ci.setCommand("undo");
		ci.setCommand("redo");
		ThreadSupport.sleep(1000);
		bs.reset();// resetting bridge scene to demonstrate parsing. Delete if necessary.
		ci.setCommand("define guardArmsIn {rotateLeftArm guard - 4 rotateRightArm guard 4}");
		ci.setCommand("define guardArmsOut {rotateLeftArm guard 4 rotateRightArm guard - 4}");
		ci.setCommand("define beat {call guardArmsIn proceedAll sleep 1000 call guardArmsOut sleep 1000}");
		ci.setCommand("define beats repeat 10 call beat");
		ci.setCommand("thread beats");
		
	}
	
	
}
