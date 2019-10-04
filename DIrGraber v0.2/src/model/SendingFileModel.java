package model;

public class SendingFileModel {

	private String ip;
	private int port;
	private String FilePath;
	
	
	
	public SendingFileModel() {
		super();
		
	}

	public SendingFileModel(String ip, int port, String filePath) {
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
