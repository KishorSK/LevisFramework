package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class screenShot {
	
	public static String captureScreenshot(WebDriver driver,String testName)
	{
		File srsScreenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\test-output\\screenshot\\ss"+testName+".png"; //folder
		try {
			FileHandler.copy(srsScreenshot, new File(dest));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dest;
	}
}
