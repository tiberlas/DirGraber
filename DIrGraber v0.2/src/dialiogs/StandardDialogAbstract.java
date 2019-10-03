package dialiogs;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;


@SuppressWarnings("serial")
public abstract class StandardDialogAbstract extends JDialog{
	
	public StandardDialogAbstract(String title) {
		super();
		setTitle(title);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setIconImage(kit.getImage("ressourses\\pictures\\dirgraber.ico"));
		setSize(500, 400);
		setLayout(new GridBagLayout());
		this.getContentPane().setBackground(Color.WHITE);
	}

}
