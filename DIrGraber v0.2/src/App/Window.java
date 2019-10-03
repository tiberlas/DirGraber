package app;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import dialiogs.changePreferences.ChangePreferences;
import model.Preferences;
import observer.IObserver;
import panels.preferences.PreferencesPanel;
import panels.send.SendPanel;

@SuppressWarnings("serial")
public class Window extends JFrame{

	private static Window instance = null;
	private UserPreferences preferences = null;
	
	private JTabbedPane tabs;
	private MyToolBar bar;
	private PreferencesPanel pnlPreferences;
	private SendPanel pnlSend;
	
	public static Window getInstance() {
		if(instance == null) {
			instance = new Window();
		}
		
		return instance;
	}
	
	private Window() {
		super("DirGraber");
		Toolkit kit = Toolkit.getDefaultToolkit();
		setIconImage(kit.getImage("ressourses\\pictures\\dirgraber.ico"));
		setSize(600, 500);
		setLayout(new BorderLayout());
		
		preferences = new UserPreferences();
		
		addWindowListener(new AppWindowListener());
		
		bar = new MyToolBar();
		add(bar, BorderLayout.NORTH);
		
		pnlPreferences = new PreferencesPanel();
		addObserver(pnlPreferences);
		
		pnlSend = new SendPanel();
		
		tabs = new JTabbedPane();
		tabs.add("preferences", pnlPreferences);
		tabs.add("send", pnlSend);
		add(tabs, BorderLayout.CENTER);
	}
	
	public boolean isEmptyPreferences() {
		return preferences.isEmpty();
	}
	
	public Preferences getPreferences() {
		return preferences.getPreferences();
	}
	
	public void setPreferences(Preferences newPreferences) {
		preferences.setPreferences(newPreferences);
	}
	
	public void setPreferencesOnLoad() {
		if(preferences.isEmpty()) {
			ChangePreferences setPreferencesDialog = new ChangePreferences();
			
			addObserver(setPreferencesDialog);
		
			setPreferencesDialog.showDialog();
		} else {
			this.setVisible(true);
		}
	}
	
	public void update() {
		preferences.notifyObserver();
	}
	
	public void addObserver(IObserver newObserver) {
		preferences.add(newObserver);
	}
	
}
