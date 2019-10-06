package dialiogs.transfering;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import model.SendingFileModel;

public class TransferingProces {

	private Transfering transferDialog;
	private SendingFileModel toSend;
	private int BUFFER = 1024;
	
	public TransferingProces(SendingFileModel toSend) {
		this.toSend = toSend;
		
		switch(toSend.getSpeed()) {
		case SLOW: 
			BUFFER = BUFFER * 8;
			break;
			
		case MEDIU: 
			BUFFER = BUFFER * 16;
			break;
		
		case FAST: 
			BUFFER = BUFFER * 32;
			break;
			
		case HYPER: 
			BUFFER = BUFFER * 64;
			break;
		}
	}
	
	public void startTransfer() {
		transferDialog = new Transfering();
		transferDialog.setVisible(true);
		
		try {
			Socket soc = new Socket(toSend.getIp(), toSend.getPort());
			
			File compressed = new File("ressourses\\transfer.zip");
			FileInputStream compressedFileStream = new FileInputStream(compressed);
			DataOutputStream output = new DataOutputStream(soc.getOutputStream());
			
			byte[] buff = new byte[BUFFER];
			int readed;
			long total=0;

			while ((readed = compressedFileStream.read(buff)) != -1) {
				output.write(buff, 0, readed);
				total+=(long) readed;
				//MyWindow.getInstance().setStatus("\nSent: " + (int)((total*100)/(compresd.length())) + "% total"+total+"length"+compresd.length());
				//.setProgres((int)((total*100)/(compresd.length())));
			}
			output.flush(); 
			
			compressedFileStream.close();
			output.close();
			soc.close();
		} catch(FileNotFoundException e) {
			
		} catch(UnknownHostException e) {
			
		} catch(IOException e) {
			
		} catch(Exception e) {
			
		}
	}
}
