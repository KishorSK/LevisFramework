package POM;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='st-search']")
	WebElement SearchField;
	
	@FindBy(id = "cart-icon-bubble")
	WebElement CartIcon;
	
	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCart() {
		CartIcon.click();
	}
	
	public void validSearch(String valid) {
		SearchField.sendKeys(valid);
	}
	
	public void invalidSearch(String invalid) {
		SearchField.sendKeys(invalid);
	}
	
}
