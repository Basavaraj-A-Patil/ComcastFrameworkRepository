package practice.test;

import org.testng.annotations.Test;

public class DPOtherClassTest {
	@Test(dataProviderClass = DataProviderPracticeTest.class,dataProvider = "getDataFromExcel")
	public void dpTest(String FirstName, String lastName) {
		System.out.println(FirstName+"\t"+lastName);
	}
}
