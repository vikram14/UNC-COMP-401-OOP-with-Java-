package mp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface CommandInterpreterFrameComposerInterface {
	public JFrame composeFrame();
	public JFrame getFrame();
	public JButton getButton();
	public JTextField getCommandField();
	public JLabel getCommandLabel();
	public JPanel getButtonPanel();
	public JPanel getButtonPanel2();
	public JPanel getMenuPanel();
	public JMenu getMenu();
	public JPanel getErrorsPanel();
	public JTextField getErrorsField();
	public JLabel getErrorsLabel();
	public JButton getButton2();
	public JButton getButton3();
	public JButton getButton4();
	public JButton getButton5();
}
