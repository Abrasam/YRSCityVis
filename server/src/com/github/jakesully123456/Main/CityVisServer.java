package com.github.jakesully123456.Main;

import java.util.HashMap;

import com.github.jakesully123456.Generation.BoroughGen;
import com.github.jakesully123456.Transfer.Parser;

public class CityVisServer {

	private static HashMap<String, Layer> layers = new HashMap<String, Layer>();
	private static BoroughGen gen = new BoroughGen();

	public static void main(String[] args) {
		layers();
		Parser.parseArray(layers.get("boroughs").getData());
	}
	
	private static void layers() {
		layers.put("boroughs", new Layer("boroughs", 500, 500, gen.map));
	}
}
