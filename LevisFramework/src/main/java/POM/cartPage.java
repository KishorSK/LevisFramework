package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cartPage {
	WebDriver driver;

	@FindBy(xpath = "//h3[contains(text(),'Your cart')]")
	WebElement cartText;
	
	public cartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String CartVerification()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String carttext =cartText.getText().toLowerCase();
		wait.until(ExpectedConditions.visibilityOf(cartText));
		return carttext;
	}
}
