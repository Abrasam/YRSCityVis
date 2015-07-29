package com.github.jakesully123456.Main;

public class Layer {
	private int[][] data;
	private String name;
	
	public Layer(String name, int[][] data) {
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
