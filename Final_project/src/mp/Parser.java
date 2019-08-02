package mp;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import mp.A.AvatarInterface;
import mp.A.BridgeSceneInterface;
import mp.A.PropertyListenerSupport;
import mp.A.PropertyListenerSupportInterface;
import util.annotations.Tags;
import util.annotations.Visible;
import util.models.PropertyListenerRegisterer;
@Tags("Parser")
public class Parser implements PropertyListenerRegisterer {
	static final String EMPTY=""; static ClearableHistoryInterface a; int i;
	BridgeSceneInterface bridge_scene;ScannerBeanInterface scannerbean;
	String command,errors=EMPTY; TableInterface<AvatarInterface> table=new Table<AvatarInterface>();
	PropertyListenerSupportInterface pls= new PropertyListenerSupport(); Runnable r; 
	static String WARNING="Move or Say command missing;";
	static final String[] CHARS= {"lancelot","robin","guard","galahad","arthur"};
	Undoer undoer= new HistoryUndoer();

	public void setCommandText(String c) {
		command=c;
		bridge_scene=SingletonsCreator.createBridgeScene();
		scannerbean=SingletonsCreator.createScannerBean();
		try {
			scannerbean.setScannedString(command);
		} catch (ScanningException e) {
			errors+=e.getMessage();
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			//e.printStackTrace();
		}
		a = scannerbean.getTokenList();
		initTable();
		reset();
		try {
			r=parseCommand();
		} catch (ParsingException e) {
			errors+=e.getMessage();
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			//e.printStackTrace();
		} catch (ScanningException e) {
			errors+=e.getMessage();
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
		//	e.printStackTrace();
		}
	}
	public Runnable parseCommand() throws ParsingException, ScanningException {
		String s; boolean called_once=false;
		while(hasNext()) {
			if(a.elementAt(i)instanceof Word) {
				s=((Word)(a.elementAt(i))).getValue();
				if(s.equalsIgnoreCase("move")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseMove(a,i);

				}
				else if (s.equalsIgnoreCase("say")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseSay(a,i);

				}
				else if (s.equalsIgnoreCase("passed")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parsePassCommand(a,i);
				}
				else if (s.equalsIgnoreCase("failed")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseFailCommand(a,i);
				}
				else if (s.equalsIgnoreCase("approach")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseApproachCommand();
				}

				else if (s.equalsIgnoreCase("repeat")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseRepeatCommand();
				}
				else if (s.equalsIgnoreCase("rotaterightarm")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseRotateRightArmCommand();
				}
				else if (s.equalsIgnoreCase("rotateleftarm")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseRotateLeftArmCommand();
				}
				else if (s.equalsIgnoreCase("define")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseDefineCommand();
				}
				else if (s.equalsIgnoreCase("call")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseCallCommand();
				}
				else if (s.equalsIgnoreCase("thread")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseThreadCommand();
				}
				else if (s.equalsIgnoreCase("proceedall")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseProceedAllCommand();
				}
				else if (s.equalsIgnoreCase("sleep")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseSleepCommand();
				}
				else if (s.equalsIgnoreCase("undo")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseUndoCommand();
				}
				else if (s.equalsIgnoreCase("redo")) {
					errors="";
					called_once=true;
					pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
					return parseRedoCommand();
				}

				else {
					next();
					//throw new ParsingException("Wrong command used");
					}
			}
			else if (a.elementAt(i)instanceof StartToken) {

				errors="";
				called_once=true;
				pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
				return parseCommandList();
			}
			else {
				throw new ParsingException("Wrong command used");
			}

		}
		if(!called_once) {

			errors+=WARNING;
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
		}
		return null;
	}
	public Runnable parseUndoCommand() {
		next();
		return(new UndoCommand());
	}
	public Runnable parseRedoCommand(){
		next();
		return new RedoCommand();
	}
	@Tags("parseRepeat")
	private Runnable parseRepeatCommand() throws ParsingException, ScanningException {
		next();
		if(isInteger(peek().getInput())) {
			int n=((Number) next()).getValue();
			return new RepeatCommand(n,parseCommand());
		}
		return null;
	}
	private Runnable parseCommandList() throws ParsingException, ScanningException {
		next();

		CommandList cl=new CommandList();
		while(!(peek().getInput().equals("}"))) {
			cl.add(parseCommand());
		}
		next();
		if(!a.memberEndToken())
			throw new ScanningException("End Token not Present");
		return cl;		
	}
	private Runnable parseApproachCommand() {
		next();
		AvatarInterface ava=null;
		for(int k=0;k<CHARS.length;k++) {
			if(peek().getInput().equalsIgnoreCase(CHARS[k])) {
				ava=(AvatarInterface) table.get(CHARS[k]);
				break;
			}

		}
		if(ava==null) {
			errors+="Character Not Present in Command";
			next();
			return null;
		}
		else {
			next();
			return new ApproachCommand(bridge_scene,ava);
		}


	}

	private Runnable parseFailCommand(ClearableHistoryInterface chi, int index) {
		next();
		return new FailCommand(bridge_scene);
	}
	private Runnable parsePassCommand(ClearableHistoryInterface chi, int index) {
		next();
		return new PassCommand(bridge_scene);
	}
	static String WARNING1="No number present in command;", WARNING2="Please give a legal command; Ensure character name and coordinates are given;",
			WARNING3="Character to move not present;";

