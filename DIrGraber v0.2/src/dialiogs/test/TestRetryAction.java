package dialiogs.test;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public class TestRetryAction extends AbstractAction{

	private TestSendingThread forRetry;
	private TestFaild failDialog;
	
	public TestRetryAction(TestSendingThread forRetry, TestFaild failDialog) {
		
		this.forRetry = forRetry;
		this.failDialog = failDialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		failDialog.dispose();
		forRetry.start();
	}

}
