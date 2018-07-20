package unicodeTech.Module2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class ManufacturerSelection extends ChildModule2{

	@BeforeTest
	public void checkTestCase() {
		
		boolean result = MyMethods.checkTestCaseExecutionMode(module2, "TestCase", this.getClass().getSimpleName());
		
		if(!result) {
			
			throw new SkipException("Execution mode of the test case is set to NO");
			
		}
	}
	
	@Test
	public void testManufacturerSelection() throws InterruptedException {
		
		driver.get(storage.getProperty("url"));
		WebElement manufacturers = driver.findElement(By.name("manufacturers_id"));
		List<WebElement> manuValues = manufacturers.findElements(By.tagName("option"));
		
		int totalVal = manuValues.size();
		
		for(int count=0;count<totalVal;count++) {
			
			String manuName = manuValues.get(count).getText();
			
			if(manuName.equalsIgnoreCase("Samsung")) {
				
				manuValues.get(count).click();
				Thread.sleep(2000);
				logs.info(driver.getTitle());
				
				break;
			}
			
		}
	}
}
