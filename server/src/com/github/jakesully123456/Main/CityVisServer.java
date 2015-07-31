package com.github.jakesully123456.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.github.jakesully123456.Generation.BoroughGen;
import com.github.jakesully123456.Generation.BoroughImageGen;
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
		/*
		 * This section simply checks what the argument of the program is, and returns the correct information.
		 * Our program works by running this in shell_exec() with php and echoing the prints.
		 * 
		 * I AM SO SO SO SO SO SO SORRY ABOUT THE STUPID IF STATEMENTS (I WILL CHANGE IT TO A SWITCH STATEMENT SOON - I PROMISE GUV!)
		 */
		if (args.length > 0) {
			GenUtil.setAbsolutePath(args[0]);
			//Returns a image generated borough map array. Currently redundant until optimised.
			if (args.length > 1 && args[1].equalsIgnoreCase("boroughmap")) {
				gen = new BoroughGen();
				JSONConverter.parseArray(gen.map);
				//Returns a JSON formatted hashmap with all 602 London wards and their lat long coords.
			} else if (args.length > 1 && args[1].equalsIgnoreCase("wardlocs")) {
				System.out.println(JSONConverter.toString(new WardLocationGen(new WardGen()).coords));
				//This returns a JSON formatted hashmap with all 602 london wards and their crime data of the last month.
			} else if (args.length > 1 && args[1].equalsIgnoreCase("crimedata")) {
				try {
					BufferedReader fileRead = new BufferedReader(new FileReader(GenUtil.absolutePath + "files.txt"));
					String str = fileRead.readLine();
					System.out.println(str);
					fileRead.close();
				} catch (IOException e) {
					System.out.println("Nada documentos!");
					e.printStackTrace();
				}
				//This is called to update the crime data.
			} else if ((args.length > 1 && args[1].equalsIgnoreCase("updatecrimedata"))) {
				try {
					PrintWriter writer = new PrintWriter(GenUtil.absolutePath + "files.txt");
					writer.println(JSONConverter.toString(new CrimeGen(new WardGen()).crimes));
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				//This returns a hashmap of the boroughs to their fire count last month. Also in JSON format.
			} else if (args.length > 1 && args[1].equalsIgnoreCase("firedata")) {
				gen = new BoroughGen();
				System.out.println(JSONConverter.toString(new FireGen(gen).fires));
				//Returns the average price per borough. Also a JSON formatted hashmap.
			} else if (args.length > 1 && args[1].equalsIgnoreCase("pricedata")) {
				gen = new BoroughGen();
				System.out.println(JSONConverter.toString(new PriceGen(gen).prices));
				//Sends a JSON formatted list of each ward.
			} else if (args.length > 1 && args[1].equalsIgnoreCase("wardlist")) {
				System.out.println(JSONConverter.toString(new WardGen().wards()));
				//Do not call unless you're me and are trying to fix bad things.
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
			} else if (args.length > 1 && args[1].equalsIgnoreCase("fireimg")) {
				System.out.println("FIRE DOING");
				new BoroughImageGen(true, false, false);
			} else if (args.length > 1 && args[1].equalsIgnoreCase("priceimg")) {
				System.out.println("PRICE DOING");
				new BoroughImageGen(false, true, false);
			} else if (args.length > 1 && args[1].equalsIgnoreCase("mapimg")) {
				System.out.println("BMAP DOING");
				new BoroughImageGen(false, false, true);
			}
		} else {
			System.out.println("Parse path of file directory as argument 1.");
		}
	}

	private static void layers() {
		layers.put("boroughs", new Layer("boroughs", gen.map));
	}
}
