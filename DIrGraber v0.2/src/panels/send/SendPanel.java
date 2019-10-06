package panels.send;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.SpeedTransfer;
import panels.send.radiuButtonsActions.BtnFastAction;
import panels.send.radiuButtonsActions.BtnHyperAction;
import panels.send.radiuButtonsActions.BtnMediumAction;
import panels.send.radiuButtonsActions.BtnSlowAction;

@SuppressWarnings("serial")
public class SendPanel extends JPanel{
	
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField txtFilePath;
	private ButtonGroup btnGroup;
	private JRadioButton btnSpeedLow;
	private JRadioButton btnSpeedMedium;
	private JRadioButton btnSpeedFast;
	private JRadioButton btnSpeedHyper;
	private JButton btnFileChouser;
	private JButton btnTest;
	private JButton btnSend;
	private JLabel lblTesting;
	
	private SpeedTransfer speed = SpeedTransfer.MEDIU;
	
	public SendPanel() {
		super();
		setLayout(new BorderLayout());
		
		JLabel lblFile = new JLabel("FILE: ");
		JLabel lblIp = new JLabel("IP: ");
		JLabel lblPort = new JLabel("PORT: ");
		JLabel lblSpeed = new JLabel("SPEED: ");
		lblSpeed.setToolTipText("THE FASTER THE SPEED THE MORE MEMORY IT USES");
		
		lblTesting = new JLabel("TESTING CONNECTION");
		lblTesting.setVisible(false);
		
		
		txtIp = new JTextField();
		txtIp.setToolTipText("IP ADDRES OF THE RECIVER");
		
		txtPort = new JTextField();
		txtPort.setToolTipText("PORT OF THE RECIVER");
		
		txtFilePath = new JTextField();
		txtFilePath.setToolTipText("CHOUSE A FILE TO SEND");
		
		btnFileChouser = new JButton("...");
		btnFileChouser.setToolTipText("CHOUSE A FILE TO SEND");
		btnFileChouser.addActionListener(new FileChouserAction(txtFilePath, this));
		
		btnSpeedLow = new JRadioButton("SLOW", false);
		btnSpeedLow.addActionListener(new BtnSlowAction(speed));
		
		btnSpeedMedium = new JRadioButton("MEDIUM", true);
		btnSpeedMedium.addActionListener(new BtnMediumAction(speed));
		
		btnSpeedFast = new JRadioButton("FAST", false);
		btnSpeedFast.addActionListener(new BtnFastAction(speed));
		
		btnSpeedHyper = new JRadioButton("HYPER", false);
		btnSpeedHyper.addActionListener(new BtnHyperAction(speed));
		
		btnGroup = new ButtonGroup();
		btnGroup.add(btnSpeedLow);
		btnGroup.add(btnSpeedMedium);
		btnGroup.add(btnSpeedFast);
		btnGroup.add(btnSpeedHyper);
		
		JPanel radioBtn = new JPanel();
		radioBtn.setLayout(new FlowLayout());
		radioBtn.add(btnSpeedLow);
		radioBtn.add(btnSpeedMedium);
		radioBtn.add(btnSpeedFast);
		radioBtn.add(btnSpeedHyper);
		
		btnTest = new JButton("TEST");
		btnTest.addActionListener(new TestAction(this));
		btnTest.setToolTipText("TEST THE CONNECTIN");
		
		btnSend = new JButton("SEND");
		btnSend.addActionListener(new SendAction(this));
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
		center.add(lblSpeed, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 50, 10));
		center.add(radioBtn, new GridBagConstraints(2, 4, 1, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 200, 10));
		center.add(lblTesting, new GridBagConstraints(2, 5, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 200, 10));
		
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottom.add(btnTest);
		bottom.add(btnSend);
		
		add(center, BorderLayout.CENTER);
		add(bottom, BorderLayout.SOUTH);
		
	}
	
	public void onTestClick() {
		lblTesting.setVisible(true);
		
		btnTest.setEnabled(false);
		btnSend.setEnabled(false);
	}

	public void TestEnd() {
		lblTesting.setVisible(false);
		
		btnTest.setEnabled(true);
		btnSend.setEnabled(true);		
	}
	
	public String getIpField() {
		return txtIp.getText();
	}

	public void setIpField(String txtIp) {
		this.txtIp.setText(txtIp);
	}

	public String getPortField() {
		return txtPort.getText();
	}

	public void setPortField(String txtPort) {
		this.txtPort.setText(txtPort);
	}

	public String getFilePathField() {
		return txtFilePath.getText();
	}

	public void setFilePathField(String txtFilePath) {
		this.txtFilePath.setText(txtFilePath);
	}

	public SpeedTransfer getSpeed() {
		return speed;
	}

}
