package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPage {

	WebDriver driver;
	
	@FindBy(xpath = "//span[@class='st-summary-label']")
	WebElement validMessageVerification;
	
	@FindBy(xpath = "//h3[@class='st-no-result-txt-image-main-header']")
	WebElement invalidMessageVerification;
	
	public searchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	 public String validVerification() {
		 String validGetText = validMessageVerification.getText().toLowerCase();
		 return validGetText;
	 }
	 
	 public String invalidVerification() {
		 String invalidGetText = invalidMessageVerification.getText().toLowerCase();
		 return invalidGetText;
	 }
}
