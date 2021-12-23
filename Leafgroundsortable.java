package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leafgroundsortable {

	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup();
			
			ChromeDriver driver = new ChromeDriver();
			
			driver.get("http://www.leafground.com/pages/sorttable.html");
			
			driver.manage().window().maximize();
			
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 
			 List<String> nameList = new ArrayList<String>();
				List<String> sortNameList = new ArrayList<String>();

				List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']/tbody/tr"));
				int totalRow = rows.size();

				for (int i = 1; i <= totalRow; i++)

				{
					String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[" + i + "]/td[2]")).getText();
					nameList.add(text);
					System.out.println(text);
				}
				Collections.sort(nameList);
				//Click on the Name header
				System.out.println(nameList);
				driver.findElement(By.xpath("//th[@aria-label=\"Name: activate to sort column ascending\"]")).click();
				
			//3.Again get all the values and store in a List
				for (int i = 1; i <= totalRow; i++)

				{
					String text = driver.findElement(By.xpath("//table[@id='table_id']/tbody/tr[" + i + "]/td[2]")).getText();
					sortNameList.add(text);
					System.out.println(text);
				}
				//Compare both the list
				
				if (nameList.equals(sortNameList))
				{
					System.out.println("Validation Complete");
				}
			 
//			 WebElement name = driver.findElement(By.xpath("(//th[@class='sorting'])[1]"));
//			 
//			 name.click();
//			 
//			 List<WebElement> names2 = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
//			 
//			 for (WebElement each2 : names2) {
//				
//				 String text2 = each2.getText();
//				 
//				 System.out.println(text2);
//				 
//				
//				
//			}
//			 
//			 System.out.println(names2.containsAll(table));
//			 
				 
				 
				 
				
			} 
}
				
				
	
	


