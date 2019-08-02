package mp;

import java.awt.Component;

import mp.A.BridgeScene;
import mp.A.BridgeSceneInterface;
import util.annotations.Tags;

@Tags("SingletonsCreator")
public class SingletonsCreator {
	static BridgeSceneInterface bs;static ScannerBeanInterface sci;static CommandInterpreterInterface ci; static TableInterface table;
	static ConsoleSceneViewInterface csv; static InheritingBridgeScenePainterInterface ibsp;// static ObservableBridgeScenePainterInterface obsp;
	static BridgeSceneControllerInterface bsc; static CommandInterpreterFrameComposerInterface cifc= new CommandInterpreterFrameComposer();
	static CommandInterpreterController cic; static CommandInterpreterView civ;static DelegatingBridgeSceneViewInterface delegator;
	static ObservableBridgeScenePainterInterface obsp;
	private static Parser p;
	private static BroadcastingClearanceManager m;
	private static TableInterface<Runnable> env;
	private static Undoer undoer;
	@Tags({"bridgeSceneFactoryMethod"})
	public static BridgeSceneInterface createBridgeScene() {
		if(bs==null)
			bs=new BridgeScene();
		return(bs);
	}
	@Tags({"scannerFactoryMethod"})
	public static ScannerBeanInterface createScannerBean() {
		if(sci==null)
			sci=new ScannerBeanClass();
		return sci;
	}
	@Tags({"observableCommandInterpreterFactoryMethod","CommandInterpreterFactoryMethod"})
	public static CommandInterpreterInterface createCommandInterpreter() {
		if(ci==null)
			ci=new CommandInterpreter();
		return ci;
	}
	@Tags("avatarTableFactoryMethod")
	public static TableInterface createTableInterface() {
		if(table==null)
			table=new Table();
		return table;
	}
	@Tags("consoleSceneViewFactoryMethod")
	public static ConsoleSceneViewInterface createConsoleSceneView() {
		if(csv==null)
			csv=new ConsoleSceneView();
		return csv;
	}
	@Tags("inheritingBridgeSceneView")
	public static InheritingBridgeScenePainterInterface createInheritingBridgeSceneView() {
		if(ibsp==null)
			ibsp=new InheritingBridgeScenePainter();
		return ibsp;
	}
	@Tags("observableBridgeScenePainterFactoryMethod")
	public static ObservableBridgeScenePainterInterface createObservableBridgeScenePainter() {
		if(obsp==null)
			obsp=new ObservableBridgeScenePainter();
		return obsp;
	}
	@Tags("delegatingBridgeSceneViewFactoryMethod")
	public static DelegatingBridgeSceneViewInterface createDelegatingBridgeSceneView() {
		if(delegator==null)
			delegator=new DelegatingBridgeSceneView();
		return delegator;
	}
	@Tags("bridgeSceneControllerFactoryMethod")
	public static BridgeSceneControllerInterface createBridgeSceneController() {
		if(bsc==null)
			bsc=new BridgeSceneController((Component) createObservableBridgeScenePainter());
		return bsc;
	}
	@Tags("commandInterpreterControllerFactoryMethod")
	public static CommandInterpreterController createCommandInterpreterController() {
		if(cic==null)
			cic=new CommandInterpreterController(ci,cifc.getCommandField(),cifc.getMenu(),cifc.getButton(),cifc.getButton2(),cifc.getButton3(),cifc.getButton4(),cifc.getButton5());
		return cic;
	}
	@Tags("commandInterpreterViewFactoryMethod")
	public static CommandInterpreterView createCommandInterpreterView() {
		if(civ==null)
			civ=new CommandInterpreterView(cifc.getCommandField(),cifc.getErrorsField());
		return civ;
	}
	@Tags("parserFactoryMethod")
	public static Parser createParser() {
		if(p==null)
			p=new Parser();
		return p;
	}
	@Tags("broadcastingClearanceManagerFactoryMethod")
	public static BroadcastingClearanceManager createManager() {
		if(m==null)
			m=new ABroadcastingClearanceManager();
		return m;
	}
	@Tags("environmentFactoryMethod")
	public static TableInterface<Runnable> createEnvironment() {
		if(env==null)
			env=new Table<Runnable>();
		return env;
	}
	public static Undoer createUndoer() {
		if(undoer==null)
			undoer=new HistoryUndoer();
		return undoer;
	}
}
