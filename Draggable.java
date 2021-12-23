package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/draggable/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//h1[text()='Draggable']")).click();
	
		driver.switchTo().frame(0);
		
		Actions builder = new Actions(driver);
	    	
		WebElement drag = driver.findElement(By.xpath("//p[text()='Drag me around']"));
	
        Thread.sleep(2000);
        
		builder.dragAndDropBy(drag ,100,150).perform();
	
		
		

	}

}
