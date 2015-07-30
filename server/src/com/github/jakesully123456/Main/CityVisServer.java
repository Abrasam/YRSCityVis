package com.github.jakesully123456.Main;

import java.util.Arrays;
import java.util.HashMap;

import com.github.jakesully123456.Generation.BoroughGen;
import com.github.jakesully123456.Generation.CrimeGen;
import com.github.jakesully123456.Generation.FireGen;
import com.github.jakesully123456.Generation.GenUtil;
import com.github.jakesully123456.Generation.PriceGen;
import com.github.jakesully123456.Generation.WardGen;
import com.github.jakesully123456.Generation.WardLocationGen;
import com.github.jakesully123456.Transfer.JSONConverter;

public class CityVisServer {

	private static HashMap<String, Layer> layers = new HashMap<String, Layer>();
	private static BoroughGen gen;

	public static void main(String[] args) {
		System.out.println(Arrays.asList(args));
		if (args.length > 0) {
			GenUtil.setAbsolutePath(args[0]);
			if (args.length > 1 && args[1].equalsIgnoreCase("boroughmap")) {
				gen = new BoroughGen();
				JSONConverter.parseArray(gen.map);
			} else if (args.length > 1 && args[1].equalsIgnoreCase("wardlocs")) {
				System.out.println(JSONConverter.toString(new WardLocationGen(new WardGen()).coords));
			} else if (args.length > 1 && args[1].equalsIgnoreCase("crimedata")) {
				new CrimeGen(new WardGen());
			} else if (args.length > 1 && args[1].equalsIgnoreCase("firedata")) {
				gen = new BoroughGen();
				System.out.println(JSONConverter.toString(new FireGen(gen)));
			} else if (args.length > 1 && args[1].equalsIgnoreCase("pricedata")) {
				gen = new BoroughGen();
				System.out.println(JSONConverter.toString(new PriceGen(gen)));
			} else if (args.length > 1 && args[1].equalsIgnoreCase("wardlist")) {
				System.out.println(JSONConverter.toString(new WardGen().wards()));
			} else if (args.length > 1 && args[1].equalsIgnoreCase("debug")) {
				gen = new BoroughGen();
				layers();
				JSONConverter.parseArray(layers.get("boroughs").getData());
				WardGen wards = new WardGen();
				wards.print();
				WardLocationGen wlg = new WardLocationGen(wards);
				CrimeGen crimes = new CrimeGen(wards);
				FireGen fires = new FireGen(gen);
				PriceGen price = new PriceGen(gen);
				System.out.println(wards.wards().size());
				System.out.println(crimes.crimes.keySet().size());
				System.out.println(fires.fires.keySet().size());
				System.out.println(price.prices.keySet().size());
				System.out.println(wlg.items.size());
			}
		} else {
			System.out.println("Parse path of file directory as argument 1.");
		}
	}

	private static void layers() {
		layers.put("boroughs", new Layer("boroughs", gen.map));
	}
}
