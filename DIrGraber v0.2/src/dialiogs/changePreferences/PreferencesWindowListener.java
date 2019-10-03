package dialiogs.changePreferences;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.WindowConstants;

import app.Window;

public class PreferencesWindowListener implements WindowListener{

	@Override
	public void windowActivated(WindowEvent e) {
		JDialog frame = (JDialog) e.getComponent();
		
		frame.setAlwaysOnTop(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		Window window = Window.getInstance();
		
		if(window.isVisible() == false) {
			window.setVisible(true);
		}
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		JDialog frame = (JDialog) e.getComponent();
		
		if(Window.getInstance().isEmptyPreferences() == false)
			frame.dispose();
		else
			frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
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
