package com.github.jakesully123456.Transfer;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class JSONConverter {
	public static String parseArray(int[][] array) {
		Gson gson = new Gson();
		List<String> parent = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			String child = gson.toJson(array[i]);
			parent.add(child);
		}
		System.out.println(gson.toJson(parent));
		return gson.toJson(parent);
		
		
	}
}
