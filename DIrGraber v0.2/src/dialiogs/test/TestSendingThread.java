package dialiogs.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import model.SendingFileModel;
import panels.send.SendPanel;

public class TestSendingThread extends Thread{
	
	private SendingFileModel testConnection;
	private SendPanel panel;
	
	public TestSendingThread(SendingFileModel testConnection, SendPanel panel) {

		this.testConnection = testConnection;
		this.panel = panel;
	}
	
	@Override
	public void run() {
		
		try {
			
			Socket soc = new Socket(testConnection.getIp(), testConnection.getPort());
			
			DataOutputStream out = new DataOutputStream(soc.getOutputStream());
			DataInputStream in = new DataInputStream(soc.getInputStream());
			
			out.writeChars("Are you available?");
			out.flush();
			
			if(in.readBoolean() == true) {
				TestPassed passDialog = new TestPassed(testConnection);
				passDialog.setVisible(true);
				panel.TestEnd();
			} else {
				failDialog();
			}
			
			out.close();
			in.close();
			soc.close();
			
		} catch(Exception e) {
			failDialog();
		}
	
	}
	
	private void failDialog() {
		TestFaild faildDialog = new TestFaild(testConnection, panel);
		faildDialog.setVisible(true);
		panel.TestEnd();
	}

}
