package mp;

import java.beans.PropertyChangeEvent;


import java.beans.PropertyChangeListener;


import java.lang.Thread;
import mp.A.BridgeSceneInterface;
import mp.A.PropertyListenerSupport;
import mp.A.PropertyListenerSupportInterface;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"CommandInterpreter","SignedMoveCommandInterpreter","ErrorResilientCommandInterpreter","ObservableCommandInterpreter"})
public class CommandInterpreter implements CommandInterpreterInterface,PropertyChangeListener {
	static final String EMPTY="";
	BridgeSceneInterface bridge_scene;ScannerBeanInterface scannerbean;
	String command,errors=EMPTY;
	PropertyListenerSupportInterface pls= new PropertyListenerSupport();
    Parser p ;
	
	public CommandInterpreter(BridgeSceneInterface bs,ScannerBeanInterface scb) {
		bridge_scene=bs;
		scannerbean=scb;
		p = SingletonsCreator.createParser();
		p.addPropertyChangeListener(this);
		
	}
	public CommandInterpreter() {
		bridge_scene=SingletonsCreator.createBridgeScene();
		
	}
	static String WARNING="Move or Say command missing;";
	public void setCommand(String c) {
		command=c;
		if (p==null)
			p=SingletonsCreator.createParser();
		p.setCommandText(c);
		if(pls!=null)
		pls.notifyAllListeners(new PropertyChangeEvent(this,"Command",getCommand(),getCommand()));
		if(p.getCommandObject()!=null)
			p.getCommandObject().run();
	}
	static String WARNING1="No number present in command;", WARNING2="Please give a legal command; Ensure character name and coordinates are given;",
			WARNING3="Character to move not present;";
	
	public String getErrors() {return errors;}
	public String getCommand() {
		return command;
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		pls.addElement(arg0);
		
	}
	
	BroadcastingClearanceManager bcm= SingletonsCreator.createManager();
	Animator animatorA=new Animator();
	Animator animatorG=new Animator();
	Animator animatorR=new Animator();
	Animator animatorL=new Animator();
	Animator animatorGU=new Animator();
	CoordinatedAnimator canimatorA=new CoordinatedAnimator();
	CoordinatedAnimator canimatorG=new CoordinatedAnimator();
	CoordinatedAnimator canimatorR=new CoordinatedAnimator();
	CoordinatedAnimator canimatorL=new CoordinatedAnimator();
	CoordinatedAnimator canimatorGU=new CoordinatedAnimator();
	@Tags("asynchronousArthur")
	public void asynchronousArthur() {
		Thread t=new Thread(new AnimatingCommand(animatorA,bridge_scene.getArthur(),false));
		t.start();
	}
	@Tags("asynchronousRobin")
	public void asynchronousRobin() {
		Thread t=new Thread(new AnimatingCommand(animatorR,bridge_scene.getRobin(),false));
		t.start();
	}
	@Tags("asynchronousGalahad")
	public void asynchronousGalahad() {
		Thread t=new Thread(new AnimatingCommand(animatorG,bridge_scene.getGalahad(),false));
		t.start();
	}
	@Tags("asynchronousLancelot")
	public void asynchronousLancelot() {
		Thread t=new Thread(new AnimatingCommand(animatorL,bridge_scene.getLancelot(),false));
		t.start();
	}
	@Tags("asynchronousGuard")
	public void asynchronousGuard() {
		Thread t=new Thread(new AnimatingCommand(animatorGU,bridge_scene.getGuard(),false));
		t.start();
	}
	@Tags("waitingRobin")
	public void waitingRobin() {
		Thread t=new Thread(new AnimatingCommand(animatorR,bridge_scene.getRobin(),true));
		t.start();
	}
	@Tags("waitingGalahad")
	public void waitingGalahad() {
		Thread t=new Thread(new AnimatingCommand(animatorG,bridge_scene.getGalahad(),true));
		t.start();
	}
	@Tags("waitingLancelot")
	public void waitingLancelot() {
		Thread t=new Thread(new AnimatingCommand(animatorL,bridge_scene.getLancelot(),true));
		t.start();
	}
	@Tags("waitingArthur")
	public void waitingArthur() {
		Thread t=new Thread(new AnimatingCommand(animatorA,bridge_scene.getArthur(),true));
		t.start();
	}
	@Tags("startAnimation")
	public void startAnimation() {
		bcm.proceedAll();
	}
	@Tags("lockstepArthur")
	public void lockstepArthur() {
		Thread t=new Thread(new CoordinatedAnimationCommand(canimatorA,bridge_scene.getArthur()));
		t.start();
	}
	@Tags("lockstepRobin")
	public void lockstepRobin() {
		Thread t=new Thread(new CoordinatedAnimationCommand(canimatorR,bridge_scene.getRobin()));
		t.start();
	}
	@Tags("lockstepGalahad")
	public void lockstepGalahad() {
		Thread t=new Thread(new CoordinatedAnimationCommand(canimatorG,bridge_scene.getGalahad()));
		t.start();
	}
	@Tags("lockstepLancelot")
	public void lockstepLancelot() {
		Thread t=new Thread(new CoordinatedAnimationCommand(canimatorL,bridge_scene.getLancelot()));
		t.start();
	}
	@Tags("lockstepGuard")
	public void lockstepGuard() {
		Thread t=new Thread(new CoordinatedAnimationCommand(canimatorGU,bridge_scene.getGuard()));
		t.start();
	}
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		errors+=arg0.getNewValue().toString();
		pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
	}

	/*public static void main(String Args[]) {
		CommandInterpreter ci =new CommandInterpreter();
		ci.setCommand("JUmp Arthur 2");
	}*/
}
