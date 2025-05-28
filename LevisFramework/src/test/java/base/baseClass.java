package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class baseClass {
	
	public  WebDriver driver;
	public Properties prop;
	public Properties datafile;
	
	public void loadPropertiesFile()
	{
		datafile = new Properties();
		File datafileprop = new File(System.getProperty("user.dir")+"\\src\\main\\java\\datafile\\datafile.properties");
		try {
			FileInputStream datafis = new FileInputStream(datafileprop);
			datafile.load(datafis);
		}
		catch(Throwable e){
			e.printStackTrace();
		}
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		
	}
	@BeforeMethod
	public void LaunchSite(ITestResult result)
	{
		loadPropertiesFile();
		String browserName = prop.getProperty("browser").toLowerCase();
		if	(browserName.equals("chrome"))
		{	
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get(prop.getProperty("url"));
		}
		else if (browserName.equals("FireFox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browserName.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		 //result.setAttribute("WebDriver", driver);
		//return driver;
	}
	
	 
	@AfterMethod
	public void tearDown() {
	      if (driver != null) {
	           driver.quit();}}
}
