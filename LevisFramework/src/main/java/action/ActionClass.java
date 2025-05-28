package action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionClass 
{
	WebDriver driver;
	Actions action;
	
	public ActionClass(WebDriver driver) {
		this.driver = driver;
		this.action = new Actions(driver);
	}
	
	public void mouseHover(WebElement element)
	{
		action.moveToElement(element).build().perform();
	}
	
}
