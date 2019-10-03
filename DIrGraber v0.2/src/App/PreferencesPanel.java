package app;

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

import model.Preferences;
import observer.IObserver;

@SuppressWarnings("serial")
public class PreferencesPanel extends JPanel implements IObserver {
	
	private JTextField txtName;
	private JTextField txtIp;
	private JTextField txtPort;
	private JCheckBox checkRecive;
	private JButton btnPreferences;
	
	public PreferencesPanel() {
		super();
		setLayout(new BorderLayout());
		
		JLabel lblName = new JLabel("NAME: ");
		JLabel lblIp = new JLabel("IP: ");
		JLabel lblPort = new JLabel("PORT: ");
		
		txtName = new JTextField();
		txtIp = new JTextField();
		txtPort = new JTextField();
		checkRecive = new JCheckBox("CAN RECIVE FILES");
		
		txtName.setEditable(false);
		txtIp.setEditable(false);
		txtPort.setEditable(false);
		checkRecive.setEnabled(false);
		
		btnPreferences = new JButton("CHANGE");
		btnPreferences.setAction(new PreferencesAction());
		btnPreferences.setText("CHANGE");
		checkRecive.setToolTipText("IF CHECKED YOU CAN RECIVE FILES");
		btnPreferences.setToolTipText("CHANGE PREFERENCES");
		
		JPanel center = new JPanel();
		center.setLayout(new GridBagLayout());
		center.add(lblName, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.CENTER, new Insets(10, 20, 0, 0), 30, 10));
		center.add(txtName, new GridBagConstraints(1, 0, 2, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 200, 10));
		center.add(lblIp, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.CENTER, new Insets(10, 20, 0, 0), 30, 10));
		center.add(txtIp, new GridBagConstraints(1, 1, 2, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 200, 10));
		center.add(lblPort, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.CENTER, new Insets(10, 0, 0, 0), 30, 10));
		center.add(txtPort, new GridBagConstraints(1, 2, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 50, 10));
		center.add(checkRecive, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 50, 10));

		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottom.add(btnPreferences);
		
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
	}

	@Override
	public void update() {
		Preferences newPreferences = Window.getInstance().getPreferences();
		txtName.setText(newPreferences.getName());
		txtPort.setText(String.valueOf(newPreferences.getPort()));
		
	}

}
