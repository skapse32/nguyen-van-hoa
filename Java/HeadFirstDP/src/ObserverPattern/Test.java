package ObserverPattern;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData mData = new WeatherData();
		
		CurrentCoditionsDisplay mDisplay = new CurrentCoditionsDisplay(mData);
		
		mData.setMeasurementChanged(0.0f, 1.0f, 20f);
		mData.setMeasurementChanged(3.0f, 10.0f, 20.6f);
		
		mDisplay.unSubcrible();
		mData.setMeasurementChanged(3.0f, 10.0f, 20.6f);
	}

}
