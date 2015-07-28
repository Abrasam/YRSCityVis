package com.github.jakesully123456.Chunk;

import java.util.HashMap;

public class Chunk {

	private long[] coords;
	private HashMap<String, Layer> layers;

	public Chunk(long x, long z) {
		coords = new long[2];
		coords[0] = x;
		coords[1] = z;
		layers = new HashMap<String, Layer>();
	}

	public void addLayer(Layer layer) {
		layers.put(layer.getName(), layer);
	}

	public Layer getLayer(String name) {
		if (layers.containsKey(name)) {
			return layers.get(name);
		} else {
			return null;
		}
	}

}
