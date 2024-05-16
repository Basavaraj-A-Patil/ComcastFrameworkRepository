package com.comcast.crm.generic.listenerutility;
/**
 * @author Basavaraj
 * Contains listener implementation methods to Configure the report and capture screenshots
 * 
 */
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListnerImpClass implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite suite) {
		/* Report configuration */
		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("CRM document");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		/* System Info */
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
	}

	public void onFinish(ISuite suite) {
		/* Report Backup */
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		/* Create test inside extent report */
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + " ==> STARTED ");
	}

	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + " ==> PASSED ");
	}

	public void onTestFailure(ITestResult result) {
		/* Capture screenshot when script fails */
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(' ', '_').replace(':', '_');
		TakesScreenshot scr = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = scr.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath, testName + "_" + time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " ==> FAILED ");
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}
}
