<<<<<<< HEAD
package com.comcast.crm.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer {
	int count = 0;
	int limitcount = 1;

	public boolean retry(ITestResult result) {
		if (count < limitcount) {
			count++;
			return true;
		}
		return false;
	}
}
=======
package com.comcast.crm.generic.listenerutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer {
	int count = 0;
	int limitcount = 1;

	public boolean retry(ITestResult result) {
		if (count < limitcount) {
			count++;
			return true;
		}
		return false;
	}
}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
