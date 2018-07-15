package Module15;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionsMoveToElement {
	
	WebDriver driver = null;
	
//	@Test
	public void moveToElement(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.americangolf.co.uk/club-page");
	//	driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement glofclub = driver.findElement(By.xpath("//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
		
		Actions action = new Actions(driver);
		action.moveToElement(glofclub).build().perform();
		
		WebElement putters = driver.findElement(By.xpath("//*[@id='CLUBS_1']/ul/li[3]/ul/li/a/span[1]"));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(putters));
		
		putters.click();
	}
	
	//@Test
	public void dragable(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/draggable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(totalFrames);
		
		driver.switchTo().frame(0);
		
		WebElement dragable = driver.findElement(By.id("draggable"));
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(dragable, 100, 100).build().perform();
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void dropable(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\a\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		System.out.println(totalFrames);
		
		driver.switchTo().frame(0);
		
		WebElement src = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).build().perform();
		driver.switchTo().defaultContent();
	}
}