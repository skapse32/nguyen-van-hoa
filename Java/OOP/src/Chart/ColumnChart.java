/**
 * 
 */
package Chart;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * @author vanhoa
 *
 */
public class ColumnChart extends Applet {

	private Container myContainer;
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		myContainer = new Container(9);
		myContainer.initArray();
		this.setSize(500, 500);
	}

	@Override
	public void paint(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paint(arg0);
		myContainer.drawContainer(arg0);
	}
	
}
