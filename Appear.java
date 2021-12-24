package week4.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Appear {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		 
		driver.get("http://www.leafground.com/pages/appear.html");
		
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 WebElement appear = driver.findElement(By.xpath("//button[@id='btn']/b[1]"));
		 
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		 
		 wait.until(ExpectedConditions.visibilityOf(appear));
		 
		 String text = driver.findElement(By.xpath("//button[@id='btn']/b[1]")).getText();
		 
		 
		 System.out.println(text);
		 
		
		 

	}

}
