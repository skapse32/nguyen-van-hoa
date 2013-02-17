package Chapter16;

import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ControlCircle extends JFrame {

	private JButton btn_phongto;
	private JButton btn_thunho;
	private CirclePanel myCircle = new CirclePanel();


	public ControlCircle() {
		// TODO Auto-generated constructor stub
		JPanel p1 = new JPanel();
		p1.setBorder(new TitledBorder("BUTTON"));
		btn_phongto = new JButton("Phong To");
		btn_thunho = new JButton("Thu Nho");
		p1.add(btn_phongto);
		p1.add(btn_thunho);
		
		
		add(myCircle, BorderLayout.CENTER);
		add(p1 , BorderLayout.SOUTH);
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
		private int radius = 20;

		public void phongto() {
			radius++;
			repaint();
		}

		@Override
		public void paintComponents(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponents(g);
			g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius,
					radius * 2, radius * 2);
		}

	}
}
