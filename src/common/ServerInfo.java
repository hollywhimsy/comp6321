package common;

public class ServerInfo {

	private String location;
	private Integer udpPort;
	private String host;

	public ServerInfo(String location, String host, Integer udpPort) {
		this.location = location;
		this.host = host;
		this.udpPort = udpPort;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getUdpPort() {
		return udpPort;
	}

	public void setUdpPort(Integer udpPort) {
		this.udpPort = udpPort;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerInfo other = (ServerInfo) obj;
		if ((other.getHost() != this.getHost()) || (other.getLocation() != this.getLocation())
				|| (other.getUdpPort() != this.getUdpPort()))
			return false;

		return true;
	}
	
	@Override
	public String toString() {
		return "  Location: " + location + "  host: " + host + "  port: " + udpPort.toString();
	}

}
