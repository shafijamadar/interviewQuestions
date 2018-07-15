package Module16;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AjaxAutoSuggest {
	
	WebDriver driver;
	
	@Test
	public void autoSuggest(){
	System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("http://google.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(By.name("q")).sendKeys("hello");
	List<WebElement> ele = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
	
	System.out.println(ele.size());
	
	for(int i=0; i< ele.size();i++){
	
		System.out.println(ele.get(i).getText());
	}
	}
}
