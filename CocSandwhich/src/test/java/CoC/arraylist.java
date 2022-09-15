package CoC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class arraylist {

	

	public static void main(String[] args) throws IOException {
		
		
	

		String excelFilePath = "./src/test/resources/CommonData/ModifiedExcelSheet.xlsx";

		FileInputStream fis = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		

		ArrayList<Excel> ExcelFinalArrNew = new ArrayList<Excel>();

		for (int r = 0; r <= rows; r++) {

			Excel excelData = new Excel();
			try {

				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < cols; c++) {
					XSSFCell cell = row.getCell(c);

					if (c == 11) {

						excelData.setIpaddress(cell.getStringCellValue());
					}

					if (c == 2) {
						excelData.setCapacity_HDD(cell.getStringCellValue());
					}
					if (c == 6) {
						excelData.setOS(cell.getStringCellValue());
					}
					if (c == 7) {
						excelData.setCapacity_RAM(cell.getStringCellValue());
					}
					if (c == 13) {
						excelData.setHostname(cell.getStringCellValue());
					}

//					if(c == 8)
//					{
//						int cpu=Integer.parseInt(cell.getStringCellValue());
//						excelData.setCapacity_CPU(cpu);
//					}

				}

			} catch (Exception e) {
			}

			ExcelFinalArrNew.add(excelData);
			
	}
		
//	String fIP = "10.192.1.174";
//	int count = ExcelFinalArrNew.size();
//	for(int i=1; i < count; i++) {
//		System.out.println(ExcelFinalArrNew.get(i).getIpaddress());
//	}
//	
//	for(int i=1; i < count; i++) {
//		if(ExcelFinalArrNew.get(i).getIpaddress() != null && ExcelFinalArrNew.get(i).getIpaddress().contains(fIP)) {
//			System.out.println(ExcelFinalArrNew.get(i).getHostname());
//			System.out.println(ExcelFinalArrNew.get(i).getOS());
//			System.out.println(ExcelFinalArrNew.get(i).getIpaddress());
//			// System.out.println(cocFinalArrNew.get(i).getCapacity_CPU());
//			System.out.println(ExcelFinalArrNew.get(i).getCapacity_RAM());
//			System.out.println(ExcelFinalArrNew.get(i).getCapacity_HDD());
//			System.out.println("===========================================");
//		}
//	}
			
		
//		if(fIP.contains(ExcelFinalArrNew.get(95).Ipaddress.substring(0, 11))){
//			
//		
//		
//
//	
//			System.out.println(ExcelFinalArrNew.get(95).getHostname());
//			System.out.println(ExcelFinalArrNew.get(95).getOS());
//			System.out.println(ExcelFinalArrNew.get(95).getIpaddress());
//			// System.out.println(cocFinalArrNew.get(i).getCapacity_CPU());
//			System.out.println(ExcelFinalArrNew.get(95).getCapacity_RAM());
//			System.out.println(ExcelFinalArrNew.get(95).getCapacity_HDD());
//			System.out.println("===========================================");
//		}
		

//		int vi = ExcelFinalArrNew.size();
//
//		ArrayList<String> IPArr = new ArrayList<String>();
//		
//		ArrayList<String> all = new ArrayList<String>();
//		
//		for(int i=1;i<vi;i++)
//		{
//			try {
//			
//			String[] arrOfStr = ExcelFinalArrNew.get(i).Ipaddress.split(",");
//			for (int j = 0; j < arrOfStr.length; j++) {
//				
//		       if (isValidInet4Address(arrOfStr[j].trim())) {
//				
//					all.add(arrOfStr[j]);
//
//				}
//			}
//			
//			}catch(Exception e)
//			{
//				
//			}
//		}	
//		
//		System.out.println("vi "+all);
//			
//		int ram = all.size();
//			
//		
//		IPArr.add(0, "10.193.4.9");
//		IPArr.add(1, "10.180.16.76");
//		IPArr.add(2, "10.193.6.29");
//		IPArr.add(3, "10.193.7.134");
//	//	IPArr.add(4, "10.193.10.130");
//		IPArr.add(4, "10.193.7.131");
////		IPArr.add(6, "10.192.1.174");
////		IPArr.add(7, "10.192.1.182");
//
//	
//
//		//for (String string : IPArr) {
//		//	try {
//			for (int k = 1; k < ram; k++) {
//
//				
//					if (IPArr.get(0).equals(all.get(k))) {
//
//						System.out.println(ExcelFinalArrNew.get(k).getHostname());
//						System.out.println(ExcelFinalArrNew.get(k).getOS());
//						System.out.println(ExcelFinalArrNew.get(k).getIpaddress());
//						// System.out.println(cocFinalArrNew.get(i).getCapacity_CPU());
//						System.out.println(ExcelFinalArrNew.get(k).getCapacity_RAM());
//						System.out.println(ExcelFinalArrNew.get(k).getCapacity_HDD());
//						System.out.println("===========================================");
//
//					}
////					else
////					{
////						break;
////					}
//
//				} 
//			//}catch (Exception e) {
//			//}

		}

	}
		
//}
