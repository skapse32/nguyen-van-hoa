package com.nvh.boundary;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JPanel;

import com.nvh.controller.DrawSomethingController;

public class SaveAsGUI extends Dialog {

	private Label mLabel;
	private TextField mField;
	private Button btn_ok;
	private Button btn_cancel;

	public SaveAsGUI(Frame owner) {
		super(owner);
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(2, 1));
		mLabel = new Label("Chon duong dan :");
		mField = new TextField(10);
		btn_ok = new Button("Save");
		btn_cancel = new Button("Cancel");

		JPanel p1 = new JPanel(new FlowLayout());
		p1.add(mLabel);
		p1.add(mField);
		JPanel p2 = new JPanel(new FlowLayout());
		p2.add(btn_ok);
		p2.add(btn_cancel);

		add(p1);
		add(p2);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				setVisible(false);
			}

		});
		
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mField.setText("");
				setVisible(false);
			}
		});
		
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dst = mField.getText();
				FileSystem.saveFile(DrawSomethingController.getList(), dst);
				mField.setText("");
				setVisible(false);
			}
		});
	}

}
