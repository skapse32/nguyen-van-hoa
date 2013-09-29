package com.nvh.UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProcessBarCopy extends JFrame {

	private JProgressBar mBar;
	private JLabel mlbl;
	private Log log = LogFactory.getLog(this.getClass());
	private Thread mThread = new Thread(new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while (mBar.getValue() < 100) {
					mBar.setValue(mBar.getValue() + 1);
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	});

	public ProcessBarCopy() {
		setTitle("Copying...");
		setSize(300, 100);
		setVisible(true);

		mBar = new JProgressBar(0, 100);
		mBar.setValue(0);
		mBar.setStringPainted(true);
		add(mBar);

		setLocationRelativeTo(null);
	}

	@Before("execution(* com.nvh.readwrite.socket.BinaryData.read(..))")
	public void startThread() {
		mThread.start();
	}

	@After("execution(* com.nvh.readwrite.socket.BinaryData.read(..))")
	public void valueRun() throws InterruptedException {
		mBar.setValue(100);
		mThread.stop();
	}

}
