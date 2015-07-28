package com.github.jakesully123456.Main;

public class Layer {
	private int xSize;
	private int zSize;
	private int[][] data;
	private String name;
	
	public Layer(String name, int xSize, int zSize, int[][] data) {
		this.zSize = zSize;
		this.xSize = xSize;
		this.data = data;
		this.name = name;
	}
	
	public int[][] getData() {
		return data;
	}
	
	public String getName() {
		return name;
	}
	
}
