package dialiogs.packing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class ClosePackingDialogAction extends AbstractAction{

private JDialog dialogForCloesing;
	
	public ClosePackingDialogAction(JDialog dialog) {
		this.dialogForCloesing = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//STOP ACTION
		
		this.dialogForCloesing.dispose();
	}
	
}
