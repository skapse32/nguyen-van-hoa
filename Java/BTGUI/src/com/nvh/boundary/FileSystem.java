package com.nvh.boundary;

import java.awt.Frame;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.nvh.controller.DrawSomethingController;
import com.nvh.entity.Line;

public class FileSystem {

	private static Frame mframe;

	public static ArrayList<Line> openFile() {
		JFileChooser mChooser = new JFileChooser();
		ArrayList<Line> list = null;
		if (mChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(
							mChooser.getSelectedFile())))) {
				list = (ArrayList<Line>) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error! : " + e.toString());
			}
		}
		return list;
	}

	public static void NewFile(DrawSomethingController dtc) {
		dtc.getList().clear();
	}

	public static void saveFile(ArrayList<Line> list,String dst){
		try (ObjectOutputStream ois = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(
						dst)));) {
			ois.writeObject(list);
			ois.flush();
		} catch (IOException e) {
			// TODO: handle exception
		}

	}
	
	public static void saveAsFile(Frame c) {
		mframe = c;
		new SaveAsGUI(c);
	}

	public static void offerToSaveChanges(DrawSomethingController dtc) {
		int option = JOptionPane.showConfirmDialog(null,
				"Bạn có muốn save lại file không?");
		switch (option) {
		case JOptionPane.CANCEL_OPTION:
			// khong lam gi ca
			break;
		case JOptionPane.NO_OPTION:
			NewFile(dtc);
			break;
		case JOptionPane.OK_OPTION:
			saveAsFile(mframe);
			break;
		}
	}
}
