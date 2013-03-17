package com.nvh.controller;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import com.nvh.entity.Line;


public class DrawSomethingController {

	private static ArrayList<Line> mList = new ArrayList<Line>();
	private static Line mLine;
	
	
	public static ArrayList<Line> getList() {
		return mList;
	}

	public void setList(ArrayList<Line> mList) {
		this.mList = mList;
	}

	public void clearNullArray(){
		
	}
	
	public DrawSomethingController(){
		mLine = new Line();
		mList.add(mLine);
	}
	
	public void changLine(){
		mLine = new Line();
		mList.add(mLine);
	}
	
	public DrawSomethingController(Line mLine) {
		super();
		this.mLine = mLine;
	}

	public void add(Point p){
		mLine.addPoint(p);
	}
	
	public void drawLine(Graphics g){
		for (int i = 0; i < mList.size(); i++) {
			for (int j = 0; j < mList.get(i).getLength() -1 ; j++) {
				Point temp1 = mList.get(i).getPoint(j);
				Point temp2 = mList.get(i).getPoint(j+1);
				g.drawLine(temp1.x, temp1.y, temp2.x, temp2.y);
			}
		}
	}
}
