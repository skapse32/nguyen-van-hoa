package Chapter16;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ControlCircle extends JFrame {

	private JButton btn_phongto;
	private JButton btn_thunho;
	private CirclePanel myCircle = new CirclePanel();
	private ButtonListener myListener = new ButtonListener();

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btn_phongto)
				myCircle.phongto();
			else if (e.getSource() == btn_thunho) {
				myCircle.thunho();
			}
		}

	}

	public ControlCircle() {
		// TODO Auto-generated constructor stub
		JPanel p1 = new JPanel();
		p1.setBorder(new TitledBorder("BUTTON"));
		btn_phongto = new JButton("Phong To");
		btn_thunho = new JButton("Thu Nho");
		p1.add(btn_phongto);
		p1.add(btn_thunho);

		add(myCircle, BorderLayout.CENTER);
		add(p1, BorderLayout.SOUTH);

		btn_phongto.addActionListener(myListener);
		btn_thunho.addActionListener(myListener);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowActivated(e);
				System.out.println("Window Actived");
			}

		});

		/*
		 * addMouseMotionListener(new MouseMotionAdapter() {
		 * 
		 * @Override public void mouseDragged(MouseEvent e) { // TODO
		 * Auto-generated method stub super.mouseDragged(e);
		 * myCircle.setX(e.getX()); myCircle.setY(e.getY());
		 * myCircle.dragCircle(); }
		 * 
		 * });
		 */
	}

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControlCircle myFrame = new ControlCircle();
		myFrame.setSize(210, 200);
		myFrame.setTitle("Control Circle");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		myFrame.setVisible(true);
	}

	class CirclePanel extends JPanel {
		private int radius = 5;
		private int x;
		private int y;

		public CirclePanel() {
			super();
			// TODO Auto-generated constructor stub
			x = getWidth() / 2 - radius;
			y = getHeight() / 2 - radius;

			addKeyListener(new KeyAdapter() {

				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					super.keyPressed(e);
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						x++;
					}
				}
			});
			repaint();
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void phongto() {
			radius++;
			repaint();
		}

		public void thunho() {
			radius--;
			repaint();
		}

		public void dragCircle() {
			x++;
			repaint();
		}

		@Override
		public void paint(Graphics arg0) {
			// TODO Auto-generated method stub
			super.paint(arg0);

			arg0.drawOval(x, y,
					radius * 2, radius * 2);
		}
		
	}
}
