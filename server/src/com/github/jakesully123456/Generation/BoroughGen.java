package com.github.jakesully123456.Generation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.gson.stream.JsonReader;

public class BoroughGen {

	private BufferedImage image;
	private HashMap<Integer, String> boroughs;
	public Integer[][] map;

	public BoroughGen() {
		boroughs = new HashMap<Integer, String>();
		try {
			image = ImageIO.read(new File("boroughs.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fill();
		map = new Integer[500][500];
		readImage();
	}

	private void fill() {
		try {
			JsonReader reader = new JsonReader(new FileReader("boroughs.json"));
			reader.setLenient(true);
			reader.beginObject();
			while (reader.hasNext()) {
				String name = reader.nextName();
				try {
					int b = Integer.valueOf(name);
					boroughs.put(b, reader.nextString());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
			}
			reader.endObject();
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void readImage() {
		for (int x = 0; x < 500; x++) {
			for (int z = 0; z < 500; z++) {
				map[x][z] = getBorough(z, x);
				System.out.print(map[x][z] + (map[x][z] < 10 ? " " : ""));
			}
			System.out.println("");
		}
	}

	public int getBorough(int x, int z) {
		Color col = new Color(image.getRGB(x, z));
		/*Color col2;
		if (x < 5) {
			col2 = new Color(image.getRGB(x+5, z));
		} else {
			col2 = new Color(image.getRGB(x-5, z));
		}*/
		int red = col.getRed();
		/*int red2 = col2.getRed();*/
		if (red > 0 && red < 34 && col.getGreen() == 0 && col.getBlue() == 0) {
			return red;
		/*} else if (red2 > 0 && red2 < 34 && col2.getGreen() == 0 && col2.getBlue() == 0) {
			return red2;*/
		} else {
			return 0;
		}
	}
}
