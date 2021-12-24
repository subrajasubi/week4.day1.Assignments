package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertAppear {

	public static void main(String[] args) {
		
	WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/alertappear.html");
		
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		 
	     driver.findElement(By.id("alert")).click();
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 
		 wait.until(ExpectedConditions.alertIsPresent());
		 
		 driver.findElement(By.id("btn")).click();
		 
		 driver.switchTo().alert().accept();

	}

}
