package data.provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {
	
	static	WebDriver  driver;
	
	@Parameters({"url"})
	@Test
	public void browserlaunch(String s) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get(s);
		}
	
	@Parameters({"username","password"})
	@Test
	public void logIn(String s, String s1) {
		WebElement findElement = driver.findElement(By.id("email"));
		findElement.sendKeys(s);
		WebElement findElement2 = driver.findElement(By.id("pass"));
		findElement2.sendKeys(s1);
	}

}
