package app.testing;

import app.Window;
import dialiogs.changePreferences.ChangePreferences;
import dialiogs.confirm.Confirm;
import dialiogs.error.Error;
import dialiogs.packing.Packing;
import dialiogs.success.Success;
import dialiogs.test.TestFaild;
import dialiogs.test.TestPassed;
import dialiogs.transfering.Transfering;
import dialiogs.unpacking.Unpacking;
import dialiogs.worning.Waiting;
import model.Preferences;

public class TEST {

	private static Preferences preferences = null;
	
	public static void main(String[] args) {
		
		//load preferences

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
//		Transfer t = new Transfer();
//		t.setVisible(true);
//		
//		Error e = new Error("UNKNOW ERROR!");
//		e.setVisible(true);
//		
//		Success s = new Success();
//		s.setVisible(true);
//		
//		TestPassed tp = new TestPassed();
//		tp.setVisible(true);
//		
//		TestFaild tf = new TestFaild();
//		tf.setVisible(true);
	}
	
	public static void setPrefetences(Preferences p) {
		preferences = p;
	}
	
	public static Preferences getPreferences() {
		return preferences;
	}

}

