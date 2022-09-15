package CoC;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import CoC.CoCDashboard;

import Sandwitch.CoCDashboardData;

public class Comparision {

	@Test(priority = 1)
	public void compareData() throws IOException, InterruptedException {

		ArrayList<Excel> ExcelFinalArrNew = new ArrayList<Excel>();
		try {
			ExcelFinalArrNew = ExcelDashboardData.getVCenterExcelData();
		} catch (Exception e) {

		}

		ArrayList<CoCDashboard> cocArr = new ArrayList<CoCDashboard>();
		try {
			cocArr = CoCDashboardData.getCoCDashboardData();
		} catch (Exception e) {

		}

		for (int i = 1; i < ExcelFinalArrNew.size(); i++) {
			String IP = ExcelFinalArrNew.get(i).getIpaddress();
			for (int j = 0; j < cocArr.size(); j++) {

				if (IP != null && IP.contains(cocArr.get(j).getPrivateIP())) {

					System.out.println(ExcelFinalArrNew.get(i).getHostname());
					if (ExcelFinalArrNew.get(i).getHostname().contains(cocArr.get(j).getHostname())) {
						System.out.println("True");
					} else {
						System.out.println("False");
					}
					System.out.println(ExcelFinalArrNew.get(i).getOS());
					if (ExcelFinalArrNew.get(i).getOS().contains(cocArr.get(j).getOS())) {
						System.out.println("True");
					} else {
						System.out.println("False");
					}
					System.out.println(ExcelFinalArrNew.get(i).getIpaddress());
					if (ExcelFinalArrNew.get(i).getIpaddress().contains(cocArr.get(j).getPrivateIP())) {
						System.out.println("True");
					} else {
						System.out.println("False");
					}
					System.out.println(ExcelFinalArrNew.get(i).getCapacity_CPU());

					if (ExcelFinalArrNew.get(i).getCapacity_CPU() == cocArr.get(j).getCapacity_CPU()) {
						System.out.println("True");
					} else {
						System.out.println("False");
					}
					System.out.println(ExcelFinalArrNew.get(i).getCapacity_RAM());
					if (ExcelFinalArrNew.get(i).getCapacity_RAM().contains(cocArr.get(j).getCapacity_RAM())) {
						System.out.println("True");
					} else {
						System.out.println("False");
					}
					System.out.println(ExcelFinalArrNew.get(i).getCapacity_HDD());
					if (ExcelFinalArrNew.get(i).getCapacity_HDD().contains(cocArr.get(j).getCapacity_HDD())) {
						System.out.println("True");
					} else {
						System.out.println("False");
					}
					System.out.println("------------------------------");
					System.out.println(cocArr.get(j).getHostname());
					System.out.println(cocArr.get(j).getOS());
					System.out.println(cocArr.get(j).getPrivateIP());
					System.out.println(cocArr.get(j).getCapacity_CPU());
					System.out.println(cocArr.get(j).getCapacity_RAM());
					System.out.println(cocArr.get(j).getCapacity_HDD());
					System.out.println("*****************************************************************");

				}

			}

		}
//		for (int i = 0; i < ExcelFinalArrNew.size(); i++) {
//			for (int j = 0; j < cocArr.size(); j++) {
//				if (ExcelFinalArrNew.get(i).getIpaddress() != null
//						&& ExcelFinalArrNew.get(i).getIpaddress().contains(cocArr.get(j).getPrivateIP())) {
//					int len = cocArr.get(j).getPrivateIP().length();
//					System.out.println(len);
//
//				}
//
//			}
//
//		}

	}
}
