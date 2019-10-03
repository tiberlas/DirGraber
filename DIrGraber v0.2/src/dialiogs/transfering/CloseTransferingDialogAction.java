package dialiogs.transfering;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class CloseTransferingDialogAction extends AbstractAction{

	private JDialog dialogForCloesing;
	
	public CloseTransferingDialogAction(JDialog dialog) {
		this.dialogForCloesing = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//STOP ACTION
		
		this.dialogForCloesing.dispose();
	}

}
