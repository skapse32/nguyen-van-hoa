package com.nvh.boundary;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.nvh.controller.DrawSomethingController;


public class DrawSomthingGUI extends Applet implements ActionListener, MouseMotionListener{

	private MenuItem mNew;
	private MenuItem mOpen;
	private MenuItem mSave;
	private Component c;
	private Label mLabel;
	private DrawSomethingController mController;

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		createGUI();
		mController = new DrawSomethingController();
	}

	public void createGUI() {

		// Menu Item
		MenuBar mBar = new MenuBar();
		Menu mfile = new Menu("File");

		mLabel = new Label("[x,y]");
		mNew = new MenuItem("New");
		mOpen = new MenuItem("Open");
		mSave = new MenuItem("Save");
		
		mfile.add(mNew);
		mfile.add(mOpen);
		mfile.add(mSave);
		
		mBar.add(mfile);
		c = this;
		while (c != null && !(c instanceof Frame)) {
			c = c.getParent();
		}
		((Frame) c).setMenuBar(mBar);
		((Frame) c).setLocationRelativeTo(null);
		((Frame) c).setSize(500, 500);
		add(mLabel, BorderLayout.NORTH);
		
		mNew.addActionListener(this);
		mOpen.addActionListener(this);
		mSave.addActionListener(this);
		
		addMouseMotionListener(this);
		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				mController.changLine();
			}
			
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(mNew)){
			FileSystem.offerToSaveChanges(mController);
			repaint();
		}else if(e.getSource() == mOpen){
			mController.setList(FileSystem.openFile());
			repaint();
		}else if(e.getSource() == mSave){
			//save file lai
			FileSystem.saveAsFile((Frame)c);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Point temp =new Point(e.getX(), e.getY());
			
		mController.add(temp);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		mController.drawLine(arg0);
	}

	
}
