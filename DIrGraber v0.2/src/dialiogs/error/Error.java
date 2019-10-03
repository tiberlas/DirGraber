package dialiogs.error;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dialiogs.CloseDialogAction;
import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class Error extends StandardDialogAbstract{

	private JButton btnCancel;
	
	public Error(String message) {
		super("error");
		
		JLabel lblTitle = new JLabel("<html>AN ERROR HAS OCCURED!<br/>"+message+"</html>");
		
		btnCancel = new JButton();
		btnCancel.setAction(new CloseDialogAction(this));
		btnCancel.setText("CLOSE");
		btnCancel.setToolTipText("CLOSE THE ERROR WINDOW");
		
		Icon packingAnimation = new ImageIcon("ressourses\\pictures\\error.gif");
		JLabel imageHolder = new JLabel(packingAnimation);
		imageHolder.setPreferredSize(new Dimension(150, 200));
		
		add(imageHolder, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 50, 50));
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 50, 10));
		add(btnCancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 20, 0, 20), 30, 10));
	}
}
