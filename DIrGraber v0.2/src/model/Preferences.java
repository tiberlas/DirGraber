package model;

public class Preferences {

	private String name;
	private int port;
	private String ip;
	
	
	public Preferences() {
		super();
	}
	
	public Preferences(String name, int port, String ip) {
		super();
		this.name = name;
		this.port = port;
		this.ip = ip;
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
	
}
