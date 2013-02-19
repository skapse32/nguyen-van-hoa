/**
 * 
 */
package Chart;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author vanhoa
 * 
 */
public class Container {

	private Rectangle[] arrayChart;
	private int[] data;
	private int x;
	private int y;
	private int width;

	public Container(int numofColumn) {
		// TODO Auto-generated constructor stub
		arrayChart = new Rectangle[numofColumn];
		data = new int[numofColumn];
		x = 10;
		y = 450;
		width = 50;
	}

	public void initArray() {
		Random myRandom = new Random();
		for (int i = 0; i < arrayChart.length; i++) {
			arrayChart[i] = new Rectangle(x + (i * width), y, width,
					data[i] = myRandom.nextInt(400));
		}
	}

	public void drawContainer(Graphics g) {
		Random myRandom = new Random(5);
		for (int i = 0; i < arrayChart.length; i++) {
			g.setColor(new Color(myRandom.nextInt(255), myRandom.nextInt(255),
					myRandom.nextInt(255)));
			g.drawRect(arrayChart[i].getX(), arrayChart[i].getY(),
					arrayChart[i].getWidth(), arrayChart[i].getHeight());
			g.drawString(String.valueOf(data[i]), arrayChart[i].getX() + 20,
					arrayChart[i].getY() - 10);
		}
	}
}
