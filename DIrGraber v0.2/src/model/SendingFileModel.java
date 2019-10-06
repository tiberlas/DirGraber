package model;

public class SendingFileModel {

	private String ip;
	private int port;
	private String filePath;
	private SpeedTransfer speed;
	
	
	public SendingFileModel() {
		super();
		
	}

	public SendingFileModel(String ip, int port, String filePath, SpeedTransfer speed) {
		super();
		this.ip = ip;
		this.port = port;
		this.filePath = filePath;
		this.speed = speed;
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
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public SpeedTransfer getSpeed() {
		return speed;
	}

	public void setSpeed(SpeedTransfer speed) {
		this.speed = speed;
	}
	
}
