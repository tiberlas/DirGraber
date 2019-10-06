package panels.send;

import java.io.File;

import javax.swing.JOptionPane;

import application.Window;
import model.SendingFileModel;
import model.SpeedTransfer;

public class Validation {

	public SendingFileModel validate(String ip, String port, String filePath, SpeedTransfer speed) {
		try {
			int portNumber = Integer.parseInt(port);
			
			if(portNumber < 1024 || portNumber > 65535) {
				throw new Exception("PORT NUMBER MUST BE BETWEEB 1024 AND 65535");
			}
			
			if(isIpValid(ip) == false) {
				throw new Exception("IP IS NOT VALID");
			}
			
			File file = new File(filePath);
			if(file.exists() == false) {
				throw new Exception("THE SELECTED DESTINATION IS NOT VALID!\nPLEASE SELECT A VALID DESTINATION");
			}
			
			return new SendingFileModel(ip, portNumber, filePath, speed);
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(Window.getInstance(), "PLEASE ENTER A PORT NUMBER");
			return null;
		} catch(Exception e) {
			JOptionPane.showMessageDialog(Window.getInstance(), e.getMessage());
			return null;
		}
		
	}
	
	private boolean isIpValid(String ip) {
		ip.trim();
		
		if(ip.length() < 7 || ip.length() > 15) {
			return false;
		}
		
		String[] ipParts = ip.split("\\."); 
		
		if(ipParts.length != 4) {
			return false;
		}
		
		for(int i=0; i<4; ++i) {
			if(ipParts[i].length() > 3) {
				return false;
			}
			
			if(areNumbersOnly(ipParts[i].toCharArray()) == false) {
				return false;
			}
		}
		
		return true;
	}
	
	private boolean areNumbersOnly(char[] number) {
		
		for(int i=0; i<number.length; ++i) {
			if(number[i] < '0' || number[i] > '9') {
				return false;
			}
		}
		
		return true;
	}

}
