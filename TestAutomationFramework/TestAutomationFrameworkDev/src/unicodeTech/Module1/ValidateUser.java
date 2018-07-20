package unicodeTech.Module1;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class ValidateUser extends ChildModule1{

	@BeforeTest
	public void checkTestCase() {
		
		boolean result = MyMethods.checkTestCaseExecutionMode(module1, "TestCase", this.getClass().getSimpleName());
		
		if(!result) {
			
			throw new SkipException("Execution mode of the test case is set to NO");
			
		}
	}
	
	@Test(dataProvider="getTestDataFromXLS")
	public void testValidateUser(String email, String password) throws InterruptedException {
		
		driver.get(storage.getProperty("url"));
		MyMethods.signIN(email, password);
		Thread.sleep(2000);
		MyMethods.signOUT();
		
		
	}	
	
	@DataProvider
	public Object[][] getTestDataFromXLS() {
		
		return MyMethods.getTestData(module1, "ValidateUser");
		
	}
	
	
	
	
	
	
	
	
	
	
	
}