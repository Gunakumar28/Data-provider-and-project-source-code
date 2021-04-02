package data.provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseclass.libglobal.LibGlobal;

public class FacebookLogInUsingDataProvider extends LibGlobal{
	
	
	
	@BeforeClass
	public void driverLaunch() {
		getDriver();
		
		
		

	}
	
	@Test(dataProvider="data",dataProviderClass=DataProviderMethods.class)
	private void testCase(String data, String data1) {
		launchUrl("https://www.facebook.com/");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys(data);
		driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(data1);
		
		
	}
	
}
