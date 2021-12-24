package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextToBeChanged {

	public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/TextChange.html");
		
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		 
		 WebElement texttochange = driver.findElement(By.id("btn"));
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		 
		 wait.until(ExpectedConditions.textToBePresentInElement(texttochange,"Click Me!"));
		 
		 driver.findElement(By.id("btn")).click();
		 
		 driver.switchTo().alert().accept();

	}

}
