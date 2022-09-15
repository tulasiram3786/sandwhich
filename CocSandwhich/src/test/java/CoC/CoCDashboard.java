package CoC;

import java.util.ArrayList;

public class CoCDashboard {
	public String PrivateIP;
	public ArrayList<String> PrivateIPArr;
	public String PublicIP;
	public String Hostname;
	public String OS;
	public double Capacity_CPU;
	public String Capacity_RAM;
	public String Capacity_HDD;
	
	public String getPrivateIP() {
		return PrivateIP;
	}
	public void setPrivateIP(String privateIP) {
		PrivateIP = privateIP;
	}
	public ArrayList<String> getPrivateIPArr() {
		return PrivateIPArr;
	}
	public void setPrivateIPArr(ArrayList<String> privateIPArr) {
		PrivateIPArr = privateIPArr;
	}
	public String getPublicIP() {
		return PublicIP;
	}
	public void setPublicIP(String publicIP) {
		PublicIP = publicIP;
	}
	public String getHostname() {
		return Hostname;
	}
	public void setHostname(String hostname) {
		Hostname = hostname;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public double getCapacity_CPU() {
		return Capacity_CPU;
	}
	public void setCapacity_CPU(double cpu) {
		Capacity_CPU = cpu;
	}
	public String getCapacity_RAM() {
		return Capacity_RAM;
	}
	public void setCapacity_RAM(String capacity_RAM) {
		Capacity_RAM = capacity_RAM;
	}
	public String getCapacity_HDD() {
		return Capacity_HDD;
	}
	public void setCapacity_HDD(String capacity_HDD) {
		Capacity_HDD = capacity_HDD;
	}

	
	
	
}
