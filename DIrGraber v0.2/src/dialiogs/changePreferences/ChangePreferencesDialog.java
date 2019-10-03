package dialiogs.changePreferences;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import application.Window;
import dialiogs.CloseDialogAction;
import dialiogs.FolderChouserAction;
import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class ChangePreferencesDialog extends StandardDialogAbstract{
	
	private JTextField txtName;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtDestination;
	private JCheckBox checkRecive;
	private JButton btnFileChouser;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnHelp;
	
	public ChangePreferencesDialog() {
		super("change preferences");
		
		addWindowListener(new PreferencesWindowListener());
		setLayout(new BorderLayout());
		
		JLabel lblTitle = new JLabel("<html>SETUP <u>YOUR</u> CONNECTION</html>");
		JLabel lblName = new JLabel("NAME: ");
		JLabel lblIp = new JLabel("IP: ");
		JLabel lblPort = new JLabel("PORT: ");
		JLabel lblDefaultFolder = new JLabel("DEFAULT FOLDER: ");
		
		txtName = new JTextField();
		txtName.setToolTipText("<html>NAME OF YOUR CONNECTION<br/>CAN'T BE LONGER THAN 50 CHARACTERS</html>");
		
		txtIp = new JTextField();
		txtIp.setToolTipText("YOUR IP ADDRESS");
		txtIp.setEditable(false);
		
		txtPort = new JTextField();
		txtPort.setToolTipText("<html>YOUR PORT NUMBER OF CONNECTION<br/>AN NUMBER BETWEEN 1024 AND 65535</html>");

		txtDestination = new JTextField();
		txtDestination.setToolTipText("CHOUSE A DEFAULT FOLDER FOR SAVEING FILES");
		
		checkRecive = new JCheckBox("CAN RECIVE FILES");
		checkRecive.setToolTipText("CAN RECIVE FILES");

		btnSave = new JButton("SAVE");
		btnSave.setAction(new SavePreferencesAction(this));
		btnSave.setText("SAVE");
		btnSave.setToolTipText("SAVE CHANGES");
		
		btnHelp = new JButton("HELP");
		btnHelp.setToolTipText("HELP");
		btnHelp.setAction(null);
		btnHelp.setText("HELP");

		btnFileChouser = new JButton("...");
		btnFileChouser.setAction(new FolderChouserAction(txtDestination, this));
		btnFileChouser.setText("...");
		btnFileChouser.setToolTipText("CHOUSE A DEFAULT FOLDER FOR SAVEING FILES");
		
		btnCancel = new JButton("CANCEL");
		btnCancel.setAction(new CloseDialogAction(this));
		btnCancel.setText("CANCEL");
		btnCancel.setToolTipText("DON'T SAVE CHANGES");
				

		//first time must do config
		if(Window.getInstance().isEmptyPreferences()) {
			btnCancel.setEnabled(false);
		}
		
		JPanel center = new JPanel();
		center.setLayout(new GridBagLayout());
		center.add(lblTitle, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER, new Insets(10, 20, 0, 0), 250, 10));
		center.add(lblName, new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 20, 0, 0), 50, 10));
		center.add(txtName, new GridBagConstraints(1, 1, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 200, 10));
		center.add(lblIp, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 20, 0, 0), 50, 10));
		center.add(txtIp, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 200, 10));
		center.add(lblPort, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 20, 0, 0), 50, 10));
		center.add(txtPort, new GridBagConstraints(1, 3, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 50, 10));
		center.add(lblDefaultFolder, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(10, 20, 0, 0), 50, 10));
		center.add(txtDestination, new GridBagConstraints(1, 4, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 300, 10));
		center.add(btnFileChouser, new GridBagConstraints(2, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 30, 10));
		center.add(checkRecive, new GridBagConstraints(1, 5, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 100, 10));

		JPanel south = new JPanel();
		south.setLayout(new FlowLayout(FlowLayout.RIGHT));
		south.add(btnHelp);
		south.add(btnSave);
		south.add(btnCancel);
		
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
	}
	
	public String getIpField() {
		return txtIp.getText();
	}

	public void setIpField(String txtIp) {
		this.txtIp.setText(txtIp);
	}

	public String getNameField() {
		return txtName.getText();
	}
	
	public void setNameField(String name) {
		txtName.setText(name);
	}

	public String getPortField() {
		return txtPort.getText();
	}
	
	public void setPortField(String port) {
		txtPort.setText(port);
	}

	public String getDestinationField() {
		return txtDestination.getText();
	}
	
	public void setDestinationField(String destination) {
		txtDestination.setText(destination);
	}

}
