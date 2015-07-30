package com.github.jakesully123456.Generation;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.jakesully123456.Transfer.JSONConverter;

public class CrimeGen {

	public HashMap<String, Integer> crimes;
	
	public CrimeGen(WardGen wardGen) {
		crimes = new HashMap<String, Integer>();
		for (String ward : wardGen.wards()) {
			int crimeCount = find(ward);
			if (crimeCount != -1) {
				crimes.put(ward, crimeCount);
			} else {
				System.out.println("ERROR - Special ward:" + ward);
			}
		}
		System.out.println(JSONConverter.toString(crimes));
	}
	
	private int find(String ward) {
		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook(new File(GenUtil.absolutePath + "CrimeData.xlsx"));
			XSSFSheet sheet = workbook.getSheet("Sheet1");
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
						if (cell.getStringCellValue().equalsIgnoreCase(ward)) {
							return (int) Math.round(row.getCell(cell.getColumnIndex() + 1).getNumericCellValue());
						}
						break;
					}
				}
			}
			workbook.close();
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		return -1;
		
	}
}
