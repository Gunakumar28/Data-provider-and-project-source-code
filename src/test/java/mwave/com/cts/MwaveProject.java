package mwave.com.cts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import baseclass.libglobal.LibGlobal;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MwaveProject extends LibGlobal {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new  ChromeOptions();    
		options.addArguments("--disable notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.mwave.com.au/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			driver.findElement(By.xpath("//button[text()='No Thanks']")).click();
			
		} catch (Exception e) {
		}
		driver.findElement(By.xpath("//*[text()='Shop Deals &']//following::li[@class='hasChild']//child::b[text()='Laptops & Tablets']")).click();
		driver.findElement(By.xpath("//*[text()='Apple Macbooks']")).click();
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='price']"));
		for (int i = 0; i < findElements.size(); i++) {
			WebElement webElement = findElements.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
		WebElement findElement = driver.findElement(By.xpath("//a[text()='Apple 13-inch MacBook Air M1 7-Core GPU 8GB 256GB macOS - Silver']//preceding::p//span[text()='Add to cart']"));
		findElement.click();
		WebElement findElement2 = driver.findElement(By.xpath("//a[@id='miniBskt']"));
		Actions a = new Actions(driver);
		a.moveToElement(findElement2).perform();
		driver.findElement(By.xpath("//a[text()='View Cart (1 Item)']")).click();
		WebElement findElement3 = driver.findElement(By.xpath("//a[text()='CHECKOUT']"));
		findElement3.click();
		driver.findElement(By.xpath("//input[@id='EmailAddress']")).sendKeys("rathnark12@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Rathnark12");
		driver.findElement(By.xpath("//span[text()='Sign in and Checkout']")).click();
		driver.findElement(By.xpath("//div[text()='Select or create a shipping address']//following::a[@class='btnNormalPurple'][1]")).click();
		driver.findElement(By.xpath("//input[@id='4']")).click();
		driver.findElement(By.xpath("//a[@class='btnMain btnNormalPurple']")).click();
		driver.findElement(By.xpath("//p[text()='VISA / Mastercard / American Express']//preceding::input[@id='PaymentMethodSelector'][2]")).click();
		driver.findElement(By.xpath("//p[text()='PayPal']//following::a[text()='Continue'][1]")).click();
		driver.findElement(By.xpath("//a[@class='btnLargeYellow']")).click();
	
	}
}
