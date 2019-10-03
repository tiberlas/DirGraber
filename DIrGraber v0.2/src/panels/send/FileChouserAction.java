package panels.send;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FileChouserAction extends AbstractAction{
	
	private JTextField lblPath;
	private JPanel panel;
	
	public FileChouserAction(JTextField txtDestination, JPanel dialog) {
		this.lblPath = txtDestination;
		this.panel = dialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
		fc.setAcceptAllFileFilterUsed(true);
		if (fc.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
			lblPath.setText( (fc.getSelectedFile().getAbsolutePath()));
		}
		
	}

}
