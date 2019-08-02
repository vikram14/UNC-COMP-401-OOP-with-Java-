package mp;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JTextField;

import util.annotations.Tags;
@Tags("CommandInterpreterView")
public class CommandInterpreterView implements PropertyChangeListener {
	JTextField command, errors; //JMenu menu;JButton button;

	public CommandInterpreterView(JTextField c,JTextField e) {//,JButton b,JMenu m) {
		command=c;
		errors=e;
		//menu=m;
		//button=b;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().toString().equals("Errors"))
			errors.setText(evt.getNewValue().toString());
		else {
			if(evt.getPropertyName().toString().equals("Command"))
				System.out.println(evt.getNewValue().toString());
				command.setText(evt.getNewValue().toString());
		}
	}

}
