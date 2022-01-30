package com.nsd.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {
	
	private ExcelUtils() {
		
	}

	private static Workbook getWorkbook(String fileName) {
		Workbook workbook;
		try(FileInputStream fis = new FileInputStream(fileName)){
			workbook= new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Excel File - "+fileName+" cannot be accessed . Got Exception \n"+e.getMessage());
		} catch (IOException e) {
			throw new RuntimeException("Excel File - "+fileName+" cannot be accessed . Got Exception \n"+e.getMessage());
		}
		return workbook;
	}

	public static List<Map<String,String>> getValuesFromAllRow(String fileName, String sheetName){
		List<Map<String,String>> headerAndValues = new ArrayList<>();
		Workbook workbook = getWorkbook(fileName);
		Sheet workSheet = getWorkSheet(workbook, sheetName);
		int totalRows = getTotalRows(workSheet);
		int totalColumns = getTotalColums(workSheet);

		for(int i=1;i<=totalRows;i++) {
			Map<String,String> map = new HashMap<>();
			for(int j = 0; j<totalColumns; j++) {
				map.put(workSheet.getRow(0).getCell(j).getStringCellValue(), 
						workSheet.getRow(i).getCell(j).getStringCellValue());
			}
			headerAndValues.add(map);
		}
		return headerAndValues;
	}

	public static Sheet getWorkSheet(Workbook workbook, String sheetName) {
		return workbook.getSheet(sheetName);
	}

	public static int getTotalRows(Sheet workSheet) {
		return workSheet.getLastRowNum();
	}

	public static int getTotalColums(Sheet workSheet) {
		return workSheet.getRow(0).getLastCellNum();
	}

}
