package com.nvh.GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	private ArrayList<Shape> myShape;
	private Graphics mGraphic;
	private Shape s;
	private boolean clicked = false;

	public DrawPanel() {
		myShape = new ArrayList<Shape>();
		setBackground(Color.white);
		mGraphic = getGraphics();
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if (!clicked) {
					s.setStart(new Point(e.getX(), e.getY()));
					clicked = true;
				} else {
					s.setEnd(new Point(e.getX(), e.getY()));
					s.performDraw(getGraphics());
					myShape.add(s);
					repaint();
					clicked = false;
				}
			}
		});
		addMouseMotionListener(new MouseMotionAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseMoved(e);
				if (clicked) {
					s.setEnd(new Point(e.getX(), e.getY()));
					getGraphics().clearRect(0, 0, getWidth(), getHeight());
					s.performDraw(getGraphics());

				}
			}

		});
	}

	public void pickShape(int shape, Color mColor) {
		switch (shape) {
		case 1:
			s = new Line();
			s.setColor(mColor);
			break;
		case 2:
			s = new Circle();
			s.setColor(mColor);
			break;

		case 3:
			s = new Rectangle();
			s.setColor(mColor);
			break;
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		if(!myShape.isEmpty()){
			for (Shape i : myShape) {
				i.performDraw(g);
			}
		}
	}
	
	
}
