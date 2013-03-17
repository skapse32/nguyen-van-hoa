package com.nvh.entity;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Line implements Serializable{
	
	private ArrayList<Point> mPoints;
	
	public Line(){
		mPoints = new ArrayList<Point>();
	}
	
	public Line(ArrayList<Point> mPoints) {
		super();
		this.setPoints(mPoints);
	}

	public ArrayList<Point> getPoints() {
		return mPoints;
	}

	public void setPoints(ArrayList<Point> mPoints) {
		this.mPoints = mPoints;
	}	
	
	public void addPoint(Point p){
		this.mPoints.add(p);
	}
	
	public int getLength(){
		return mPoints.size();
	}
	
	public Point getPoint(int index){
		return mPoints.get(index);
	}
}
