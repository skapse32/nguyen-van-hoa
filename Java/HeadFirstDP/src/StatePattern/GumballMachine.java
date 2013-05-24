package StatePattern;

public class GumballMachine {
 
	State soldout;
	State noquater;
	State hasquater;
	State soldState;
 
	State state = soldout;
	int count = 0;
  
	public GumballMachine(int count) {
		soldout = new SoldOutState();
		noquater = new NoQuaterState(this);
		hasquater = new HasQuaterState();
		soldState = new SoldState();  
		this.count = count;
		if (count > 0) {
			state = noquater;
		}
	}
  
	public void insertQuarter() {
		state.insertQuater();
	}

	public void ejectQuarter() {
		state.ejectQuater();
	}
 
	public void setState(State state) {
		this.state = state;
	}

	public void turnCrank() {
		state.turnCrank();
	}
 
	public void dispense() {
		state.dispense();
	}
 
	public void refill(int numGumBalls) {
		this.count = numGumBalls;
		state = noquater;
	}

	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\nMachine is ");
		if (state == soldout) {
			result.append("sold out");
		} else if (state == noquater) {
			result.append("waiting for quarter");
		} else if (state == hasquater) {
			result.append("waiting for turn of crank");
		} else if (state == soldState) {
			result.append("delivering a gumball");
		}
		result.append("\n");
		return result.toString();
	}
}


