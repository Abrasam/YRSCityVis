package com.github.jakesully123456.Main;

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
		if (args.length > 0) {
			GenUtil.setAbsolutePath(args[0]);
			gen = new BoroughGen();
			if (args.length > 1 && args[1].equalsIgnoreCase("boroughmap")) {
				JSONConverter.parseArray(gen.map);
			} else if (args.length > 1 && args[1].equalsIgnoreCase("debug")) {
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
