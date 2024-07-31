package org.utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
    public static Actions a; 
    public static Robot r;
    public static Alert al;
    public static JavascriptExecutor js;
    public static Select s;
    public static TakesScreenshot tk;
	
    
//LAUNCHING WEB
    public static void launchedge() {
    WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();	
	}
    public static void launchchrome() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
	}
    
//MAXIMIZING WINDOW
	public static void winmax() {
    driver.manage().window().maximize();
	}
	
//PASSING URL,VALUES and PASSWORDS
	public static void passurl(String url) {
    driver.get(url);
	}
	public static void passvalues(WebElement ele,String val) {
    ele.sendKeys(val);
	}
	
	
//CLICK BUTTON
	public static void tap(WebElement ele) {
    ele.click();
	}

	
//ACTIONS
	public static void mousehover(WebElement ele) {
	a = new Actions(driver);
    a.moveToElement(ele);
    a.perform();
	}
	public static  void dragdrop(WebElement ele) {
	a = new Actions(driver);
    a.dragAndDrop(ele, ele);
    a.perform();
	}
    public static void upkey(WebElement ele) {
    a = new Actions(driver);
    a.keyUp(Keys.SHIFT );  //the key you want to press//
	a.perform();
    }
	public static void downkey(WebElement ele) {
	a = new Actions(driver);
    a.keyDown(Keys.SHIFT ); //the key you want to press// 
	a.perform();
	}
	public static void dbleclick(WebElement ele) {
	a = new Actions(driver);
    a.doubleClick(ele);
	a.perform();
	}
	public static void cntxtclick(WebElement ele) {
	a = new Actions(driver);
	a.contextClick(ele);
	a.perform();
	}
	
//ROBOT(customizable)
	public static void pressandreleasekey() throws AWTException{
    r = new Robot();
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
//ALERTS
	public static void acceptalert() {
    al = driver.switchTo().alert();
	al.accept();
	}
	public static void dismissalert() {
	al = driver.switchTo().alert();
    al.dismiss();
	}
	public static void gettingtext() {
	al = driver.switchTo().alert();
    al.getText();
	}
	
//JAVASCRIPTEXECUTOR
	public static void scrolldown(WebElement ele) {
    js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	public static void scrollup(WebElement ele) {
    js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].scrollIntoView(false);", ele);
	}
	
//HANDLING WINDOWS(single)	
    public  static void windowshandle() {
    String parentid = driver.getWindowHandle();
	Set<String> allids = driver.getWindowHandles();
    for (String eachid : allids) {
		if (parentid != eachid) {
			driver.switchTo().window(eachid);
		}
	}
    }

//HANDLING WINDOWS(multiple)    
    public static void windowshandlemultiple() {
    	String parentid = driver.getWindowHandle();
    	Set<String> allids = driver.getWindowHandles();
        for (String eachid : allids) {
    		int count = 0;
			if (count == 4) {
    			driver.switchTo().window(eachid);
    		}
    		count++;
    	}
        }
	
//DROPDOWN(customizable)   
    public static void dropdown(WebElement ele) {
    s = new Select(ele);
    s.selectByVisibleText("Electronics");
	}
    
//NAVIGATION(customizable)
    public static void navigateURL() {
    driver.navigate().to("https://www.flipkart.com/");
	}
    public static void back() {
    driver.navigate().back();
	}
    public static void forward() {
    driver.navigate().forward();
    }
    public static void refresh() {
    driver.navigate().refresh();
    }
	
//TAKING SCREENSHOT	
	public static void screenshot() throws IOException {
    tk = (TakesScreenshot)driver;
    File temp = tk.getScreenshotAs(OutputType.FILE);
    File dest = new File("C:\\Users\\suren\\eclipse-workspace\\MavenTesting1\\target\\screenshot1.png");
	FileUtils.copyFile(temp, dest);
	}
	
//CLOSE BUTTON
	public static void close() {
    driver.quit();
    }

//DATADRIVEN(reading data)
	public static String exceldata(String sheetname, int rowno, int cellno) throws IOException {
    File f = new File("C:\\Users\\suren\\eclipse-workspace\\MavenTesting1\\target\\Files\\FamilyTesting.xlsx");  
    FileInputStream fin = new FileInputStream(f);
    Workbook book = new XSSFWorkbook(fin);
    Sheet s = book.getSheet(sheetname);
    Row r = s.getRow(rowno);
    Cell c = r.getCell(cellno);
    int cellType = c.getCellType();
    String val="";
    if (cellType==1) {
		val = c.getStringCellValue();
	}
    else if (DateUtil.isCellDateFormatted(c)) {
		Date da = c.getDateCellValue();
        SimpleDateFormat smp = new SimpleDateFormat("dd/MMM/yyyy");
        val = smp.format(da);
    }
    else {
		double d = c.getNumericCellValue();
	    long l = (long)d;
        val = String.valueOf(l);
    }
    return val;
  	}
}    
    
    

