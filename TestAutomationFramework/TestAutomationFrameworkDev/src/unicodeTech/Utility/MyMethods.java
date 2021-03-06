package unicodeTech.Utility;

import org.openqa.selenium.Keys;

import com.unicodetechnologies.xlsConnectivity.XLSDatatable_Connectivity;

import unicodeTech.BasePackage.BaseInit;

public class MyMethods extends BaseInit {

	public static void signIN(String username, String password) {

		verifyElement("lnk_logurselfin_linkText").click();
		verifyElement("ip_email_name").sendKeys(username);
		verifyElement("ip_pwd_name").sendKeys(password);
		verifyElement("btn_signIn_id").click();

	}

	public static void signOUT() {

		verifyElement("btn_logoff_xpath").click();
		verifyElement("btn_continue_logoff_id").click();

	}

	public static void searchProduct(String keyword) {

		verifyElement("ip_findKeyword_name").sendKeys(keyword);
		verifyElement("ip_findKeyword_name").sendKeys(Keys.ENTER);

		// checkTestSuiteExecutionMode(suite, "TestSuite", "Module2");

	}

	public static boolean checkTestSuiteExecutionMode(XLSDatatable_Connectivity data, String sheetName,
			String testSuiteID) {

		int rows = data.totalRow(sheetName);

		for (int row = 2; row <= rows; row++) {

			String testsuiteName = data.getData(sheetName, "TestSuiteID", row);

			if (testsuiteName.equalsIgnoreCase(testSuiteID)) {

				String exeMode = data.getData(sheetName, "Execution", row);

				if (exeMode.equalsIgnoreCase("y"))

					return true;
				else
					return false;

			}

		}
		return false;

	}

	public static boolean checkTestCaseExecutionMode(XLSDatatable_Connectivity data, String sheetName,
			String testCaseID) {

		int rows = data.totalRow(sheetName);

		for (int row = 2; row <= rows; row++) {

			String testcaseName = data.getData(sheetName, "TestCaseID", row);

			if (testcaseName.equalsIgnoreCase(testCaseID)) {

				String exeMode = data.getData(sheetName, "Execution", row);

				if (exeMode.equalsIgnoreCase("y"))

					return true;
				else
					return false;

			}

		}
		return false;

	}

	public static Object[][] getTestData(XLSDatatable_Connectivity data, String sheetName) {


		int cols = data.totalColumn(sheetName);
		int rows = data.totalRow(sheetName);
		
		Object myData[][] = new Object[rows-1][cols];
		
		for(int row=2;row<=rows;row++) {
			
			for(int col=0;col<cols;col++) {
				
				myData[row-2][col] = data.getData(sheetName, col, row);
			}
		}
		
		return myData;
		
		
	}
}
