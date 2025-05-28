package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentreporter 
	{
	public static ExtentReports generateExtentReport()
		{
		ExtentReports extentReport = new ExtentReports();
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\extentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Levis Test Report");
		sparkReporter.config().setDocumentTitle("E2E report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");	
		extentReport.attachReporter(sparkReporter);
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		FileInputStream fis;
		try
		{
			fis = new FileInputStream(configPropFile);
			configProp.load(fis);
		} 
		catch (Throwable e) 
		{
			e.printStackTrace();
		}
		extentReport.setSystemInfo("URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser", configProp.getProperty("browser"));
		return extentReport;
		}
}
