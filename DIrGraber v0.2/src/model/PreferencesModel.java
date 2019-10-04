package model;

public class PreferencesModel {

	private String name;
	private int port;
	private String ip;
	private String downloadDestination;
	private boolean isServerRunning;
	
	
	public PreferencesModel() {
		super();
	}
	
	public PreferencesModel(String name, int port, String ip, String destination, boolean serverRunning) {
		super();
		this.name = name;
		this.port = port;
		this.ip = ip;
		this.downloadDestination = destination;
		this.isServerRunning = serverRunning;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDownloadDestination() {
		return downloadDestination;
	}
	public void setDownloadDestination(String downloadDestination) {
		this.downloadDestination = downloadDestination;
	}

	public boolean isServerRunning() {
		return isServerRunning;
	}

	public void setServerRunning(boolean isServerRunning) {
		this.isServerRunning = isServerRunning;
	}
	
	
}
