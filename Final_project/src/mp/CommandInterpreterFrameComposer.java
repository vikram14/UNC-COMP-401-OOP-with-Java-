package mp;

import java.awt.GridLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CommandInterpreterFrameComposer implements CommandInterpreterFrameComposerInterface{
	JFrame frame = new JFrame("Command Interpreter");
	JTextField commandField = new JTextField();	 
	JLabel commandLabel = new JLabel("Command:");
	JLabel buttonLabel = new JLabel("Move in X");
	JPanel commandPanel = new JPanel();
	JButton button = new JButton();
	JPanel buttonPanel = new JPanel();
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Move in Y");
	JMenuItem menuItem = new JMenuItem();
	JPanel menuPanel = new JPanel();
	JTextField errorsField = new JTextField();	 
	JLabel errorsLabel = new JLabel("Errors:");
	JPanel errorsPanel = new JPanel();
	JButton button2 = new JButton();
	JPanel buttonPanel2 = new JPanel();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	
	public void composeLabelledField(JPanel aPanel,JLabel aLabel, JTextField aField) {
		aPanel.setLayout(new GridLayout(1, 2)); // align the components of aPanel in a row with two columns
		aPanel.add(aLabel);
		aPanel.add(aField);		
	}
	public  void composeButton() {
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(buttonLabel);
		button.setSize(100,110);
		buttonPanel.add(button);
		buttonPanel2.setLayout(new GridLayout(1, 4));
		button2.setText("Say");
		button3.setText("approach");
		button4.setText("pass");
		button5.setText("fail");
		buttonPanel2.add(button2);
		buttonPanel2.add(button3);
		buttonPanel2.add(button4);
		buttonPanel2.add(button5);
	}
	public  void composeMenu() {
		menubar.add(menu);	
	}
	public JFrame composeFrame() {
		composeLabelledField(commandPanel,commandLabel, commandField);
		composeLabelledField(errorsPanel,errorsLabel, errorsField);		
		composeButton();
		composeMenu();
		frame.setLayout(new GridLayout(4, 1));
		frame.setJMenuBar(menubar);
		frame.add(commandPanel);
		frame.add(errorsPanel);
		frame.add(buttonPanel);
		frame.add(buttonPanel2);
		frame.setSize(250, 300);
	//	frame.setVisible(true);
		return frame;
	}
	public JFrame getFrame() {
		return frame;
	}
	public JButton getButton() {
		return button;
	}
	public JTextField getCommandField() {
		return commandField;
	}
	public JLabel getCommandLabel() {
		return commandLabel;
	}
	public JPanel getButtonPanel() {
		return buttonPanel;
	}
	public JPanel getButtonPanel2() {
		return buttonPanel;
	}
	
	public JPanel getMenuPanel() {
		return menuPanel;
	}
	public JMenu getMenu() {
		return menu;
	}
	public JPanel getErrorsPanel() {
		return menuPanel;
	}
	public JTextField getErrorsField() {
		return errorsField;
	}
	public JLabel getErrorsLabel() {
		return errorsLabel;
	}
	public JButton getButton2() {
		return button2;
	}
	public JButton getButton3() {
		return button3;
	}
	public JButton getButton4() {
		return button4;
	}
	public JButton getButton5() {
		return button5;
	}
}

