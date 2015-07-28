package com.github.jakesully123456.Main;

import com.github.jakesully123456.Chunk.Chunk;
import com.github.jakesully123456.Chunk.Layer;
import com.github.jakesully123456.Generation.BoroughGen;

public class CityVisServer {

	private static Chunk[][] chunks = new Chunk[500][500];
	private static final int layers = 1;
	private static final String[] layerTypes = {"borough"};
	private static BoroughGen gen = new BoroughGen();

	public static void main(String[] args) {
		chunkMake();
		for (int x = 0; x < chunks.length; x++) {
			for (int z = 0; z < chunks[x].length; z++) {
				Object[][] layer = chunks[x][z].getLayer("borough").getContent();
				System.out.println(layer);
			}
		}
	}

	private static void chunkMake() {
		for (int x = 0; x < 500; x++) {
			for (int z = 0; z < 500; z++) {
				Layer lay = null;
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
			Object map = (Object)gen.map[x][z];
			Layer lay = new Layer(1, 1, type);
			Object[][] data = {{map}};
			lay.populate(data);
			return lay;
		} else {
			return new Layer(0, 0, "null");
		}
	}
}
