package app;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class AppWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JFrame frame = (JFrame) e.getComponent();
		int code = JOptionPane.showConfirmDialog(frame, 
												"DO YOU WANT TO CLOSE DIRECTORIUM GRABER?",
												"QUESTION",
												JOptionPane.YES_NO_OPTION);
		if(code == JOptionPane.YES_OPTION)
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		else
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
