package dialiogs.changePreferences;

import app.Window;
import model.Preferences;
import observer.IObserver;

public class ChangePreferences implements IObserver{
	
	private ChangePreferencesDialog dialog;
	
	public ChangePreferences() {
		dialog = new ChangePreferencesDialog();
		
		if(Window.getInstance().isEmptyPreferences() == false) {
			update();
		}
	}
	
	public void showDialog() {
		dialog.setVisible(true);
	}

	@Override
	public void update() {
		Preferences newPreferences = Window.getInstance().getPreferences();
		
		dialog.setNameFeald(newPreferences.getName());
		dialog.setPortFeald(String.valueOf(newPreferences.getPort()));
		dialog.setDestinationFeald(newPreferences.getDownloadDestination());
		
	}

}
