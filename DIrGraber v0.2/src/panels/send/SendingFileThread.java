package panels.send;

import java.io.DataInputStream;
import java.io.File;
import java.io.ObjectOutputStream;
import java.net.Socket;

import application.Window;
import dialiogs.error.Error;
import dialiogs.packing.PackingProces;
import model.IntroduceFileModel;
import model.SendingFileModel;

public class SendingFileThread extends Thread{
	
	private SendingFileModel file;
	private IntroduceFileModel fileHeader;
	
	public SendingFileThread(SendingFileModel file) {

		this.file = file;
		
		File f = new File(file.getFilePath());
		long size = f.length();
		String name = Window.getInstance().getPreferences().getName();
		
		fileHeader = new IntroduceFileModel(name, size);
	}
	
	@Override
	public void run() {
		
		try {
			Socket soc = new Socket(file.getIp(), file.getPort());
			
			ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
			DataInputStream in = new DataInputStream(soc.getInputStream());
			
			out.writeObject(fileHeader);
			out.flush();
			
			if(in.readBoolean() == true) {
				
				PackingProces packing = new PackingProces(file);
				packing.startPacking();
			} else {
				
				Error errorDialog = new Error("THE RECIVER IS NOT ACCEPTING YOUR FILE");
				errorDialog.setVisible(true);
			}
			
			in.close();
		    out.close();
		    soc.close();
		} catch(Exception e) {
			
			Error errorDialog = new Error("AN ERROR HAS OCCURED!\nPLEASE CHECK YOUR CONNECTION AND PARAMETERS FOR SENDING");
			errorDialog.setVisible(true);
		}
	}
	

}
