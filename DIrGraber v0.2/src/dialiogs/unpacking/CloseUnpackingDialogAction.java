package dialiogs.unpacking;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class CloseUnpackingDialogAction extends AbstractAction{
private JDialog dialogForCloesing;
	
	public CloseUnpackingDialogAction(JDialog dialog) {
		this.dialogForCloesing = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//STOP ACTION
		
		this.dialogForCloesing.dispose();
	}

}
