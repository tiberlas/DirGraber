package application;

import java.util.ArrayList;

import model.Preferences;
import observer.IObservable;
import observer.IObserver;

public class UserPreferences implements IObservable {

	private Preferences preferences;
	private ArrayList<IObserver> observerList;
	
	public UserPreferences() {
		//load 
		
		preferences = null;
		
		observerList = new ArrayList<IObserver>();
	}
	
	public boolean isEmpty() {
		return preferences == null;
	}
	
	public void setPreferences(Preferences newPreferences) {
		preferences = newPreferences;
	}
	
	public Preferences getPreferences() {
		return preferences;
	}
	
	@Override
	public void add(IObserver observer) {
		observerList.add(observer);
	}

	@Override
	public void remove(IObserver observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObserver() {
		
		for(IObserver observer : observerList) {
			observer.update();
		}
	}

}
