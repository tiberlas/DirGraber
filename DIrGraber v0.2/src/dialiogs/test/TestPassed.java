package dialiogs.test;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialiogs.CloseDialogAction;
import dialiogs.StandardDialogAbstract;
import model.SendingFileModel;

@SuppressWarnings("serial")
public class TestPassed extends StandardDialogAbstract{
	
	private JButton btnClose;
	private JButton btnTransfer;
	
	public TestPassed(SendingFileModel forSending) {
		super("test passed");
		
		JLabel lblTitle = new JLabel("<html>TEST HAS PASSED!<br/>CLICK <u>CLOSE</u> TO CLOSE THE WINDOW OR <u>TRANSFERE</u> TO SEND THE FILE.</html>");

		btnClose = new JButton("CLOSE");
		btnClose.setAction(new CloseDialogAction(this));
		btnClose.setText("CLOSE");
		btnClose.setToolTipText("CLOSE THIS WINDOW");
		
		btnTransfer = new JButton("TRANSFERE");
		btnTransfer.addActionListener(new TestTransferAction(forSending, this));
		btnTransfer.setToolTipText("BEGIN SENDING THE FILE");
		
		JPanel btn = new JPanel();
		btn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn.add(btnTransfer);
		btn.add(btnClose);
		
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 200, 10));
		add(btn, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 30, 10));
	}

}
