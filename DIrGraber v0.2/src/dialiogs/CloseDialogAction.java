package dialiogs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;

@SuppressWarnings("serial")
public class CloseDialogAction extends AbstractAction{

	private JDialog dialogForCloesing;
	
	public CloseDialogAction(JDialog dialog) {
		this.dialogForCloesing = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dialogForCloesing.dispose();
	}
	

}
