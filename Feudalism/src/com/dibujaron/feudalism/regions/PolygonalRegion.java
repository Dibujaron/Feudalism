package com.dibujaron.feudalism.regions;

import java.util.ArrayList;

import com.dibujarion.feudalism.util.RegionUtils;

public abstract class PolygonalRegion {
	protected ArrayList<Point> myPoints;
	int maxPointX = Integer.MIN_VALUE;
	
	public PolygonalRegion(ArrayList<Point> points){
		myPoints = points;
		
		for(Point p : points){
			if(p.getX() > maxPointX) maxPointX = p.getX();
		}
	}
	
	public PolygonalRegion(){
		myPoints = new ArrayList<Point>();
	}
	
	public void addPoint(Point p){
		if(p.getX() > maxPointX) maxPointX = p.getX();
		myPoints.add(p);
	}
	
	public boolean contains(Point p){
		//method for seeing if a point is within a polygonal region
		//for information on how this works see
		//http://www.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon/
		int n = myPoints.size();
		if(n < 3 ) return false;
		
		//first get a line from Point p to the maximum east it could possibly be
		Point eastMost = new Point(maxPointX + 10, p.getZ());
		
		int intersectionCount = 0;
		int i = 0;
		do{
			int next = (i+1)%n;
			
			if(RegionUtils.intersectionCheck(myPoints.get(i), myPoints.get(next), p, eastMost)){
				if(RegionUtils.orientation(myPoints.get(i), p, myPoints.get(next)) == 0){
					return RegionUtils.onSegment(myPoints.get(i), p, myPoints.get(next));
				}
				intersectionCount++;
			}
			i = next;
		} while (i != 0);
		
		return intersectionCount%2 == 1;
		
		
	}
}
