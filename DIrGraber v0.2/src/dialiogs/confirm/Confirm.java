package dialiogs.confirm;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import dialiogs.CloseDialogAction;
import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class Confirm extends StandardDialogAbstract{
	
	private JTextField txtSaveTo;
	private JButton btnFileChouser;
	private JButton btnSave;
	private JButton btnCancel;
	
	public Confirm(String name, String size) {
		super("confirm");
		
		JLabel lblTitle = new JLabel("DO YOU WANT TO SAVE A FILE FROM " + name + " ?");
		JLabel lblSize = new JLabel("<html>SIZE OF FILE IS " + size + " B.<br/>IF YOU WANT TO SAVE THE FILE YOU CAN CHANGE THE DEFAULT FOLDER FOR SAVEING FILES.</html>");
		JLabel lblDestination = new JLabel("SAVE TO: ");
		
		txtSaveTo = new JTextField();
		btnFileChouser = new JButton("...");
		btnSave = new JButton("SAVE");
		btnCancel = new JButton("CANCEL");
		
		btnCancel.setAction(new CloseDialogAction(this));
		btnCancel.setText("CANCEL");
		
		btnFileChouser.setToolTipText("CHOUSE A FOLDER TO SAVE THE FILE");
		btnSave.setToolTipText("SAVE THE FILE");
		btnCancel.setToolTipText("DON'T SAVE THE FILE");
		
		add(lblTitle, new GridBagConstraints(1, 0, 3, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NORTH, new Insets(10, 20, 0, 0), 200, 10));
		add(lblSize, new GridBagConstraints(1, 1, 3, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NORTH, new Insets(10, 20, 0, 0), 200, 10));
		add(lblDestination, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(10, 20, 0, 0), 10, 10));
		add(txtSaveTo, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 20, 0, 0), 200, 10));
		add(btnFileChouser, new GridBagConstraints(2, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 20, 0, 0), 30, 10));
		add(btnSave, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(40, 10, 0, 0), 30, 10));
		add(btnCancel, new GridBagConstraints(2, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(42, 10, 0, 10), 30, 10));
		
	}

}
