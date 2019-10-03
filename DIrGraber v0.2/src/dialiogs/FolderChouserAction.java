package dialiogs;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FolderChouserAction extends AbstractAction{

	private JTextField lblPath;
	private JDialog dialog;
	
	public FolderChouserAction(JTextField txtDestination, JDialog dialog) {
		this.lblPath = txtDestination;
		this.dialog = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //samo folder moze da se selektuje
		fc.setAcceptAllFileFilterUsed(false); //samo se folderi vide
		if (fc.showOpenDialog(dialog) == JFileChooser.APPROVE_OPTION) {
			lblPath.setText( (fc.getSelectedFile().getAbsolutePath()));
		}
		
	}

}
