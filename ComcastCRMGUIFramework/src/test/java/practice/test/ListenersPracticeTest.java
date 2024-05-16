package practice.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.generic.listenerutility.ListnerImpClass.class)
public class ListenersPracticeTest extends BaseClass {
	@Test(retryAnalyzer = com.comcast.crm.generic.listenerutility.RetryListenerImp.class)
	public void test1() {
		System.out.println("==START==>test1");

	}
}
