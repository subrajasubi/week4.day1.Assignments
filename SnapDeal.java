package week4.day2.assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException {

		  WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://www.snapdeal.com/");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
            Actions builder = new Actions(driver);
			
			WebElement men = driver.findElement(By.linkText("Men's Fashion"));
			
			builder.moveToElement(men).perform();
			
			driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
			
			String items = driver.findElement(By.xpath("//h1[@class='category-name']")).getText();
			
			System.out.println(items);
			
			driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
			
			driver.findElement(By.xpath("//span[text()='Sort by:']/following-sibling::i")).click();
			
			driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
			
			Thread.sleep(3000);
			
			List<WebElement> sort = driver.findElements(By.xpath("//p[@class='product-title']"));
			
			System.out.println("Shoe Names : " + "\n");
			
			for (WebElement each : sort) {
				
             	String names = each.getText();
				
				System.out.println(names);
			}
			
            WebElement price = driver.findElement(By.name("fromVal"));
            
            price.clear();
            
            price.sendKeys("900");
            
            WebElement price2 = driver.findElement(By.name("toVal"));
            
            price2.clear();
            
            price2.sendKeys("1200");
            
            driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
            
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("(//button[text()='View More '])[1]")).click();
            
            driver.findElement(By.xpath("//label[@for='Color_s-Navy']")).click();
            
            String text = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]")).getText();
            
            System.out.println("Filters Applied : Price :  " +text);
            
            String text2 = driver.findElement(By.xpath("//a[@data-key='Color_s|Color']")).getText();
            
            System.out.println("Colour : " +text2);
            
            Actions builder1 = new Actions(driver);
			
			WebElement brands = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			
			builder1.moveToElement(brands).perform();
			
			driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
			
			String text3 = driver.findElement(By.xpath("//span[text()='1,049 ']")).getText();
			
			System.out.println("Total : " +text3);
			
            String text4 = driver.findElement(By.xpath("//span[text()='1,049 ']/following-sibling::span")).getText();
			
			System.out.println("Discount : " +text4);
			
			driver.quit();
			
			
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
	}

}
