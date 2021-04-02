package baseclass.libglobal;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	
	public static  WebDriver driver;
	//1
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\intel\\eclipse-workspace\\mavenDay1\\Driver\\chromedriver.exe");
		driver =new ChromeDriver();
		}
	//2
	public static void launchUrl(String data) {
		driver.get(data);
		}
	//3
	public void txtUserName(WebElement element,String data) {
		element.sendKeys(data);
		}
	//4
	public void txtPassword(WebElement element,String data) {
		element.sendKeys(data);
		}
	//5
	public void btnClick(WebElement element) {
		element.click();
		}
	
	public static  void sendkey(WebElement data1,String data2) {
		data1.sendKeys(data2);
		
		}
	
	//6
	public static void close() {
		driver.close();
	}
	//7
	public void geText(WebElement element) {
		element.getText();
		}
	//8
	public String getAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
		return attribute;	
		}
	
	
	//9
	public void timeOut (int data) throws InterruptedException {
		Thread.sleep(data);
		}
	//10
	public void navigateUrl(String data) {
		driver.navigate().to(data);
		}
	//11
	public String getTittleOfWebpage(String data) {
		return driver.getTitle();
	}
	//12
	public String getCurrentUrlOfWebpage(String data) {
		return driver.getCurrentUrl();
		
		}
	//13
	public  void maximizeWindow() {
		driver.manage().window().maximize();
		}
	//ACTIONS
	//MOSEOVER ACTION
	public void mouseOverAction(WebElement element) {
		Actions action =  new Actions(driver);
		action.moveToElement(element).perform();
		}
	//15
	public void dragAndDrop(WebElement data,WebElement data1) {
	 Actions action = new Actions(driver);
	 action.dragAndDrop(data, data1).perform();
	 }
	//16
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		}
	//
	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		}
	//18
	
	
	
	//SELECT CLASS
	//19
	//select value
	public void selectParticularValue(WebElement element, String data) {
		Select select = new Select(element);
		select.selectByValue(data);
	}
	
	//select by visible txt
	public void selectVisibleText(WebElement element,String data) {
		Select select =  new Select(element);
		select.selectByVisibleText(data);
	}
	
	
	//selectbyindex
	public void selectByIndex(WebElement element,int data) {
		Select select  = new Select(element);
		select.selectByIndex(data);
	}
		
	//deSelectByIndex
		public void deSelectByIndex(WebElement element,int data) {
			Select select = new Select(element);
			select.deselectByIndex(data);
		}
		
	//deSelectByValue
		public void deSelectByValue(WebElement element,String data) {
			Select select = new Select(element);
			select.deselectByValue(data);
			}
		
	//deSelectByVisibletext
		public void deSelectByVisibletext(WebElement element,String data) {
			Select select = new Select(element);
			select.deselectByVisibleText(data);
			}
		//deSelectAll
		public void deSelectAll(WebElement element) {
			Select select = new Select(element);
			select.deselectAll();			
		}
		
		//getOptions
		public  List<WebElement> getOptions(WebElement element) {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			 return options;
		}
		
		//getFirstSelectOption
		public WebElement getFirstSelectOption(WebElement element) {
			Select select = new Select(element);
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			return firstSelectedOption;
		}
		
		//isMultiple
		public boolean isMultiple(WebElement element) {
	     Select select = new  Select(element);
	     boolean multiple = select.isMultiple();
	     return multiple;
	     }
		
		//getAllSelectedOptions
		public List<WebElement> getAllSelectedOptions(WebElement element) {
			Select select = new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			return allSelectedOptions;
			}
		
		//ALERT
		
		//SIMPLE ALERT
		public void okAlert() {
			Alert alert =driver.switchTo().alert();
			alert.accept();
			}
		
		//Dismis ALERT
		public void cancelAlert() {
			Alert alert =  driver.switchTo().alert();
			alert.dismiss();
		}
		
		//sendkeysAlert
		public void sendkeysAlert(String data) {
			Alert  alert = driver.switchTo().alert();
			alert.sendKeys(data);
			
		}
		
		//GET TXT  USING ALERT
		public String getTextAlert() {
		Alert alert =  driver.switchTo().alert();
		String text = alert.getText();
		return text;
		}
		
		//JavaScript Executor
		//setattribute
		public void insertValue(WebElement element, String data ) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setattribute('value','data')",element);
			}
		
		//click javaScriptExecutor
		public void click(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()",element);

		}
		
		//getValue
		public void getText(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].getAttribute('value')",element);
			}
		//scrollDown
		public void scrollDown(WebElement string) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoview(true)", string);

		}
		//ScrollUp
		public void scrollUp(WebElement string) {
			JavascriptExecutor executor= (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(false)", string);

		}
		
		//SCREENSHOT 
		public void screenshotFile() {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			screenshot.getScreenshotAs(OutputType.FILE);
			
		}
		
		//DataDriven
		
		public String readValueFromExcel(String path,String sheetno,int rownum,int cellnum) throws IOException {
			File file = new File(path);
			FileInputStream fileInputStream = new FileInputStream(file);
			Workbook workbook = new  XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheet(sheetno);
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			int cellType = cell.getCellType();
			String value;
			if (cellType==1) {
				value = cell.getStringCellValue();
				}
			else if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				value = dateFormat.format(dateFormat);
				}
			else {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
				
			}
			
			return value;

		}
		//Robot Class
		//Ctrl A
		public void controlAll(WebElement element) throws AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_A);
			
			
		}
		
		//Down key
		public void downKey() throws AWTException {
		Robot robot = new Robot();;
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
			

		}
		//Enter
		public void enterkey() throws AWTException {
			Robot robot = new Robot();;
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		}
		
		
		
		//find element
		
		public void findelement(String data) {
			WebElement findElement = driver.findElement(By.xpath(data));

		}
		//findElements
		public void findelements(String data) {
			List<WebElement> findElements = driver.findElements(By.xpath(data));
			for (int i = 0; i < findElements.size(); i++) {
				WebElement webElement = findElements.get(i);
				String attribute = webElement.getText();
				System.out.println(attribute);
			}
			
			
			

		}
		//scrollDown
		public void scrollDown(String string) {
			// TODO Auto-generated method stub
			
		}
		
		//List
		List <String>li= new ArrayList<String>();
		//Create Excel sheet 



		public void readAndWriteValueFromExcel(String path, String sheetname,int rowNo,int cellNo) throws IOException {

			File file  = new File(path);
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet createSheet = workbook.createSheet(sheetname);
			Row createRow = createSheet.createRow(rowNo);
			
			
			
	for (int i = 0; i < li.size(); i++) {
				
				Cell createCell = createRow.createCell(i);
				createCell.setCellValue(li.get(i));
				}
			
			FileOutputStream fo= new FileOutputStream(file);
			workbook.write(fo);
			
}
		
		
					
					

			
			//Robot Class
			public void controlC() throws AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_C);
			}		
		
		//assert Equals methed
			public void assertEqualsMethod(WebElement element,String data) {
			Assert.assertEquals(getAttribute(element), data);
				
				
			}
			
			
			
			
				

			}
			
			

		
		


