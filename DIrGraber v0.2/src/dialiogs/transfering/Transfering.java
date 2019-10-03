package dialiogs.transfering;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class Transfering extends StandardDialogAbstract{
	private JProgressBar progres;
	private JButton btnCancel;
	
	
	public Transfering() {
		super("transfering file");
		
		JLabel lblTitle = new JLabel("TRANSFERING FILE. PLEASE WAIT.");
		progres = new JProgressBar(0, 100);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setAction(new CloseTransferingDialogAction(this));
		btnCancel.setText("CANCEL");
		btnCancel.setToolTipText("THE FILE WON'T BE TRANSFERED");
		
		Icon packingAnimation = new ImageIcon("ressourses\\pictures\\transfer_animation.gif");
		JLabel imageHolder = new JLabel(packingAnimation);
		
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 200, 10));
		add(imageHolder, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 200, 10));
		add(progres, new GridBagConstraints(0, 2, 2, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 450, 12));
		add(btnCancel, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 30, 10));
	}

}
