package com.github.jakesully123456.Generation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WardLocationGen {

	public HashMap<String, String> items;
	public HashMap<String, List<Double>> coords;

	public WardLocationGen(WardGen wards) {
		items = new HashMap<String, String>();
		coords = new HashMap<String, List<Double>>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(GenUtil.absolutePath + "Wards.txt")));
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				for (String ward : wards.wards()) {
					if (line.length() >= ward.length()) {
						//System.out.println(getValidText(line));
						//System.out.println(ward);
						if (line.substring(0, ward.length()).equalsIgnoreCase(ward) && getValidText(line).equalsIgnoreCase(ward)) {
							if (!items.containsKey(ward)) {
								items.put(ward, line);
							} else {
								//System.out.println("ERROR: " + ward);
							}
						}
					}
				}
			}
			for (String ward : wards.wards()) {
				boolean bool = false;
				for (String line : items.keySet()) {
					if (line.equals(ward)) {
						bool = true;
					}
				}
				if (!bool) {
					System.out.println("MISSING: " + ward);
				}
			}
			System.out.println(items.toString());
			reader.close();
			for (String item : items.keySet()) {
				coords.put(item, parse(items.get(item), item));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private List<Double> parse(String line, String ward) {
		String newLine = line.replaceAll(" ", "").replaceAll("\t", "").toLowerCase();
		String newWard = ward.replaceAll(" ", "").replaceAll("\t", "").toLowerCase();
		String coords = newLine.replaceAll(newWard, "");
		String[] coordinates = coords.split(",");
		List<Double> doucoords = new ArrayList<Double>();
		for (String item : Arrays.asList(coordinates)) {
			if (item.equals("")) {
				System.out.println("ERROR: " + line + " - " + ward + coords + coordinates.toString());
			} else {
			doucoords.add(Double.valueOf(item));
			}
		}
		return doucoords;
	}
	
	private String getValidText(String line) {
		for (int i = 0; i < line.length(); i ++) {
			if (!Character.isLetter(line.charAt(i)) && line.charAt(i) != ' ' && line.charAt(i) != '\t' && line.charAt(i) != 39 && line.charAt(i) != ',') {
				String sub = line.substring(0, i-1);
				return sub;
			}
		}
		return "";
	}
}
