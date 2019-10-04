package dialiogs.test;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dialiogs.CloseDialogAction;
import dialiogs.StandardDialogAbstract;

@SuppressWarnings("serial")
public class TestFaild extends StandardDialogAbstract {
	
	private JButton btnClose;
	private JButton btnTryAgain;
	
	public TestFaild(TestSendingThread forRetry) {
		super("test faild");
		
		JLabel lblTitle = new JLabel("<html>TEST HAS FAILD!<br/>CHECK THE <u>IP</u> AND <u>PORT</u> OF THE RECIVER.</html>");

		btnClose = new JButton();
		btnClose.setAction(new CloseDialogAction(this));
		btnClose.setText("CLOSE");
		btnClose.setToolTipText("CLOSE THIS WINDOW");
		
		btnTryAgain = new JButton("TRY AGAIN");
		btnTryAgain.addActionListener(new TestRetryAction(forRetry, this));
		btnTryAgain.setToolTipText("TRY THE TEST AGAIN");
		
		
		JPanel btn = new JPanel();
		btn.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btn.add(btnTryAgain);
		btn.add(btnClose);
		
		add(lblTitle, new GridBagConstraints(1, 0, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 200, 10));
		add(btn, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(20, 20, 0, 20), 30, 10));
	}

}
