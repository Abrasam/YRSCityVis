package com.github.jakesully123456.Chunk;

public class Chunk {

	private long[] coords;
	
	public Chunk(long x, long z) {
		coords = new long[2];
		coords[0] = x;
		coords[1] = z;
	}

}
