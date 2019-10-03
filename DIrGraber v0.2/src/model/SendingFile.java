package model;

public class SendingFile {

	private String ip;
	private int port;
	private String FilePath;
	
	
	
	public SendingFile() {
		super();
		
	}

	public SendingFile(String ip, int port, String filePath) {
		super();
		this.ip = ip;
		this.port = port;
		FilePath = filePath;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getFilePath() {
		return FilePath;
	}

	public void setFilePath(String filePath) {
		FilePath = filePath;
	}
	
	
	
}
