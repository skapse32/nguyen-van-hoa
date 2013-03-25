package com.nvh.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class DrawCircle implements DrawBehavior {

	@Override
	public void draw(Graphics g, Point start, Point end, Color mColor) {
		// TODO Auto-generated method stub
		g.setColor(mColor);
		g.fillOval(start.x, start.y, end.x - start.x, end.y - start.y);
	}

	


}
