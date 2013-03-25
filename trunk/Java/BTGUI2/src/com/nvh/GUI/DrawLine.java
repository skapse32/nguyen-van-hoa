package com.nvh.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DrawLine implements DrawBehavior {

	@Override
	public void draw(Graphics g, Point start, Point end, Color mColor) {
		// TODO Auto-generated method stub
		g.setColor(mColor);
		g.drawLine(start.x, start.y, end.x, end.y);
	}
}
