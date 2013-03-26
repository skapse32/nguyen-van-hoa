package Chapter1Update;

public class TestProgram {

	/**
	 * @param args
	 */
	public static void main(String args[]){
		Duck mDuck = new MallardDuck();
		mDuck.flyPerform();
		mDuck.quackPerform();
		
		//Model Duck
		Duck mDuck2 = new ModelDuck();
		mDuck2.flyPerform();
		mDuck2.setFlyBehavior(new FlyRocketPowered());
		mDuck2.flyPerform();
	}

}
