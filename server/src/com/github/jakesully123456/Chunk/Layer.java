package com.github.jakesully123456.Chunk;

public class Layer {
	
	private int x;
	private int z;
	private String name;
	private Object[] content;

	public Layer(int x, int z, String name) {
		this.x = x;
		this.z = z;
		this.name = name;
		content = new Object[x][z];
	}
	
	public void populate(Object[][] obj) {
		content = obj;
	}
	
	public Object[] getContent() {
		return content;
	}

}
