package Chapter17;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteOrder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonDemo extends JFrame {

	/**
	 * @param args
	 */
	class MessagePanel extends JPanel {
		private boolean centered = true;
		private int xCor;
		private int yCor;
		private String label;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
			repaint();
		}

		public MessagePanel(String label) {
			super();
			// TODO Auto-generated constructor stub
			this.label = label;
		}

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			if (centered) {
				super.paintComponent(g);
				FontMetrics myFont = g.getFontMetrics();
				xCor = getWidth() / 2 - myFont.stringWidth(label) / 2;
				yCor = getHeight() / 2 - myFont.getAscent() / 2;
			}
			g.drawString(label, xCor, yCor);
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			FontMetrics myFont = g.getFontMetrics();
			xCor = getWidth() / 2 - myFont.stringWidth(label) / 2;
			yCor = getHeight() / 2 - myFont.getAscent() / 2;
			g.drawString(label, xCor, yCor);
		}

		public int getxCor() {
			return xCor;
		}

		public void setxCor(int xCor) {
			this.xCor = xCor;
		}

		public int getyCor() {
			return yCor;
		}

		public void setyCor(int yCor) {
			this.yCor = yCor;
		}

		public void moveLeft() {
			// TODO Auto-generated method stub
			xCor -= 10;
			repaint();
		}

	}

	protected MessagePanel myText = new MessagePanel("This is my Panel");
	private JButton btn_left = new JButton("<=");
	private JButton btn_right = new JButton("=>");

	public ButtonDemo() {
		myText.setBackground(Color.WHITE);

		JPanel pan_btn = new JPanel();
		pan_btn.add(btn_left);
		pan_btn.add(btn_right);

		btn_left.setMnemonic('L');
		btn_right.setMnemonic('R');
		// TODO Auto-generated constructor stub

		setLayout(new BorderLayout());
		add(myText, BorderLayout.CENTER);
		add(pan_btn, BorderLayout.SOUTH);

		ButtonListener myListener = new ButtonListener();
		btn_left.addActionListener(myListener);
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == btn_left) {
				myText.moveLeft();
			}
			if (e.getSource() == btn_right) {

			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ButtonDemo mFrame = new ButtonDemo();
		mFrame.setTitle("DEMO BUTTOn");
		mFrame.setSize(250, 100);
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mFrame.setLocationRelativeTo(null);
		mFrame.setVisible(true);
	}

}
