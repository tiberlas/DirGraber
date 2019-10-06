package application.testing;

import application.Window;
import model.PreferencesModel;

public class TEST {

	private static PreferencesModel preferences = null;
	
	public static void main(String[] args) {
		
		//load preferences
		Window.getInstance().setPreferences(new PreferencesModel("tibi", 9000, "127.0.0.1", "C:", false));
		Window window = Window.getInstance();
		window.setVisible(true);
		
		
//		Confirm c = new Confirm("LINUX", "90063564");
//		c.setVisible(true);
//		
//		Packing p = new Packing();
//		p.setVisible(true);
//		
//		Unpacking u = new Unpacking();
//		u.setVisible(true);
//		
//		Waiting w = new Waiting();
//		w.setVisible(true);
//	
//		Transfering t = new Transfering();
//		t.setVisible(true);
//		
//		dialiogs.error.Error error = new dialiogs.error.Error("UNKNOW ERROR!");
//		error.setVisible(true);
//		
//		Success s = new Success();
//		s.setVisible(true);
		
//		TestPassed tp = new TestPassed();
//		tp.setVisible(true);
//		
//		TestFaild tf = new TestFaild();
//		tf.setVisible(true);
	}
	
	public static void setPrefetences(PreferencesModel p) {
		preferences = p;
	}
	
	public static PreferencesModel getPreferences() {
		return preferences;
	}

}

