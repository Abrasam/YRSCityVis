package com.github.jakesully123456.Generation;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WardGen {

	private ArrayList<String> wards;

	public WardGen() {
		wards = new ArrayList<String>();
		FileInputStream file;
		try {
			file = new FileInputStream(new File(GenUtil.absolutePath + "CrimeData.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_NUMERIC:
						break;
					case Cell.CELL_TYPE_STRING:
						if (wards.contains(cell.getStringCellValue())) {
							System.out.println("ERROR! " + cell.getStringCellValue());
						}
						wards.add(cell.getStringCellValue());
						break;
					}
				}
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void print() {
		System.out.println(wards.toString());
	}

	public ArrayList<String> wards() {
		return wards;
	}
}
