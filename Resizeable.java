package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizeable {

	public static void main(String[] args) throws InterruptedException {
		
		   WebDriverManager.chromedriver().setup();
			
					ChromeDriver driver = new ChromeDriver();
					
					driver.get("https://jqueryui.com/resizable/");
					
					driver.manage().window().maximize();
					
					 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					 
					 driver.findElement(By.xpath("//h1[text()='Resizable']")).click();
					 
					 driver.switchTo().frame(0);
					 
					 Actions builder = new Actions(driver);
					 
					 Thread.sleep(2000);
					 
					 WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-s']/following-sibling::div[1]"));
					 
					 builder.dragAndDropBy(resize, 50,40).perform();
					 
					
					 
	}

}
