package unicodeTech.Module2;

import java.io.IOException;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import unicodeTech.BasePackage.BaseInit;
import unicodeTech.Utility.MyMethods;

public class ChildModule2 extends BaseInit{

	@BeforeSuite
	public void checkTestSuite() throws IOException {
		
		startUP();
		boolean result = MyMethods.checkTestSuiteExecutionMode(suite, "TestSuite", "Module2");
		
		if(!result) {
			
			throw new SkipException("Execution mode of the Module2 test suite is set to NO");
			
		}
	}
}
