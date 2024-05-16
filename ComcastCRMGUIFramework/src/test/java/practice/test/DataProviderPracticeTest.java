package practice.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderPracticeTest {
	@Test(dataProvider = "getData")
	public void dptest(String firstname, String lastname) {
		System.out.println("FirstName:" + firstname + "\t\t" + "LastName:" + lastname);
	}

	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib = new ExcelUtility();
		int rowCount = eLib.getRowCountOfSheet("DataProvider");

		Object[][] objArr = new Object[rowCount][2];
		for (int i = 0; i < rowCount; i++) {
			objArr[i][0] = eLib.getDataFromExcelFile("DataProvider", i + 1, 0);
			objArr[i][1] = eLib.getDataFromExcelFile("DataProvider", i + 1, 1);
		}
		return objArr;
	}
}
