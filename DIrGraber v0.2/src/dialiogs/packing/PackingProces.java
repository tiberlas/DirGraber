package dialiogs.packing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import dialiogs.error.Error;
import dialiogs.transfering.TransferingProces;
import model.SendingFileModel;

public class PackingProces {
	
	private SendingFileModel toSend;
	private Packing packingDialog;
	private int BUFFER = 1024;
	
	public PackingProces(SendingFileModel toSend) {
		
		this.toSend = toSend;
		packingDialog = new Packing();
		
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
	
	public void startPacking() {
		
		packingDialog.setVisible(true);
		
		try {
			File file = new File(toSend.getFilePath());
			
			FileOutputStream outputZip = new FileOutputStream("ressourses\\transfer.zip");
			ZipOutputStream zipOut = new ZipOutputStream(outputZip);
			
			zipping(file, file.getName(), zipOut);
			
			outputZip.close();
			zipOut.close();
		
		} catch(FileNotFoundException e) {
			errorMessage("COULD NOT FIND FILE TO ZIP!\nPLEASE CHECK THE FILE YOU WANT TO SEND");
			
		} catch(IOException e) {
			errorMessage("FILE IS TO LARGE OR TO COMPLEX TO BE SEND!\nPLEASE SEND FRAGMENTS OF THE FILE INSTED");
			
		} catch(Exception e) {
			errorMessage("AN UNEXPECTED ERROR HAS OCCURRED!\nSEE HELP");
			
		}
		
		packingDialog.dispose();
		TransferingProces transfering = new TransferingProces(toSend);
		transfering.startTransfer();
        
	}
	
	private void zipping(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        
		if (fileToZip.isHidden()) {
            return;
        }
		
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            for (File childFile : children) {
                zipping(childFile, fileName + "/" + childFile.getName(), zipOut);
            }
            return;
        }
        
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);
        
        long size = fileToZip.length();
        long total=0;
        byte[] bytes = new byte[BUFFER];
        int length;
        
        while ((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
            total+=length;
            packingDialog.setProgres((int)((total*100)/(size)));
        }
        
        fis.close();
    }
	
	private void errorMessage(String message) {
		packingDialog.dispose();
		
		Error errorDialog = new Error(message);
		errorDialog.setVisible(true);
		
	}

}
