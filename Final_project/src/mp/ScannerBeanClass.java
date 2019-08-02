package mp;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"ScannerBean"})
@ StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ScannerBeanClass implements ScannerBeanInterface {
	String ScannedString=""; TokenInterface tokens[];//static String[]Errors=new String[50];
	TokenInterface[] Large; ClearableHistoryInterface  clb_history=new ClearableHistory(); String errors="";
	public void setScannedString(String newStr) throws ScanningException {
		ScannedString=newStr; int i;
		Large=scanString(ScannedString);
		for(i=0;i<Large.length;i++) {
			if(Large[i]==null)
				break;
		}
		tokens=new TokenInterface[i];
		for(int j=0;j<tokens.length;j++)
			tokens[j]=Large[j];
	}
	public String getScannedString() {
		return ScannedString;
	}
	public  TokenInterface[] scanString(String inputString) throws ScanningException {
		int j=indexOfNot(inputString,' ',0),k=0;String temp=""; TokenInterface L[]= new TokenInterface[100]; //int l=0;
		inputString=inputString+" ";
		clb_history.clear();
		for (int i=0;i<L.length;i++)
			L[i]= null;
		//for (int i=0;i<L.length;i++)
		//   Errors[i]=null;

		while(j<inputString.length() && j!=-1) {
			if(Character.isLetter(inputString.charAt(j))){
				temp+=inputString.charAt(j);
				j++;
				continue;
			}
			else if(Character.isDigit(inputString.charAt(j))) {
				temp+=inputString.charAt(j);
				j++;
			}
			else if(inputString.charAt(j)=='"'){
				if(indexOf(inputString,'"',j+1)==-1) {
					System.out.println("closing double quote missing");
					errors+="closing double quote missing";
					//Errors[l]="closing double quote missing";
					//l++;
					temp=inputString.substring(j+1,inputString.length()-1);
					if(indexOfNot(inputString,' ',j+1)!=-1) {
						L[k]=new QuotedString(temp);
						clb_history.addElement(new QuotedString(temp));
						k++;
					}
					j=inputString.length()-1;
					temp="";
				}
				else {
					temp=inputString.substring(j+1,indexOf(inputString,'"',j+1));
					L[k]=new QuotedString(temp);
					clb_history.addElement(new QuotedString(temp));
					k++;
					j=indexOf(inputString,'"',j+1)+1;}
				temp=""; 

			}

			else if(inputString.charAt(j)=='+') {
				temp+=inputString.charAt(j);
				L[k]=new Plus(temp);
				clb_history.addElement(new Plus(temp));
				k++;
				j++;
				temp="";
			}
			else if(inputString.charAt(j)=='-') {
				temp+=inputString.charAt(j);
				L[k]=new Minus(temp);
				clb_history.addElement(new Minus(temp));
				k++;
				j++;
				temp="";
			}


			else if(inputString.charAt(j)=='{') {

				temp+=inputString.charAt(j);
				L[k]=new StartToken(temp);
				clb_history.addElement(new StartToken(temp));
				k++;
				j++;
				temp="";
			}
			else if(inputString.charAt(j)=='}' ) {
				if(temp.length()>=1){
					if (isInteger(temp)) {
						L[k]=new Number(temp);
						clb_history.addElement(new Number(temp));
						k++;
						temp="";
						continue;						
					}
					else {
						L[k]=new Word(temp);
						clb_history.addElement(new Word(temp));
						temp="";
						continue;}
				}
				temp+=inputString.charAt(j);
				L[k]=new EndToken(temp);
				clb_history.addElement(new EndToken(temp));
				k++;
				j++;
				temp="";
			}
			else if (!Character.isLetter(inputString.charAt(j)) && !Character.isDigit(inputString.charAt(j)) && !Character.isWhitespace(inputString.charAt(j))) {
				j++;
				throw new ScanningException("Invalid char input");
			}

			else {

				if (isInteger(temp)) {
					L[k]=new Number(temp);
					clb_history.addElement(new Number(temp));
					k++;

				}

				else{
					WordInterface ti= new Word(temp);
					TokenInterface ti1= new Word(temp);
					if(temp.length()>0) {
						try {

							if(ti.getInput().equalsIgnoreCase("move")) {
								//Move m= (Move) ti;
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("call")) {
								//Call c= new Call(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("define")) {
								//Define d= new Define(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("approach")) {
								//Approach a= new Approach(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("failed")) {
								//Fail f= new Fail(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("passed")) {
								//Pass p= new Pass(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("proceedAll")) {
								//ProceedAll pa= new ProceedAll(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("redo")) {
								//Redo rdo= new Redo(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("say")) {
								//	Say say= new Say(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("repeat")) {
								//Repeat rpt= new Repeat(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("RotateLeftArm")) {
								//	RotateLeftArm rla= new RotateLeftArm(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("RotateRightArm")) {
								//	RotateRightArm rra= new RotateRightArm(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("sleep")) {
								//Sleep slp= new Sleep(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("thread")) {
								//	Thread thrd= new Thread(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("undo")) {
								//	Undo und= new Undo(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else if(ti.getInput().equalsIgnoreCase("wait")) {
								//Wait wt= new Wait(ti.getInput());
								L[k]=ti;
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
							else {		
								L[k]=ti; //;new Word(temp);
								clb_history.addElement(ti1);
								k++;
								temp="";
							}
						}
						catch(Exception e) {
							L[k]=new QuotedString(temp);
							clb_history.addElement(new QuotedString(temp));
							k++;
							temp="";
						}
					}
				}
				temp="";
				j=indexOfNot(inputString,inputString.charAt(j),j);
			}
		}
		return L;
	}





	public static int indexOfNot(String str,char c,int fromIndex) {
		for(int k=fromIndex;k<str.length();k++){
			if (str.charAt(k)!=c)
				return k;
		}
		return-1;
	}

	public static int indexOf(String str,char c,int fromIndex) {
		String newStr=Trim(str);
		newStr=newStr+" ";
		for(int i=fromIndex;i<newStr.length();i++) {
			if (newStr.charAt(i)==c)
				return i;

		}
		return -1;
	}
	public static boolean isInteger(String string) {
		try {
			Integer.valueOf(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	public TokenInterface[] getTokens() {
		return tokens;
	}
	public static String Trim(String s) {
		String str = s;
		int start = 0;
		int end = 0;
		for (int i = 0; i < str.length(); i++)
		{
			char c = str.charAt(i);
			if ((int) c != 32)
			{                
				start = i;
				break;
			}            
		}
		for (int i = str.length()-1; i >= 0; i--)
		{
			char c = str.charAt(i);
			if ((int) c != 32)
			{                
				end = i;
				break;
			}            
		}
		return(str.substring(start,end+1));
	}
	/*public String[] getErrors() {
    	return Errors;
    }*/
	public ClearableHistoryInterface getTokenList() {
		return clb_history;
	}

}

