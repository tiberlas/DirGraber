package app;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Window extends JFrame{

	private static Window instance = null;
	
	private JTabbedPane tabs;
	private MyToolBar bar;
	private PreferencesPanel pnlPreferences = new PreferencesPanel();
	private SendPanel pnlSend = new SendPanel();
	
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
		
		addWindowListener(new AppWindowListener());
		
		bar = new MyToolBar();
		add(bar, BorderLayout.NORTH);
		
		tabs = new JTabbedPane();
		tabs.add("preferences", pnlPreferences);
		tabs.add("send", pnlSend);
		add(tabs, BorderLayout.CENTER);
	}
	
}
