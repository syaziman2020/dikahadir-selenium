package com.dikahadir_selenium.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.dikahadir_selenium.testBase.BaseClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {

	public ExtentReports extent;
	public ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	String reportName;

	@Override
	public void onStart(ITestContext context) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report-" + timestamp + ".html";

		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + reportName);

		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Application", "Dikahadir");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = context.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", (os != null) ? os : "Unknown");

		String browser = context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", (browser != null) ? browser : "Unknown");
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		String methodName = result.getMethod().getMethodName();

		String testName;

		if (testDescription != null && !testDescription.isEmpty()) {
			testName = String.format("%s [%s]", methodName, testDescription);
		} else {
			testName = methodName;
		}

		test = extent.createTest(testName);

		test.assignCategory(result.getMethod().getGroups());
		result.setAttribute("extentTest", test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTest extentTest = (ExtentTest) result.getAttribute("extentTest");
		extentTest.log(Status.PASS, result.getMethod().getMethodName() + " berhasil dieksekusi.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest extentTest = (ExtentTest) result.getAttribute("extentTest");

		extentTest.log(Status.FAIL, "Test Case Gagal: " + result.getMethod().getMethodName());
		extentTest.log(Status.FAIL, "Penyebab Kegagalan: " + result.getThrowable().getMessage());

		try {
			Object testClassInstance = result.getInstance();

			BaseClass base = (BaseClass) testClassInstance;

			WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");

			String imagePath = base.captureScreen(driver, result.getMethod().getMethodName());

			extentTest.addScreenCaptureFromPath(imagePath, result.getMethod().getMethodName());

		} catch (Exception e) {
			extentTest.log(Status.FAIL, "Gagal mengambil screenshot: " + e.getMessage());
//            e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTest extentTest = (ExtentTest) result.getAttribute("extentTest");
		extentTest.log(Status.SKIP, "Test Case Dilewati: " + result.getMethod().getMethodName());
	}

	@Override
	public void onFinish(ITestContext context) {
		if (extent != null) {
			// flush() wajib dipanggil untuk menulis semua data ke file laporan
			extent.flush();
		}
	}
}
