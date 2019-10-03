package app;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MyToolBar extends JToolBar{

	private JButton preferences;
	private JButton about;
	private JButton help;
	
	public MyToolBar() {
		super(SwingConstants.HORIZONTAL);
		setFloatable(true);
		
		preferences = new JButton();
		about = new JButton();
		help = new JButton();

		preferences.setAction(new PreferencesAction());
		
		preferences.setToolTipText("preferences");
		about.setToolTipText("about");
		help.setToolTipText("help");
		
		preferences.setIcon(new ImageIcon("ressourses\\pictures\\preferences.gif"));
		about.setIcon(new ImageIcon("ressourses\\pictures\\about.gif"));
		help.setIcon(new ImageIcon("ressourses\\pictures\\help.gif"));
		
		add(preferences);
		add(about);
		add(help);
	}
}
