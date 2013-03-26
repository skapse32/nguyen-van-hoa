package ObserverPattern;

import java.util.ArrayList;

public class WeatherData implements Subject{

	private ArrayList<Observer> observers;
	private float temp;
	private float pressure;
	private float humidity;
	
	public WeatherData() {
		super();
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObserver() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); i++) {
			Observer ob = observers.get(i);
			ob.update(temp, humidity, pressure);
		}
	}

	public void measurementChanged(){
		notifyObserver();
	}

	public void setMeasurementChanged(float temp,float humidity, float pressure){
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		notifyObserver();
	}
	
}
