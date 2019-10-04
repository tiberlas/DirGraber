package panels.send;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SendingFileModel;

@SuppressWarnings("serial")
public class SendAction extends AbstractAction{

	private SendPanel panel;
	
	public SendAction(SendPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Validation validate = new Validation();
		
		SendingFileModel forSending = validate.validate(panel.getIpField(), panel.getPortField(), panel.getFilePathField());
		
		if(forSending != null) {
			SendingFileThread sendingFile = new SendingFileThread(forSending);
			sendingFile.start();
		}
	}

}
