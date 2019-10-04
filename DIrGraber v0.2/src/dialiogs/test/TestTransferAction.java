package dialiogs.test;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SendingFileModel;
import panels.send.SendingFileThread;

@SuppressWarnings("serial")
public class TestTransferAction extends AbstractAction{
	
	private SendingFileModel forSending;
	private TestPassed passDialog;
	
	public TestTransferAction(SendingFileModel forSendingFile, TestPassed passDialog) {

		this.forSending = forSendingFile;
		this.passDialog = passDialog;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		passDialog.dispose();
		
		SendingFileThread sending = new SendingFileThread(forSending);
		sending.start();
	}

}
