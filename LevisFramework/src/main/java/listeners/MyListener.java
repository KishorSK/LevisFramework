package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import utilities.Extentreporter;
import utilities.screenShot;

public class MyListener implements ITestListener
{
	ExtentReports extentReport;
	ExtentTest extentTest;
	String testName;

	@Override
	public void onTestStart(ITestResult result) {
		testName =result.getName();
		extentTest = extentReport.createTest(testName); //write extentTest & ri8 click to create local variable. copy and paste as global variable
		extentTest.log(Status.INFO, testName+"Started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//String testName = result.getName();
		extentTest.log(Status.PASS, testName+"Got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//String testName = result.getName();
		
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance()); // to get driver from the respective testcase
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		String ssPath = screenShot.captureScreenshot(driver, testName);
		extentTest.addScreenCaptureFromPath(ssPath);
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testName + "Got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		//String testName = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testName+"Got skipped");
		//System.out.println(testName + "is skipped");
		//System.out.println(result.getThrowable());
	}

	@Override
	public void onStart(ITestContext context) 
	{
		extentReport=Extentreporter.generateExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
	            extentReport.flush();
	            String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReport.html";
	            File extentReport = new File(pathOfExtentReport);
	            try {
					Desktop.getDesktop().browse(extentReport.toURI());
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	}
	

