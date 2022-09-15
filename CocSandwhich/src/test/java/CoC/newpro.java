package CoC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class newpro {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis =new FileInputStream("./src/test/resources/CommonData/ModifiedExcelSheet.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		DataFormatter format=new DataFormatter();
		String data = format.formatCellValue(sh.getRow(1).getCell(0));
			
		int rows = sh.getLastRowNum();
		int cols = sh.getRow(1).getLastCellNum();

		ArrayList<Excel> ExcelFinalArrNew = new ArrayList<Excel>();

		for (int r = 0; r <= rows; r++) {

			Excel excelData = new Excel();
			try {
//
           			 Row row = sh.getRow(r);
				for (int c = 0; c < cols; c++) {
		Cell cell = row.getCell(c);
					

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

					if(c == 8)
					{
						excelData.setCapacity_CPU(cell.getNumericCellValue());
					}

				}

			} catch (Exception e) {

			}

			ExcelFinalArrNew.add(excelData);

			for(int i=0;i<ExcelFinalArrNew.size();i++) {
				System.out.println(ExcelFinalArrNew.get(i).getHostname());
				System.out.println(ExcelFinalArrNew.get(i).getOS());
				System.out.println(ExcelFinalArrNew.get(i).getIpaddress());
				System.out.println(ExcelFinalArrNew.get(i).getCapacity_CPU());
				System.out.println(ExcelFinalArrNew.get(i).getCapacity_RAM());
				System.out.println(ExcelFinalArrNew.get(i).getCapacity_HDD());
				System.out.println("===========================================");
			}
		}
		//return ExcelFinalArrNew;
	}

//	@Test
//	public void excel() throws IOException {
//
//		ArrayList<Excel> ExcelFinalArrNew = new ArrayList<Excel>();
//		
//		try {
//			ExcelFinalArrNew = getVCenterExcelData();
//		}catch(Exception e) {
//			
//		}
//		
//		for(int i=0;i<ExcelFinalArrNew.size();i++) {
//			System.out.println(ExcelFinalArrNew.get(i).getHostname());
//			System.out.println(ExcelFinalArrNew.get(i).getOS());
//			System.out.println(ExcelFinalArrNew.get(i).getIpaddress());
//			// System.out.println(cocFinalArrNew.get(i).getCapacity_CPU());
//			System.out.println(ExcelFinalArrNew.get(i).getCapacity_RAM());
//			System.out.println(ExcelFinalArrNew.get(i).getCapacity_HDD());
//			System.out.println("===========================================");
//		}
//	}

}
