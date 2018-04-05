package com.pinke.testdata;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtils {
	public static void main(String[] args) {
		Object[][] o = getExcelData("calcTestData02.xlsx");
		for(int i = 0; i < o.length; i++) {
			for(int j=0; j < o[i].length; j++) {
				System.out.println(o[i][j]+"\t");
			}
		}
	}
	public static Object[][] getExcelData(String filename){
		System.out.println("filename is:" + filename);
		Object[][] objs = null;
		InputStream is = ReadExcelUtils.class.getClassLoader().getResourceAsStream(filename);
		Workbook wb = null;
		try {
			wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheet("Sheet1");
			int lastRowNum = sheet.getLastRowNum(); //从0开始；
			Row titleRow = sheet.getRow(0);
			int lastCellNum = titleRow.getLastCellNum(); // cell的编号+1，是個bug
			objs = new Object[lastRowNum][lastCellNum];
			for(int i=0; i<objs.length;i++) {
				Row row = sheet.getRow(i+1);
				for (int j=0;j<objs[i].length;j++){
					//Cell cell = row.getCell(j); //只用一次，所以不必要再单独定义一个cell
					objs[i][j] = getObject(row.getCell(j)); //调用封装的private方法					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(wb!=null) {
				wb.close();}
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		return objs;
	}
	private static Object getObject(Cell cell) {
		Object data = null;
		switch(cell.getCellTypeEnum()) {
			case BOOLEAN:
				data = cell.getBooleanCellValue();
				break;
			case NUMERIC:
				if(DateUtil.isCellDateFormatted(cell)) {
					data = cell.getDateCellValue();
				}else {
					data = DataParse.double2int(cell.getNumericCellValue());
				}
				break;
			case STRING:
				data = cell.getStringCellValue();
				break;
			default:
				data = null;		
		}
		return data;
	}
	
	/*private static Object double2int(double from) {
		if(from - (int)from ==0) {
			return (int)from;
		}else {
			return from;
		}
	}*/ //因为经常被用到，所以单独封装成一个public类，然后被其他程序调用
}
