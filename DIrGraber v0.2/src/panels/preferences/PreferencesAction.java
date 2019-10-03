package panels.preferences;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import dialiogs.changePreferences.ChangePreferences;

@SuppressWarnings("serial")
public class PreferencesAction extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ChangePreferences setPreferencesDialog = new ChangePreferences();
		setPreferencesDialog.showDialog();
	}

}
