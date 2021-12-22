package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
        WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		 
		 search.sendKeys("oneplus 9 pro ");
		 
		 search.sendKeys(Keys.ENTER);
		 
		 System.out.println("OnePlus Pro Price : " +driver.findElement(By.xpath("(//span[text()='69,999'])[1]")).getText());
		 
		 System.out.println(driver.findElement(By.xpath("//a[@href='javascript:void(0)']//i")).getText());
		 
		
		 
		 driver.findElement(By.xpath("(//i[@class='a-icon a-icon-star-small a-star-small-4-5 aok-align-bottom'])[1]")).click();
		 
		
		 
		 String text = driver.findElement(By.xpath("(//a[@title=\"65% of reviews have 5 stars\"])[1]")).getText();
		 
		 System.out.println(text);
		 
		 driver.findElement(By.xpath("//span[text()='OnePlus 9 Pro 5G (Morning Mist, 12GB RAM, 256GB Storage)']")).click();
		 
		 Set<String> windowHandles = driver.getWindowHandles();
			
			List<String>handles = new ArrayList<String>(windowHandles);
			
			driver.switchTo().window(handles.get(1));
			
			Thread.sleep(2000);
			
            File source = driver.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("./Screenshot/amazon.png");
			
			FileUtils.copyFile(source, destination);
			
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']")).click();
			
			driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button']")).click();
			
			String subTotal = driver.findElement(By.xpath("//span[contains(@id,'sc-subtotal-amount-activecart')]")).getText();
			
			System.out.println(subTotal);
			
			subTotal=subTotal.replaceAll(".","");

	}

}
