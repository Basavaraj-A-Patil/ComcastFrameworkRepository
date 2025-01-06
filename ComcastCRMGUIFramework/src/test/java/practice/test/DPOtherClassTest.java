<<<<<<< HEAD
package practice.test;

import org.testng.annotations.Test;

public class DPOtherClassTest {
	@Test(dataProviderClass = DataProviderPracticeTest.class,dataProvider = "getDataFromExcel")
	public void dpTest(String FirstName, String lastName) {
		System.out.println(FirstName+"\t"+lastName);
	}
}
=======
package practice.test;

import org.testng.annotations.Test;

public class DPOtherClassTest {
	@Test(dataProviderClass = DataProviderPracticeTest.class,dataProvider = "getDataFromExcel")
	public void dpTest(String FirstName, String lastName) {
		System.out.println(FirstName+"\t"+lastName);
	}
}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
