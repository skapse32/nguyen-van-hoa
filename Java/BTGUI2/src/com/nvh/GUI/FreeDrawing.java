package com.nvh.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class FreeDrawing extends JFrame{

	/**
	 * @param args
	 */
	private JRadioButton rdb_red;
	private JRadioButton rdb_green;
	private JRadioButton rdb_blue;

	private JRadioButton rdb_line;
	private JRadioButton rdb_circle;
	private JRadioButton rdb_rectangle;
	private JButton save;
	private JButton open;
	private JButton clear;
	private JButton exit;
	private DrawPanel mContent;
	private Color mColor = Color.BLACK;
	
	public FreeDrawing() {
		super();
		setSize(500,500);

		//Panel chinh
		JPanel contextPanel = new JPanel(new BorderLayout());
		
		//Panel cac tool tuy chinh
		JPanel toolPanel = new JPanel(new GridLayout(2, 1));
		
		//Panel color
		JPanel color = new JPanel(new GridLayout(3, 1));
		color.add(rdb_red = new JRadioButton("Red"));
		color.add(rdb_green = new JRadioButton("Green"));
		color.add(rdb_blue = new JRadioButton("Blue"));
		color.setBorder(new TitledBorder("Color"));
		ButtonGroup btg_color = new ButtonGroup();
		btg_color.add(rdb_red);
		btg_color.add(rdb_green);
		btg_color.add(rdb_blue);
		toolPanel.add(color);
		
		//Panel Shape
		JPanel shape = new JPanel(new GridLayout(3,1));
		shape.add(rdb_line = new JRadioButton("Line"));
		shape.add(rdb_circle = new JRadioButton("Circle"));
		shape.add(rdb_rectangle = new JRadioButton("Rectangle"));
		shape.setBorder(new TitledBorder("Shape"));
		ButtonGroup btg_shape = new ButtonGroup();
		btg_shape.add(rdb_line);
		btg_shape.add(rdb_circle);
		btg_shape.add(rdb_rectangle);
		toolPanel.add(shape);
		
		//panel khung ve


		setVisible(true);
		mContent = new DrawPanel();
		
		//panel button
		JPanel mbutton = new JPanel(new GridLayout(1, 4, 5 ,5));
		mbutton.add(save = new JButton("Save"));
		mbutton.add(open = new JButton("Open"));
		mbutton.add(clear = new JButton("Clear"));
		mbutton.add(exit = new JButton("Exit"));

		
		contextPanel.add(mContent, BorderLayout.CENTER);
		contextPanel.add(toolPanel,BorderLayout.EAST);
		contextPanel.add(mbutton,BorderLayout.SOUTH);
		
		addListener();
		add(contextPanel);
		
	}
	
	public void addListener(){
		rdb_circle.addActionListener(mListener);
		rdb_line.addActionListener(mListener);
		rdb_rectangle.addActionListener(mListener);
		
		rdb_blue.addActionListener(mListenerColor);
		rdb_red.addActionListener(mListenerColor);
		rdb_green.addActionListener(mListenerColor);
	}
	
	private ActionListener mListenerColor = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(rdb_red)){
				mColor = Color.RED;
			}else if(e.getSource() == rdb_green){
				mColor = Color.GREEN;	
			}else if(e.getSource() == rdb_blue){
				mColor = Color.BLUE;
			}
		}
	};
	
	private ActionListener mListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource().equals(rdb_line)){
				mContent.pickShape(1, mColor);
			}else if(e.getSource() == rdb_circle){
				mContent.pickShape(2, mColor);				
			}else if(e.getSource() == rdb_rectangle){
				mContent.pickShape(3, mColor);
			}
		}
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FreeDrawing();
	}

}
