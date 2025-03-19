package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	static FileInputStream f; // is used to open the Excel file.
	static XSSFWorkbook wb; // represents the workbook within the file.
	static XSSFSheet sh;//represents a specific sheet in the workbook.
	
	public static String getStringData(int a, int b) throws IOException  {
		//a for Row, b for cell
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx");//right click on the excel file then click on properties,the copy the location -//src//........
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet("sheet1"); // get values in to sheet-sheet1-sheet name
		XSSFRow r = sh.getRow(a); // get details from row
		XSSFCell c = r.getCell(b); // get details from cell
		return c.getStringCellValue();

	}
	public static String getIntegerData(int a, int b) throws IOException {
		f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Excel.xlsx");
		wb = new XSSFWorkbook(f);
		sh = wb.getSheet("sheet1"); // get values in to sheet
		XSSFRow r = sh.getRow(a); // get details from row
		XSSFCell c = r.getCell(b); // get details from cell
		//type casting
		int cellValue = (int) c.getNumericCellValue(); // convert integer value in to string value
		return String.valueOf(cellValue);
}
}


