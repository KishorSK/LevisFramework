package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionClass;

public class plp {
	WebDriver driver;
	ActionClass actionUtils;
	public plp(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.actionUtils = new ActionClass(driver);
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Men Jeans')]")
	WebElement MenjeansHeading;
	
	public String getHeadingName() {
		String heading = MenjeansHeading.getText();
		return heading;
	}
}
