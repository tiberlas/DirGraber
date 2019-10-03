package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SendPanel extends JPanel{
	
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtFilePath;
	private JButton btnFileChouser;
	private JButton btnTest;
	private JButton btnSend;
	
	public SendPanel() {
		super();
		setLayout(new BorderLayout());
		
		JLabel lblFile = new JLabel("FILE: ");
		JLabel lblIp = new JLabel("IP: ");
		JLabel lblPort = new JLabel("PORT: ");
		
		txtIp = new JTextField();
		txtPort = new JTextField();
		txtFilePath = new JTextField();
		btnFileChouser = new JButton("...");
		btnTest = new JButton("TEST");
		btnSend = new JButton("SEND");
		
		txtIp.setToolTipText("IP ADDRES OF THE RECIVER");
		txtPort.setToolTipText("PORT OF THE RECIVER");
		txtFilePath.setToolTipText("CHOUSE A FILE TO SEND");
		btnFileChouser.setToolTipText("CHOUSE A FILE TO SEND");
		btnTest.setToolTipText("TEST THE CONNECTIN");
		btnSend.setToolTipText("SEND THE FILE");

		JPanel center = new JPanel();
		center.setLayout(new GridBagLayout());
		center.add(lblIp, new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(10, 20, 0, 0), 30, 10));
		center.add(txtIp, new GridBagConstraints(2, 1, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 200, 10));
		center.add(lblPort, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(10, 20, 0, 0), 30, 10));
		center.add(txtPort, new GridBagConstraints(2, 2, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 50, 10));
		center.add(lblFile, new GridBagConstraints(1, 3, 2, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(10, 20, 0, 0), 30, 10));
		center.add(txtFilePath, new GridBagConstraints(2, 3, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 400, 10));
		center.add(btnFileChouser, new GridBagConstraints(3, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 0, 0, 0), 50, 10));

		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottom.add(btnTest);
		bottom.add(btnSend);
		
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
	}

}
