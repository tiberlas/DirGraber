package dialiogs.changePreferences;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import app.App;
import model.Preferences;

@SuppressWarnings("serial")
public class SavePreferencesAction extends AbstractAction{

	private Preferences preferences;
	private ChangePreferencesDialog parentDialog;
	private String name;
	private String port;
	private String destination;
	
	public SavePreferencesAction(ChangePreferencesDialog parentDialog) {
		this.parentDialog = parentDialog;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.name = parentDialog.getNameFeald();
		this.port = parentDialog.getPortFeald();
		this.destination = parentDialog.getDestinationFeald();
		
		preferences = valifation();
		
		if(preferences != null) {
			App.setPrefetences(preferences);
			parentDialog.dispose();
		}
	}
	
	private Preferences valifation() {
		try {
			int portNumber = Integer.parseInt(port);
			
			if(portNumber < 1024 || portNumber > 65535) {
				throw new Exception("PORT NUMBER MUST BE BETWEEB 1024 AND 65535");
			}
			
			if(name == null || name == "" ) {
				throw new Exception("PLEASE ENTER A NAME");
			}
			
			if(name.length() > 31) {
				throw new Exception("NAME CAN'T BE LARGER THAN 31 SIMBOLS");
			}
			
			if(destination == null || destination == "" ) {
				throw new Exception("PLEASE SELECT A DESTINATION");
			}
			
			File defaultDestination = new File(destination);
			if(defaultDestination.isDirectory() == false || defaultDestination.exists() == false) {
				throw new Exception("THE SELECTED DESTINATION IS NOT VALID!\nPLEASE SELECT A VALID DESTINATION");
			}
			
			return new Preferences(name, portNumber, destination);
			
		} catch(NumberFormatException e) {
			
			JOptionPane.showMessageDialog(parentDialog, "PLEASE ENTER A PORT NUMBER");
			return null;

		}catch (Exception e) {			

			JOptionPane.showMessageDialog(parentDialog, e.getMessage());
			return null;
		}
		
	}

}
