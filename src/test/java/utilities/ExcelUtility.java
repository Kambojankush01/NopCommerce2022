package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static void getCellValueByRow() throws IOException {
		String excelfile = "./src/main/java/config/TestData.xlsx";
		FileInputStream stream = new FileInputStream(new File(excelfile));
		String str = null;

		XSSFWorkbook wb = new XSSFWorkbook(stream); // latest excel
		// HSSFWorkbook --> for older excel
		XSSFSheet sh = wb.getSheet("UserData");
//		XSSFRow row = sh.getRow(i);
		int rowNum = sh.getLastRowNum();

		for (int ii = 0; ii <= rowNum; ii++) {
			XSSFRow row = sh.getRow(ii);
			int colNum = row.getLastCellNum();
			for (int k = 0; k < colNum; k++) {
				XSSFCell cell = row.getCell(k);
				// str = cell.getStringCellValue().toString();
				switch (cell.getCellType()) {
				case NUMERIC:
					double dd = cell.getNumericCellValue();
					str = String.valueOf(dd);
					break;
				case STRING:
					str = cell.getStringCellValue();
					break;
				case BOOLEAN:
					boolean b = cell.getBooleanCellValue();
					str = String.valueOf(b);
					break;
				case FORMULA:
					str = cell.getCellFormula();
				default:
					break;

				}
				System.out.println(str);
			}

		}
		// String str = row.getCell(i).getStringCellValue();

		// return str;

	}

	// ***************************************************************************
	public static void getCellValueByRowCol(int r, int c) throws IOException {
		String excelfile = "./src/main/java/config/TestData.xlsx";
		FileInputStream stream = new FileInputStream(new File(excelfile));
		String str = null;

		XSSFWorkbook wb = new XSSFWorkbook(stream); // latest excel
		// HSSFWorkbook --> for older excel
		XSSFSheet sh = wb.getSheet("UserData");
//		XSSFRow row = sh.getRow(i);
		XSSFRow row = sh.getRow(r);
		XSSFCell cell = row.getCell(c);
		switch (cell.getCellType()) {
		case NUMERIC:
			double dd = cell.getNumericCellValue();
			str = String.valueOf(dd);
			break;
		case STRING:
			str = cell.getStringCellValue();
			break;
		case BOOLEAN:
			boolean b = cell.getBooleanCellValue();
			str = String.valueOf(b);
			break;
		case FORMULA:
			str = cell.getCellFormula();
		default:
			break;
		}


		
		System.out.println(str);
	}

	// ***************************************************************
	public static void getCellValueByRowName(String s) throws IOException {
		String excelfile = "./src/main/java/config/TestData.xlsx";
		FileInputStream stream = new FileInputStream(new File(excelfile));
		String str = null;

		XSSFWorkbook wb = new XSSFWorkbook(stream); // latest excel
		// HSSFWorkbook --> for older excel
		XSSFSheet sh = wb.getSheet("UserData");
//		XSSFRow row = sh.getRow(i);
		int rowNum = sh.getLastRowNum();

		for (int ii = 0; ii <= rowNum; ii++) {
			XSSFRow row = sh.getRow(ii);
			String cellValue = row.getCell(0).getStringCellValue();
			if (cellValue.equals(s)) {
				// int colNum= row.getCell(0).getColumnIndex();
				XSSFCell st = row.getCell(1);
				switch (st.getCellType()) {
				case NUMERIC:
					double dd = st.getNumericCellValue();
					str = String.valueOf(dd);
					break;
				case STRING:
					str = st.getStringCellValue();
					break;
				case BOOLEAN:
					boolean b = st.getBooleanCellValue();
					str = String.valueOf(b);
					break;
				case FORMULA:
					str = st.getCellFormula();
				default:
					break;
				}

				System.out.println(str);
				break;
			}

		} 
		// String str = row.getCell(i).getStringCellValue();

		// return str;

	}


}
