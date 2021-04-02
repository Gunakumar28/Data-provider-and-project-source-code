package data.provider;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
	
	@DataProvider(name ="data")
	public Object[] [] getData(){
		return new Object[] [] {{"guna","12345"},{"ram","5556556"}};
		
		
	}

}
