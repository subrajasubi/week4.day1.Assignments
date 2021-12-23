package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Erail {


	public static void main(String[] args) throws InterruptedException {
		
		    WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("https://erail.in/");
			
			driver.manage().window().maximize();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 
			 driver.findElement(By.id("chkSelectDateOnly")).click();
			 
			 WebElement train = driver.findElement(By.id("txtStationFrom"));
			 
			 train.clear();
			 
			 train.sendKeys("Chennai Egmore");
			 
			 driver.findElement(By.xpath("//div[@title='Chennai Egmore']")).click();
			 
			 WebElement dest = driver.findElement(By.id("txtStationTo"));
			 
			 dest.clear();
			 
			 dest.sendKeys("nagercoil");
			 
			 driver.findElement(By.xpath("//div[@title='Nagercoil Town']")).click();
			 
			 List<String> trainNameList = new ArrayList<String>();
			 
			 List<WebElement> trainnames = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
			 
			 int size = trainnames.size();
			 
			 System.out.println(size);
			    
			 Thread.sleep(2000);
			 
			 for (int i = 1; i <=size; i++) {
					
				   
				    String arrange = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]")).getText();
					
					trainNameList.add(arrange);
					
					Collections.sort(trainNameList );		
		
			 }
			 
			 System.out.println(trainNameList);
			 
			 Set<String>dup = new LinkedHashSet<String>(trainNameList );
			 
			 for (int i = 1; i <=size; i++) {
				 
				 String arrange1 = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr[" + i + "]/td[2]")).getText();
				 
				 System.out.println(arrange1);	 
			}
			 
			 int size1 = trainNameList.size();
			 
			 System.out.println(size1);
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
	}

}
