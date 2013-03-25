package com.nvh.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public interface DrawBehavior {

	public void draw(Graphics g,Point start,Point end, Color mColor);
	
}
