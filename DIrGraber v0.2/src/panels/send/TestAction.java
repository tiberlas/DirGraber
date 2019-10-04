package panels.send;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import dialiogs.test.TestSendingThread;
import model.SendingFileModel;

@SuppressWarnings("serial")
public class TestAction extends AbstractAction{

	private SendPanel panel;
	
	public TestAction(SendPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Validation validate = new Validation();
		
		SendingFileModel forSending = validate.validate(panel.getIpField(), panel.getPortField(), panel.getFilePathField());
		
		if(forSending != null) {
			panel
			
			TestSendingThread testingConnection = new TestSendingThread(forSending);
			testingConnection.start();
		}
	}

}
