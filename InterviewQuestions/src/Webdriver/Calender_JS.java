package Webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calender_JS {

	public static void main(String[] args) {
	
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://www.spicejet.com/");
		WebElement element = driver.findElement(By.xpath("//*[@id=\"flightSearchContainer\"]/div[4]/button"));
		
		String date="31-03-2018";
		
		selectDate(driver, element, date);
		
	}

	public static void selectDate(WebDriver driver, WebElement element, String date_val ) {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','" +date_val+"');", element);
	}
}