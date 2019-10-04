package panels.send;

import model.SendingFileModel;

public class SendingFileThread extends Thread{
	
	private SendingFileModel file;
	
	public SendingFileThread(SendingFileModel file) {

		this.file = file;
	}
	
	@Override
	public void run() {
		System.out.println("SENDING");
	}

}
