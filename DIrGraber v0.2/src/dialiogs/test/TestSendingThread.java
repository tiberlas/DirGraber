package dialiogs.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import model.SendingFileModel;

public class TestSendingThread extends Thread{
	
	private SendingFileModel testConnection;
	
	public TestSendingThread(SendingFileModel testConnection) {

		this.testConnection = testConnection;
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
			} else {
				failDialog(this);
			}
			
			out.close();
			in.close();
			soc.close();
			
		} catch(Exception e) {
			failDialog(this);
		}
	
	}
	
	private void failDialog(TestSendingThread forRetry) {
		TestFaild faildDialog = new TestFaild(this);
		faildDialog.setVisible(true);
	}

}
