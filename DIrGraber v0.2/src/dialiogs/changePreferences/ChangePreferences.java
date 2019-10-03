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
		
		dialog.setNameField(newPreferences.getName());
		dialog.setPortField(String.valueOf(newPreferences.getPort()));
		dialog.setDestinationField(newPreferences.getDownloadDestination());
		
	}

}
