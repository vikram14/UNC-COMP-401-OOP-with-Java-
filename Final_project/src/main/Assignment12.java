package main;
import javax.swing.JFrame;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import mp.*;
import util.misc.ThreadSupport;
public class Assignment12 {
	public static void main(String[] args){
		Animations ani = new Animations();
		ani.animate();
		/*animateScanner();
		System.out.println("-".toLowerCase());
		ThreadSupport.sleep(5000);
		(new TestBridgeScene ()).test();*/
	}
	public static void animateScanner() {
		ScannerBeanClass scb=new ScannerBeanClass();
		OEFrame oeFrame=ObjectEditor.edit(scb);
		//scb.setScannedString("move 050 { saY \"hi!\" }\"");
		oeFrame.refresh();
		ThreadSupport.sleep(3000);


		/*	public static void scanString(String inputString) {
		int j=indexOfNot(inputString,' ',0),sum=0,product=1;String tempNum="", tempWord="",tempQuotedString="";
		inputString=inputString+" ";
		while(j<inputString.length() && j!=-1) {
			if(Character.isLetter(inputString.charAt(j))){
				tempWord+=inputString.charAt(j);
				j++;
				continue;
			}
			else if(Character.isDigit(inputString.charAt(j))) {
				tempNum+=inputString.charAt(j);
				j++;
				if(j==inputString.length()) {
					System.out.println(tempNum);
					tempNum="";
				}
				}
			else if(inputString.charAt(j)=='"' && indexOf(inputString,'"',j+1)!=-1){
				tempQuotedString=inputString.substring(j+1,indexOf(inputString,'"',j+1));
				j=indexOf(inputString,'"',j+1)+1;
				System.out.println(j);
			}
			else {
				if (tempNum.length()>0) {
				System.out.println("Number: "+tempNum);
				tempNum="";
				}
				else if(tempWord.length()>0) {
					System.out.println("Word: "+tempWord);
					tempWord="";
				}
				else if(tempQuotedString.length()>0){
					System.out.println("Quoted String: "+tempQuotedString);
					tempQuotedString="";
				}
				else
				j=indexOfNot(inputString,inputString.charAt(j),j);
			}
			}

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
}*/
		/*public static void scanString(String inputString) {
int j,sum = 0,product = 1; 
System.out.println("Tokens:");
for(j=0;j<inputString.length();j++) {
	char ch= inputString.charAt(j);
	if(ch==' ') {
		continue;
	}
	else {
      System.out.println(inputString.substring(j,indexOf(inputString,' ',j+1)));
      sum+=Integer.parseInt(inputString.substring(j,indexOf(inputString,' ',j+1)));
      product*=Integer.parseInt(inputString.substring(j,indexOf(inputString,' ',j+1)));
	  j=indexOf(inputString,' ',j+1)-1;
	  }
}
System.out.println("Sum:");
System.out.println(sum);
System.out.println("Product:");
System.out.println(product);
}

		 */
	}
}
