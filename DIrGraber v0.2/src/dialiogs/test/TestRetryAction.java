package dialiogs.test;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SendingFileModel;

@SuppressWarnings("serial")
public class TestRetryAction extends AbstractAction{

	private SendingFileModel forRetry;
	private TestFaild failDialog;
	private TestSendingThread sending;
	
	public TestRetryAction(SendingFileModel forRetry, TestFaild failDialog) {
		
		this.forRetry = forRetry;
		this.failDialog = failDialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		failDialog.dispose();
		failDialog.getPanel().onTestClick();
		
		sending = new TestSendingThread(forRetry, failDialog.getPanel());
		sending.start();
	}

}
