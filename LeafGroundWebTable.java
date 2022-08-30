package handlingalerts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWebTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/table.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("Ber");
		// WebElement table =
		// driver.findElement(By.xpath("//table[@role='grid']/tbody"));

		Thread.sleep(3000);

		String text = driver.findElement(By.xpath("//table[@role='grid']/tbody/tr[2]/td")).getText();
		System.out.println(text);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr"));
		int rsize = rows.size();
		System.out.println("row size is " + rsize);

		List<WebElement> col = driver.findElements(By.xpath("//table[@role='grid']/tbody/tr[2]/td"));
		int csize = col.size();
		System.out.println("col size is " + csize);

		System.out.println("****************************");
		System.out.println("To get a particular col value");
		List<String> ListOfName=new ArrayList<String>();
		for (int i = 1; i <= rsize; i++) {
			String Col2Val = driver.findElement(By.xpath("//table[@role='grid']//tr[" + i + "]/td[1]")).getText();
			//System.out.println(Col2Val);
			ListOfName.add(Col2Val);
		}
		System.out.println(ListOfName);
		
		
		System.out.println("****************************");
		System.out.println("To get a particular row value");

		for (int i = 1; i <= csize; i++) {
			String row2Val = driver.findElement(By.xpath("//table[@role='grid']//tr[1]/td[" + i + "]")).getText();
			System.out.println(row2Val);
		}
		System.out.println("****************************");
		System.out.println("To get all the table values");

		for (int i = 1; i <= rsize; i++) {
			for (int j = 1; j <= csize; j++) {
				String allValues = driver.findElement(By.xpath("//table[@role='grid']//tr[" + i + "]/td[" + j + "]"))
						.getText();
				System.out.println(allValues);
			}		}
		System.out.println("****************************");
		
		List<String> sortedNames=new ArrayList<String>();

		driver.findElement(By.xpath("//th[@class='ui-state-default ui-sortable-column ui-filter-column']")).click();
		for (int i = 1; i <= rsize; i++) {
			Thread.sleep(2000);
			String names = driver.findElement(By.xpath("//table[@role='grid']//tr[" + i + "]/td[1]")).getText();
		//	System.out.println(names);
			
			sortedNames.add(names);
		}
		
		System.out.println(sortedNames);
		if(ListOfName.equals(sortedNames)) {
			System.out.println("Values are not sorted");
		}
		else {
			System.out.println("values are sorted");
		}
	}

}
