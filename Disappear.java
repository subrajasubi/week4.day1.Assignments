package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Disappear {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/disapper.html");
		
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		 
		 WebElement disappear = driver.findElement(By.id("btn"));
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 
		 wait.until(ExpectedConditions.invisibilityOf(disappear));
		 
		 String text = driver.findElement(By.tagName("strong")).getText();
		 
		 System.out.println(text);

	}

}
