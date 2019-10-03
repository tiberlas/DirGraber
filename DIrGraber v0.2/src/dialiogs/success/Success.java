package dialiogs.success;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dialiogs.CloseDialogAction;
import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class Success extends StandardDialogAbstract{

	private JButton btnCancel;
	
	public Success() {
		super("success");
		
		JLabel lblTitle = new JLabel("FILE HAS SUCCESSFULLY TRANSFERED!");
		btnCancel = new JButton("FINISH");
		btnCancel.setAction(new CloseDialogAction(this));
		btnCancel.setText("FINISH");
		btnCancel.setToolTipText("CLOSE THIS WINDOW");
		
		Icon packingAnimation = new ImageIcon("ressourses\\pictures\\folder.gif");
		JLabel imageHolder = new JLabel(packingAnimation);
		
		add(imageHolder, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 20, 0, 20), 200, 10));				
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 200, 10));
		add(btnCancel, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 30, 10));
	}
}
