package app;

import dialiogs.changePreferences.ChangePreferences;
import model.Preferences;

public class App {

	private static Preferences preferences = null;
	
	public static void main(String[] args) {
		
		//load preferences

		Window window = Window.getInstance();
		
		if(preferences == null) {
			ChangePreferences setPreferencesDialog = new ChangePreferences();
			setPreferencesDialog.showDialog();
		} else {
			window.setVisible(true);
		}

	}
	
	public static void setPrefetences(Preferences p) {
		preferences = p;
	}
	
	public static Preferences getPreferences() {
		return preferences;
	}

}
