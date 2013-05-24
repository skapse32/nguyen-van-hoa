package StatePattern;

public class NoQuaterState implements State {

	GumballMachine machine;
	
	public NoQuaterState(GumballMachine machine) {
		super();
		this.machine = machine;
	}
	
	public void setMachine(GumballMachine machine) {
		this.machine = machine;
	}



	@Override
	public void insertQuater() {
		// TODO Auto-generated method stub
		System.out.println("You inserted a Quarter");
	}

	@Override
	public void ejectQuater() {
		// TODO Auto-generated method stub
		System.out.println("You haven't inserted a Quarter");
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("You turned, but there's no quarter");
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("You have to pay first!");
	}

}
