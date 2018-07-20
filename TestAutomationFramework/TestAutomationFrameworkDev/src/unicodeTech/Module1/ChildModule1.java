package unicodeTech.Module1;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.MyMethods;

public class ChildModule1 extends BaseInit{

	@BeforeSuite
	public void checkTestSuite() throws IOException {
		
		startUP();
		boolean result = MyMethods.checkTestSuiteExecutionMode(suite, "TestSuite", "Module1");
		
		if(!result) {
			
			throw new SkipException("Execution mode of the Module1 test suite is set to NO");
			
		}
	}
}
