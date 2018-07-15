package Module15;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FrameManagement {
	
	WebDriver driver;

//	@Test
	public void iframeManagement(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://timesofindia.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("/html/body/div[4]/div[2]/span/a[1]")).click();
		
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(totalFrames);
		for(int i=0;i<totalFrames;i++){
			driver.switchTo().frame(i);
			
			int s = driver.findElements(By.id("input_0")).size();
			System.out.println("Size " + s);
			
			if(s==0){
				driver.switchTo().defaultContent();
			}
			else
			{
				break;
			}
			// interact
			driver.findElement(By.id("input_0")).sendKeys("9856222");
			driver.switchTo().defaultContent();
		
		}
	//	driver.switchTo().frame(6);
	}
	
	@Test
	public void paytm(){

		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://paytm.com");
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div[3]/div")).click();
		int total = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println(total);
		
		for(int i=0; i< total;i++){
			driver.switchTo().frame(i);
			
			int s = driver.findElements(By.id("input_0")).size();
			if(s==0){
				driver.switchTo().defaultContent();
			}
			else{
				break;
			}
			driver.switchTo().defaultContent();
		}
		
	
		//driver.findElement(By.name("username")).sendKeys("98546");
		
	}
		
	@AfterMethod
	public void tearDown(){
		if(driver !=null){
	//		driver.quit();
		}
	}
}