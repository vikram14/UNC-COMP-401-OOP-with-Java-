package mp;

import java.beans.PropertyChangeListener;

import javax.swing.JFrame;

public class CommandInterpreterMVCComposer {
	public static  void edit(CommandInterpreterInterface ci) {
		CommandInterpreterFrameComposer aFrameComposer = new CommandInterpreterFrameComposer();
		new CommandInterpreterController(ci,aFrameComposer.getCommandField(),aFrameComposer.getMenu(),aFrameComposer.getButton(),aFrameComposer.getButton2(),aFrameComposer.getButton3(),aFrameComposer.getButton4(),aFrameComposer.getButton5());
		PropertyChangeListener View = new CommandInterpreterView(aFrameComposer.getCommandField(),aFrameComposer.getErrorsField());
		ci.addPropertyChangeListener(View);
		JFrame aBMIFrame = aFrameComposer.composeFrame();
		aBMIFrame.setVisible(true);	
	}
	/*public static void main(String[]args) {
		CommandInterpreterInterface ci= new CommandInterpreter();
		CommandInterpreterMVCComposer.edit(ci);
	}*/

}
