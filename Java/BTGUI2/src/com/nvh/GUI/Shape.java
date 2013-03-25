package com.nvh.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Shape {

	DrawBehavior mBehavior;
	Point start;
	Point end;
	Color mColor;
	
	public void setColor(Color mColor) {
		this.mColor = mColor;
	}

	public Point getStart() {
		return start;
	}

	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public void performDraw(Graphics g) {
		mBehavior.draw(g, start, end, mColor);
	}

}
