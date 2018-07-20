package unicodeTech.Module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class BestsellerLinks extends ChildModule2{

	@BeforeTest
	public void checkTestCase() {
		
		boolean result = MyMethods.checkTestCaseExecutionMode(module2, "TestCase", this.getClass().getSimpleName());
		
		if(!result) {
			
			throw new SkipException("Execution mode of the test case is set to NO");
			
		}
	}
	
	@Test
	public void testBestsellerLinks() throws InterruptedException {
		
		driver.get(storage.getProperty("url"));
		
		WebElement bestsellers = driver.findElement(By.xpath("//*[@id='right_sidebar']/div[2]/div[2]/ol"));
		
		List<WebElement> bestsellerLinks = bestsellers.findElements(By.tagName("a"));
		
		int totalLinks = bestsellerLinks.size();
		
		for(int link=0;link<totalLinks;link++) {
			
			bestsellerLinks.get(link).click();
			//Thread.sleep(1000);
			logs.info(driver.findElement(By.xpath("//*[@id='content']/div[2]/form/div[1]/h1[2]")).getText());
			logs.info(driver.getTitle());
			logs.info(driver.getCurrentUrl());
			//Thread.sleep(1000);
			driver.navigate().back();
			bestsellers = driver.findElement(By.xpath("//*[@id='right_sidebar']/div[2]/div[2]/ol"));
			bestsellerLinks = bestsellers.findElements(By.tagName("a"));
			
		}
		
	}
}