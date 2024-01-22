package com.design.pattern.prototype;

public class NetworkConnection implements Cloneable {

	private String ip;
	private String networkNmae;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNetworkNmae() {
		return networkNmae;
	}

	public void setNetworkNmae(String networkNmae) {
		this.networkNmae = networkNmae;
	}

	public String getLoadObject() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "THIS OBJECT CREATION IS TAKING MORE TIME";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "NetworkConnection [ip=" + ip + ", networkNmae=" + networkNmae + "]";
	}

}
