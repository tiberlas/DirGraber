package panels.send;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import model.SendingFile;

@SuppressWarnings("serial")
public class TestAction extends AbstractAction{

	private SendPanel panel;
	
	public TestAction(SendPanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Validation validate = new Validation();
		
		SendingFile forSending = validate.validate(panel.getIpField(), panel.getPortField(), panel.getFilePathField());
		
	}

}
