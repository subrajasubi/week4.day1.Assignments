package assignmentWeek4;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDrag {
	

	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
	      ChromeDriver driver=new ChromeDriver();
	      driver.get("https://www.leafground.com/drag.xhtml");
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     WebElement drag = driver.findElement(By.id("form:conpnl_content"));
	     Point location = drag.getLocation();
	     int x = location.getX();
	     int y = location.getY();
	     Actions builder = new Actions(driver);
	     builder.dragAndDropBy(drag,x, y).perform();
	     WebElement drop = driver.findElement(By.id("form:drag_content"));
	     WebElement drop2 = driver.findElement(By.id("form:drop_header"));
	     builder.dragAndDrop(drop, drop2).perform();
	     String cssValue = driver.findElement(By.id("form:drop_content")).getCssValue("background-color");
	     System.out.println(cssValue);
	     if (cssValue.contains("rgb(0, 113, 188,1)")) {
			System.out.println("Element dropped");
		}
	     else {
	    	 System.out.println("Element not dropped");
	     }
	     WebElement column = driver.findElement(By.id("form:j_idt94:j_idt95"));
	     WebElement column1 = driver.findElement(By.id("form:j_idt94:j_idt97"));
	     WebElement column2 = driver.findElement(By.id("form:j_idt94:j_idt99"));
	     builder.dragAndDrop(column, column1).perform();
	     WebElement onst = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr[2]"));
	     WebElement twod = driver.findElement(By.xpath("(//table[@role='grid'])[2]//tr[5]"));
	     builder.clickAndHold(twod).perform();
	     Thread.sleep(5000);
	     builder.clickAndHold(onst).release().perform();
	     Thread.sleep(3000);
	     WebElement resizedrag = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable')]"));
	     builder.dragAndDropBy(resizedrag, 50, 10).perform();
	     WebElement imagetext = driver.findElement(By.xpath("//span[text()='Image resized']"));
	     String text = imagetext.getText();
	     if (text.contains("Image")) {
			System.out.println("success");
		}
	     else {
	    	 System.out.println("Not success");
	     }
	     
//	     
//	     
	     
	     
	     
	      
	      
        }}
	

