package Chapter29;

import java.applet.Applet;

import javax.swing.JLabel;

public class FlasingText extends Applet implements Runnable{

	private JLabel mylbl = new JLabel("Hello Thread",JLabel.CENTER);
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		add(mylbl);
		new Thread(this).start();
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true){
				if(mylbl.getText() == null)
					mylbl.setText("Hello Thread");
				else
					mylbl.setText(null);
				Thread.sleep(200);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


}
