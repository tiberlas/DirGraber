package dialiogs.waithing;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import dialiogs.CloseDialogAction;
import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class Waiting extends StandardDialogAbstract{
	private JButton btnCancel;
	
	public Waiting() {
		super("waiting");
		
		JLabel lblTitle = new JLabel("WAITING FOR FILE. PLEASE WAIT.");
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setAction(new CloseDialogAction(this));
		btnCancel.setText("CANCEL");
		btnCancel.setToolTipText("THE FILE WON'T BE SAVED");
		
		Icon packingAnimation = new ImageIcon("ressourses\\pictures\\waiting_animation.gif");
		JLabel imageHolder = new JLabel(packingAnimation);
		
		add(imageHolder, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(0, 0, 0, 0), 80, 80));		
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 80, 10));
		add(btnCancel, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 30, 10));
	}

}