	@Tags("parseMove")
	public Runnable parseMove(ClearableHistoryInterface chi,int index) {
		ArrayList<Integer> num=new ArrayList<Integer>();


		try {
			next();
			AvatarInterface av= (AvatarInterface) table.get(next().getInput().toLowerCase());
			while(peek() instanceof Plus ||peek() instanceof Number ||peek() instanceof Minus) {
				if(isInteger(peek().getInput())) {
					num.add(((Number) next()).getValue());
				}

				else if(peek() instanceof Minus) {
					next();
					num.add(-((Number) next()).getValue());
				}
				else if(peek() instanceof Plus) {
					next();
					num.add(((Number) next()).getValue());
				}
			}
			return new UndoableMoveCommand(new MoveCommand(av,num.get(0),num.get(1)));
		}
		catch(NumberFormatException e){
			errors+=WARNING1;
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			System.out.println("Unexpected Input");
			return null;
		}
		catch(IndexOutOfBoundsException e){
			errors+=WARNING2;
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			System.out.println("Unexpected Input");
			return null;
		}
		catch(NullPointerException e) {
			errors+="Move command not right, pls give command again";
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			return null;
		}
		catch (ClassCastException e) {
			errors=WARNING3;
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			return null;
		}

	}
	@Tags("parseSay")
	public Runnable parseSay(ClearableHistoryInterface chi,int index) {
		try {
			bridge_scene.say(((QuotedString)(chi.elementAt(index+1))).getInput());
			next();
			return new SayCommand(bridge_scene,((QuotedString)(chi.elementAt(index+1))).getInput());
		}
		catch(ArrayIndexOutOfBoundsException e){
			errors+="Please give something to say;";
			pls.notifyAllListeners(new PropertyChangeEvent(this,"Errors",null,getErrors()));
			System.out.println("Unexpected Input");
			return null;
		}
	}
	public Runnable parseRotateRightArmCommand() throws ParsingException {
		try {
			int n=0;
			next();
			AvatarInterface av=table.get(next().getInput().toLowerCase());

			if(isInteger(peek().getInput())) {
				n=(((Number) next()).getValue());
			}

			else if(peek() instanceof Minus) {
				next();
				n=-((Number) next()).getValue();
			}
			else if(peek() instanceof Plus) {
				next();
				n=(((Number) next()).getValue());
			}
			return new RotateRightArmCommand(av,n);
		}
		catch(Exception e) {
			throw new ParsingException("The rotaterightarm command is invalid. Syntax : <command> <character> <Integer>");
		}
	}
	public Runnable parseRotateLeftArmCommand() throws ParsingException {
		try {
			int n=0;
			next();
			AvatarInterface av=table.get(next().getInput().toLowerCase());

			if(isInteger(peek().getInput())) {
				n=(((Number) next()).getValue());
			}

			else if(peek() instanceof Minus) {
				next();
				n=-((Number) next()).getValue();
			}
			else if(peek() instanceof Plus) {
				next();
				n=(((Number) next()).getValue());
			}
			return new RotateLeftArmCommand(av,n);
		}
		catch(Exception e) {
			throw new ParsingException("The rotaterightarm command is invalid. Syntax : <command> <character> <Integer>");
		}
	}
	public Runnable parseSleepCommand() throws ParsingException {
		next();
		try {
			long n= (((Number) next()).getValue());
			return new SleepCommand(n);
		}
		catch(Exception e) {
			throw new ParsingException("The sleep command is invalid. Syntax: <Command> <Integer>");
		}
	}
	public Runnable parseDefineCommand() throws ParsingException {
		next();
		try {
			String s=((Word)next()).getValue();
			return new DefineCommand(s,parseCommand());
		}
		catch(Exception e) {
			throw new ParsingException("The Define command is invalid. Syntax: <Define> <Name> <Command>");
		}
	}
	public Runnable parseThreadCommand() throws ParsingException {
		next();
		try {
			String s=((Word)next()).getValue();
			return new ThreadCommand(s);
		}
		catch(Exception e) {
			throw new ParsingException("The Thread command is invalid. Syntax: <Define> <Name> <Command>");
		}
	}
	public Runnable parseCallCommand() throws ParsingException {
		next();
		try {
			String s=((Word)next()).getValue();
			return new CallCommand(s);
		}
		catch(Exception e) {
			throw new ParsingException("The Thread command is invalid. Syntax: <Define> <Name> <Command>");
		}
	}
	public Runnable parseProceedAllCommand() throws ParsingException {
		next();
		return new ProceedAllCommand();
	}
	public TokenInterface next() {
		TokenInterface ti;
		ti=peek();
		i=i+1;
		return ti;
	}
	public TokenInterface peek() {
		if(hasNext())
			return a.elementAt(i);
		else
			return null;
	}
	private boolean hasNext() {
		if(i+1<=a.size())
			return true;
		else
			return false;
	}
	public void reset() {
		i=0;
	}
	@Visible(false)
	public TableInterface<AvatarInterface> getTable() {
		initTable();
		return table;
	}
	public String getErrors() {return errors;}
	public String getCommand() {
		return command;
	}

	public void initTable() {
		table.put(CHARS[0], bridge_scene.getLancelot());
		table.put(CHARS[1], bridge_scene.getRobin());
		table.put(CHARS[2], bridge_scene.getGuard());
		table.put(CHARS[3], bridge_scene.getGalahad());
		table.put(CHARS[4], bridge_scene.getArthur());
	}
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		pls.addElement(arg0);

	}
	public static boolean isInteger(String string) {
		try {
			Integer.valueOf(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public Runnable getCommandObject() {
		return r;
	}

}
