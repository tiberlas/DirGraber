package dialiogs.packing;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class Packing extends StandardDialogAbstract{
	
	private JProgressBar progres;
	private JButton btnCancel;
	
	public Packing() {
		super("packing");
		
		JLabel lblTitle = new JLabel("FILE IS PACKING. PLEASE WAIT.");
		progres = new JProgressBar(0, 100);
		
		//animation is good only the background should be white(the background color)
		Icon packingAnimation = new ImageIcon("ressourses\\pictures\\packing_animation.gif");
		JLabel imageHolder = new JLabel(packingAnimation);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setAction(new ClosePackingDialogAction(this));
		btnCancel.setText("CANCEL");
		btnCancel.setToolTipText("THE FILE WON'T BE SENT");
		
		add(imageHolder, new GridBagConstraints(0, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 20, 0, 20), 200, 10));		
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(20, 20, 0, 20), 200, 10));
		add(progres, new GridBagConstraints(0, 1, 2, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(20, 20, 0, 20), 450, 12));
		add(btnCancel, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 30, 10));
	}

	public void setProgres(int progres) {
		this.progres.setValue(progres);
	}
}
