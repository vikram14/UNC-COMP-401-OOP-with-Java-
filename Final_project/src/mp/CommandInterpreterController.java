package mp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import mp.A.BridgeSceneInterface;
import util.annotations.Tags;

@Tags("CommandInterpreterController")
public class CommandInterpreterController implements MenuListener,ActionListener{
	CommandInterpreterInterface ci;JTextField field; JMenuItem menuItem; JButton button,button2,button3,button4,button5; BridgeSceneInterface bs;
	JMenu menu;
	public CommandInterpreterController (CommandInterpreterInterface c, JTextField command,JMenu me ,JButton b,JButton b2,JButton b3,JButton b4,JButton b5) {
		ci=c;
		bs=SingletonsCreator.createBridgeScene();
		field=command;
		menu=me;
		button=b;
		button2=b2;
		button3=b3;
		button4=b4;
		button5=b5;		
		field.addActionListener(this);
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		menu.addMenuListener(this);
        button2.setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			bs.getArthur().move(20,0);
			bs.getGalahad().move(20,0);
			bs.getRobin().move(20,0);
			bs.getGuard().move(20, 0);
			bs.getLancelot().move(20, 0);
		}
		else if(e.getSource()==button2) {
			if(bs.presay())
				bs.say("YOOO!");
			else
                button2.setEnabled(false);
		}
		else if(e.getSource()==button3) {
			//System.out.println("skjfjdfjdjdbjfdjfjdsfjdfjbdjbfsjbjdsjfbjdsjfaj");
			if(bs.preapproach())
				{bs.approach(bs.getArthur());button2.setEnabled(true);button3.setEnabled(false);}
			else
                button3.setEnabled(false);
		}
		else if(e.getSource()==button4) {
			if(bs.prepassed())
				{bs.passed();button3.setEnabled(true);button2.setEnabled(false);}			
			else
                {button3.setEnabled(false);button2.setEnabled(true);}
		}
		else if(e.getSource()==button5) {
			if(bs.prefailed())
				{bs.failed();button3.setEnabled(true);button2.setEnabled(false);}
			else
                {button5.setEnabled(false);button2.setEnabled(true);button3.setEnabled(false);}
		}

		else 
			if(e.getSource()==field) {
				String text=((JTextField) e.getSource()).getText();
				System.out.println(text);
				ci.setCommand(text);		
			}
	}

	@Override
	public void menuCanceled(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuSelected(MenuEvent e) {
		if(e.getSource()==menu) {
			bs.getArthur().move(0,20);
			bs.getGalahad().move(0,20);
			bs.getRobin().move(0,20);
			bs.getGuard().move(0, 20);
			bs.getLancelot().move(0, 20);
		}
	}

}
