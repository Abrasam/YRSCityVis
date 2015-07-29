package com.github.jakesully123456.Main;

import java.util.HashMap;

import com.github.jakesully123456.Generation.BoroughGen;
import com.github.jakesully123456.Generation.CrimeGen;
import com.github.jakesully123456.Generation.FireGen;
import com.github.jakesully123456.Generation.PriceGen;
import com.github.jakesully123456.Generation.WardGen;
import com.github.jakesully123456.Transfer.JSONConverter;

public class CityVisServer {

	private static HashMap<String, Layer> layers = new HashMap<String, Layer>();
	private static BoroughGen gen = new BoroughGen();

	public static void main(String[] args) {
		layers();
		JSONConverter.parseArray(layers.get("boroughs").getData());
		WardGen wards = new WardGen();
		wards.print();
		CrimeGen crimes = new CrimeGen();
		System.out.println(crimes.crimes.keySet().toString());
		FireGen fires = new FireGen(gen);
		PriceGen price = new PriceGen(gen);
		System.out.println(wards.wards().size());
		System.out.println(crimes.crimes.keySet().size());
		System.out.println(fires.fires.keySet().size());
		System.out.println(price.prices.keySet().size());
	}
	
	private static void layers() {
		layers.put("boroughs", new Layer("boroughs", 500, 500, gen.map));
	}
}
