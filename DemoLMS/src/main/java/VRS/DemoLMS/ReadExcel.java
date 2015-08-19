package VRS.DemoLMS;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.google.common.collect.Table.Cell;

public class ReadExcel {


	private static HSSFWorkbook excelBook;
	private static HSSFSheet excelSheet;
	private static HSSFCell cell;
	private static HSSFRow row;
	
	public static void setExcelFile(String strPath, String strSheetName) throws Exception {
		
		
		try {
			FileInputStream fin = new FileInputStream(strPath);
			
			excelBook = new HSSFWorkbook(fin);
			excelSheet = excelBook.getSheet(strSheetName);
			System.out.println("Book and Sheet : " + excelBook + excelSheet);
			
		}catch (Exception e) {
			throw(e);
		}
	}
	
	public static String getCellData(int rowNum, int colNum) throws Exception {
		
		System.out.println("getCellData() method..");
		try {
			
			cell = excelSheet.getRow(rowNum).getCell(colNum);
			String userName = cell.getStringCellValue();
			System.out.println("Cell value : " + userName);
			return userName;
		}
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void setCellData(String strFileName, String strResult, int rowNum, int colNum) throws Exception {
		
		try {
			
			row = excelSheet.getRow(rowNum);
			cell = row.getCell(colNum, row.RETURN_BLANK_AS_NULL);
			
			if (cell == null) {
				
				cell = row.createCell(colNum);
				cell.setCellValue(strResult);
				
			}
			else {
				cell.setCellValue(strResult);
			}
			
			FileOutputStream fout = new FileOutputStream(strFileName);
			excelBook.write(fout);
			fout.flush();
			fout.close();
			
		}
		catch (Exception e) {
			throw(e);
		}
	}
}
