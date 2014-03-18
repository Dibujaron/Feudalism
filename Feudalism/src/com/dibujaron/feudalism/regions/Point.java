package com.dibujaron.feudalism.regions;

//represents a 2d point in x, z. Used for polygonal regions.

public class Point {
	private int x, z;
	
	public Point(int x, int z){
		this.x = x;
		this.z = z;
	}
	
	public int getX(){
		return x;
	}
	
	public int getZ(){
		return z;
	}
}
