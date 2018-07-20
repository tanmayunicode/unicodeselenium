package unicodeTech.Module1;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import unicodeTech.Utility.MyMethods;

public class SearchTest extends ChildModule1 {

	@BeforeTest
	public void checkTestCase() {
		
		boolean result = MyMethods.checkTestCaseExecutionMode(module1, "TestCase", this.getClass().getSimpleName());
		
		if(!result) {
			
			throw new SkipException("Execution mode of the test case is set to NO");
			
		}
	}
	
	@Test
	public void testValidateUser() throws InterruptedException {

		driver.get(storage.getProperty("url"));
		MyMethods.signIN("demo@unicodetechnologies.in", "unicode");
		Thread.sleep(2000);

		MyMethods.searchProduct("headphones");

		MyMethods.signOUT();
	}
}
