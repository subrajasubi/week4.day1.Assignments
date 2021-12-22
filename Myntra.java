package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.myntra.com/");
		
		driver.manage().window().maximize();
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 
		 Actions builder = new Actions(driver);
		 
		 WebElement Men = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		 
		 builder.moveToElement(Men).perform();
		 
		 driver.findElement(By.xpath("//a[@data-reactid='41']")).click();
		 
		 String item = driver.findElement(By.className("title-count")).getText();
		 
		 System.out.println("No.of items : " +item);
		 
		 String attribute = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText();
		 
		 System.out.println(attribute);
		 
         String attribute1 = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText();
		 
		 System.out.println(attribute1);
		 
		 String str="(9062)";
		 
		 String replaceAll = str.replaceAll("[^0-9]", "");
		 
		 System.out.println(replaceAll);
		 
		 int parseInt = Integer.parseInt(replaceAll);
		 
		 System.out.println(parseInt);
		 
		 String str1 = "(67)";
		 
		 String replaceAll1 = str1.replaceAll("[^0-9]", "");
		 
		 int parseInt1 = Integer.parseInt(replaceAll1);
		 
		 System.out.println("The Calculated Result is :");
		 
		 System.out.println(parseInt1+parseInt);
		 
		 driver.findElement(By.className("brand-more")).click();
		 
		 driver.findElement(By.className("FilterDirectory-searchInput")).sendKeys("Duke");
		 
		 driver.findElement(By.xpath("//label[@class=' common-customCheckbox']//div[1]")).click();
		 
		 driver.findElement(By.xpath("//ul[@class='FilterDirectory-indices']/following-sibling::span[1]")).click();
		 
		 Thread.sleep(3000);
		 
		List<WebElement> Dukebrands = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		
		for (WebElement each : Dukebrands) {
			
			String text = each.getText();
			
			System.out.println(text);
		}
		
         Thread.sleep(2000);
		 
         Actions builder1 = new Actions(driver);
		
		WebElement sort = driver.findElement(By.xpath("//span[text()='Recommended']"));
		
		builder1.moveToElement(sort).perform();
		
		driver.findElement(By.xpath("//label[text()='Better Discount']")).click();
		
		String text = driver.findElement(By.xpath("(//div[@class='product-price'])[1]")).getText();
		
		System.out.println(text);
		
		driver.findElement(By.xpath("(//div[@class='product-sliderContainer'])[1]")).click();
		
	    Set<String> windowHandles = driver.getWindowHandles();
		
		List<String>handles = new ArrayList<String>(windowHandles);
		
		driver.switchTo().window(handles.get(1));
		
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./Screenshot/myntra1.png");
		
		FileUtils.copyFile(source, destination);
		
		driver.findElement(By.xpath("//div[contains(@class,'pdp-add-to-bag pdp-button')]/following-sibling::div[1]")).click();
		
		driver.quit();
			
		 
		 
		
			
		}
		 
		     
		 
		 
			

	}


