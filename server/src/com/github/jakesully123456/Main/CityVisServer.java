package com.github.jakesully123456.Main;

import com.github.jakesully123456.Chunk.Chunk;
import com.github.jakesully123456.Chunk.Layer;
import com.github.jakesully123456.Generation.BoroughGen;

public class CityVisServer {

	private static Chunk[][] chunks = new Chunk[500][500];
	private static final int layers = 1;
	private static final String[] layerTypes = {"borough"};

	public static void main(String[] args) {

	}

	private static void chunkMake() {
		for (int x = 0; x < 500; x++) {
			for (int z = 0; z < 500; z++) {
				Layer lay;
				for (int i = 0; i < layers; i++) {
					lay = layerMake(layerTypes[i], x, z);
				}
				Chunk chunk = new Chunk(x, z);
				chunk.addLayer(lay);
			}
		}
	}

	private static Layer layerMake(String type, int x, int z) {
		if (type.equals("borough")) {
			BoroughGen gen = new BoroughGen();
			int[][] map = gen.map;
			Layer lay = new Layer(1, 1, type);
			Object[][] data = {map[x][z]};
			lay.populate(data);
			return lay;
		}
	}
}
