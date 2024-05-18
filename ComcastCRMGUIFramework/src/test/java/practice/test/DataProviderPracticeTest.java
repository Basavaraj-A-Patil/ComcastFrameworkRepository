package practice.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderPracticeTest {

	@Test(dataProvider = "getDataFromExcel")
	public void dataProviderTest(String FirstName, String lastName){
		System.out.println(FirstName+"\t"+lastName);
	}

	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable, Throwable {
		ExcelUtility eLib = new ExcelUtility();
		Object[][] objArr = eLib.getDataFromDataProvider("DataProvider");
		return objArr;
	}
}
