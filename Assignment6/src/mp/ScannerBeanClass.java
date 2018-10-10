package mp;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"ScannerBean"})
@ StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ScannerBeanClass implements ScannerBeanInterface {
	String ScannedString=""; TokenInterface tokens[];//static String[]Errors=new String[50];
	TokenInterface[] Large;
	public void setScannedString(String newStr) {
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
	public static TokenInterface[] scanString(String inputString) {
		int j=indexOfNot(inputString,' ',0),k=0;String temp=""; TokenInterface L[]= new TokenInterface[100]; //int l=0;
		inputString=inputString+" ";
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
					//Errors[l]="closing double quote missing";
					//l++;
					temp=inputString.substring(j+1,inputString.length()-1);
					if(indexOfNot(inputString,' ',j+1)!=-1) {
					L[k]=new QuotedString(temp);
					k++;
					}
					j=inputString.length()-1;
					temp="";
				}
				else {
					temp=inputString.substring(j+1,indexOf(inputString,'"',j+1));
					L[k]=new QuotedString(temp);
					k++;
					j=indexOf(inputString,'"',j+1)+1;}
				    temp=""; 

			}

			else if(inputString.charAt(j)=='+') {
				temp+=inputString.charAt(j);
				L[k]=new Plus(temp);
				k++;
				j++;
				temp="";
			}
			else if(inputString.charAt(j)=='-') {
				temp+=inputString.charAt(j);
				L[k]=new Minus(temp);
				k++;
				j++;
				temp="";
			}


			else if(inputString.charAt(j)=='{') {
				temp+=inputString.charAt(j);
				L[k]=new StartToken(temp);
				k++;
				j++;
				temp="";
			}
			else if(inputString.charAt(j)=='}') {
				temp+=inputString.charAt(j);
				L[k]=new EndToken(temp);
				k++;
				j++;
				temp="";
			}

			else {

				if (isInteger(temp)) {
					L[k]=new Number(temp);
					k++;

				}

				else{
					TokenInterface ti= new Word(temp);
					if(temp.length()>0) {
						try {

							if(ti.getInput().equalsIgnoreCase("move")) {
								Move m= new Move(ti.getInput());
								L[k]=m;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("call")) {
								Call c= new Call(ti.getInput());
								L[k]=c;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("define")) {
								Define d= new Define(ti.getInput());
								L[k]=d;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("approach")) {
								Approach a= new Approach(ti.getInput());
								L[k]=a;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("fail")) {
								Fail f= new Fail(ti.getInput());
								L[k]=f;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("pass")) {
								Pass p= new Pass(ti.getInput());
								L[k]=p;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("proceedAll")) {
								ProceedAll pa= new ProceedAll(ti.getInput());
								L[k]=pa;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("redo")) {
								Redo rdo= new Redo(ti.getInput());
								L[k]=rdo;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("say")) {
								Say say= new Say(ti.getInput());
								L[k]=say;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("repeat")) {
								Repeat rpt= new Repeat(ti.getInput());
								L[k]=rpt;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("RotateLeftArm")) {
								RotateLeftArm rla= new RotateLeftArm(ti.getInput());
								L[k]=rla;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("RotateRightArm")) {
								RotateRightArm rra= new RotateRightArm(ti.getInput());
								L[k]=rra;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("sleep")) {
								Sleep slp= new Sleep(ti.getInput());
								L[k]=slp;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("thread")) {
								Thread thrd= new Thread(ti.getInput());
								L[k]=thrd;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("undo")) {
								Undo und= new Undo(ti.getInput());
								L[k]=und;
								k++;
							}
							else if(ti.getInput().equalsIgnoreCase("wait")) {
								Wait wt= new Wait(ti.getInput());
								L[k]=wt;
								k++;
							}
							else {		
								L[k]=new Word(temp);
								k++;
							}
						}
						catch(Exception e) {
							L[k]=new QuotedString(temp);
							k++;
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
		String newStr=str.trim();
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
	/*public String[] getErrors() {
    	return Errors;
    }*/
}

