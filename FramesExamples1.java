package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesExamples1 {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("http://leafground.com/pages/frame.html");
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.switchTo().frame(0);
			
			driver.findElement(By.id("Click")).click();
			
			File source = driver.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("./Screenshot/framesexamples1.png");
			
			FileUtils.copyFile(source, destination);
			
			driver.switchTo().defaultContent();
			
		    List<WebElement>frames = driver.findElements(By.tagName("iframe"));
		    
		    System.out.println(frames.size());
		    
		  //  String text = driver.findElement(By.tagName("h1")).getText();
		    
		   // System.out.println(text);
			
			
			
			
			

	}

}
