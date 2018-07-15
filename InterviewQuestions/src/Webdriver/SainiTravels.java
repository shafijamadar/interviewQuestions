package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SainiTravels {
	
	
	
	public static void main(String [] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://sainitravels.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='onesignal-popover-cancel-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ctl00_MainContent_btnClose']")).click();
		
		//li[@ui-menu-item]
		WebElement fromtxt = driver.findElement(By.xpath("//*[@id='txtFromCity']"));
		fromtxt.click();
		
		WebElement amd = driver.findElement(By.xpath("//a[@id='ui-id-1414']")); 

		Actions action = new Actions(driver);
		action.moveToElement(amd).perform();
	
	}
	
	public static void selectDate(WebDriver driver, WebElement element, String date_val ) {

		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','" +date_val+"');", element);
	}

	
	
}
