package ObserverPattern;

public class CurrentCoditionsDisplay implements Observer, DisplayElement {

	private float humidity;
	private float pressure;
	private Subject mData;

	public CurrentCoditionsDisplay(Subject mData) {
		super();
		// TODO Auto-generated constructor stub
		this.mData = mData;
		mData.registerObserver(this);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("CurrentCoditionsDisplay [humidity=" + humidity
				+ ", pressure=" + pressure + "%]");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.humidity = humidity;
		this.pressure = pressure;
		display();

	}
	
	public void unSubcrible(){
		mData.removeObserver(this);
	}

}
