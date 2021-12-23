package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		
		    WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://jqueryui.com/sortable/");
			
			driver.manage().window().maximize();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 
			 driver.findElement(By.xpath("//p[text()='Reorder elements in a list or grid using the mouse.']")).click();
			 
			 driver.switchTo().frame(0);
			 
			 Actions builder = new Actions(driver);
			 
			 WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
			 
			 WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 5']"));
			 
			 Thread.sleep(2000);
			 
			 builder.clickAndHold(item1).clickAndHold(item2).perform();
			 
			 builder.clickAndHold(item1).clickAndHold(item2).release();

	}

}
