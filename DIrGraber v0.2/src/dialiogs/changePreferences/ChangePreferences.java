package dialiogs.changePreferences;

import java.util.ArrayList;

import observer.IObservable;
import observer.IObserver;

public class ChangePreferences implements IObservable{
	
	private ArrayList<IObserver> observersList;
	private ChangePreferencesDialog dialog;
	
	public ChangePreferences() {
		dialog = new ChangePreferencesDialog();
		
		observersList = new ArrayList<IObserver>();
		
	}
	
	public void showDialog() {
		dialog.setVisible(true);
	}

	@Override
	public void add(IObserver observer) {
		observersList.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		observersList.remove(observer);		
	}

	@Override
	public void notifyObserver() {
		
		for(IObserver observer : observersList) {
			observer.update();
		}
	}

}
