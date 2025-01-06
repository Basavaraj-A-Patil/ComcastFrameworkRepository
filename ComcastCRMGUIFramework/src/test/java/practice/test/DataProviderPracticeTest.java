<<<<<<< HEAD
package practice.test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {

	@Test(dataProvider = "getDataFromExcel")
	public void dataProviderTest(String FirstName, String lastName){
		System.out.println(FirstName+"\t"+lastName);
	}

	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet("DataProvider").getLastRowNum();
		int lastCellNum = wb.getSheet("DataProvider").getRow(0).getLastCellNum();

		Object[][] objArr = new Object[lastRowNum][lastCellNum];
		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				objArr[i][j] = wb.getSheet("DataProvider").getRow(i+1).getCell(j).toString();
			}
		}
		return objArr;
	}
}
=======
package practice.test;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {

	@Test(dataProvider = "getDataFromExcel")
	public void dataProviderTest(String FirstName, String lastName){
		System.out.println(FirstName+"\t"+lastName);
	}

	@DataProvider
	public Object[][] getDataFromExcel() throws Throwable {
		FileInputStream fis = new FileInputStream("./testData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int lastRowNum = wb.getSheet("DataProvider").getLastRowNum();
		int lastCellNum = wb.getSheet("DataProvider").getRow(0).getLastCellNum();

		Object[][] objArr = new Object[lastRowNum][lastCellNum];
		for (int i = 0; i < lastRowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				objArr[i][j] = wb.getSheet("DataProvider").getRow(i+1).getCell(j).toString();
			}
		}
		return objArr;
	}
}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
