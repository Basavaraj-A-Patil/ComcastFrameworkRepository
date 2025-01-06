<<<<<<< HEAD
package com.comcast.crm.generic.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
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

	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO, result.getMethod().getMethodName() + " ==> Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + " ==> Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String date = new Date().toString().replace(' ', '_').replace(':', '_');
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath, testName + "_" + date);
		UtilityClassObject.getTest().log(Status.FAIL, testName + " ==> Failed");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());

		// to store in local
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/" + testName + "_" + date + ".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityClassObject.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " ==> Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		String date = new Date().toString().replace(' ', '_').replace(':', '_');
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/executionReport_" + date + ".html");
		spark.config().setDocumentTitle("V-Tiger");
		spark.config().setReportName("CRM execution report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("OS Version", System.getProperty("os.version"));
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
=======
package com.comcast.crm.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	ExtentReports report;

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		UtilityClassObject.getTest().log(Status.INFO,  result.getMethod().getMethodName()+" ==> Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		UtilityClassObject.getTest().log(Status.PASS,  result.getMethod().getMethodName()+" ==> Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String date = new Date().toString().replace(' ', '_').replace(':', '_');
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filepath = ts.getScreenshotAs(OutputType.BASE64);
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filepath,testName+"_"+date);
		UtilityClassObject.getTest().log(Status.FAIL, testName+" ==> Failed");
		UtilityClassObject.getTest().log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		UtilityClassObject.getTest().log(Status.SKIP,  result.getMethod().getMethodName()+" ==> Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		String date = new Date().toString().replace(' ', '_').replace(':', '_');
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/executionReport_" + date + ".html");
		spark.config().setDocumentTitle("V-Tiger");
		spark.config().setReportName("CRM execution report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", System.getProperty("os.name"));
		report.setSystemInfo("OS Version", System.getProperty("os.version"));
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

}
>>>>>>> branch 'master' of https://github.com/Basavaraj-A-Patil/ComcastFrameworkRepository
