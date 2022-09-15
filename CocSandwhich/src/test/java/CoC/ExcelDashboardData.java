package CoC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDashboardData {

	public static ArrayList<Excel> getVCenterExcelData() throws IOException {
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

					if (c == 8) {

						double data = excelData.setCapacity_CPU(cell.getNumericCellValue());
						int value = (int) data;
					}

				}

			} catch (Exception e) {

			}

			ExcelFinalArrNew.add(excelData);

		}
		return ExcelFinalArrNew;
	}

	@Test
	public void excel() throws IOException {

		ArrayList<Excel> ExcelFinalArrNew = new ArrayList<Excel>();

		try {
			ExcelFinalArrNew = getVCenterExcelData();
		} catch (Exception e) {

		}

		for (int i = 0; i < ExcelFinalArrNew.size(); i++) {
			System.out.println(ExcelFinalArrNew.get(i).getHostname());
			System.out.println(ExcelFinalArrNew.get(i).getOS());
			System.out.println(ExcelFinalArrNew.get(i).getIpaddress());
			System.out.println(ExcelFinalArrNew.get(i).getCapacity_CPU());
			System.out.println(ExcelFinalArrNew.get(i).getCapacity_RAM());
			System.out.println(ExcelFinalArrNew.get(i).getCapacity_HDD());
			System.out.println("===========================================");
		}
	}
}
