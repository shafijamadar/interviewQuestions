package Webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicChangingElement {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver	driver = new ChromeDriver();
		driver.get("https://www.google.co");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.id("lst-ib")).sendKeys("Java");
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));
		
	//	li[@ui-menu-item]
		System.out.println("Total number of suggestions in the search box====>" +list.size()); 
		
		for(int i=0; i< list.size();i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("java tutorial")){
				list.get(i).click();
				break;
			}
		}
	}
}
