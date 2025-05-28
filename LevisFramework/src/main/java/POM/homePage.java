package POM;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import action.ActionClass;

public class homePage {
	WebDriver driver;
	ActionClass actionUtils;
	
	@FindBy(xpath = "//input[@id='st-search']")
	WebElement SearchField;
	
	@FindBy(id = "cart-icon-bubble")
	WebElement CartIcon;
	
	@FindBy(xpath ="//div[@id='Details-HeaderMenu-2']//a[contains(text(),'MEN')]")
	WebElement Mens;
	
	@FindBy(xpath = "//ul[@id='HeaderMenu-SubMenuList-1']//a[contains(text(),'Jeans')][1]")
	WebElement MensJeans;
	
	public homePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.actionUtils = new ActionClass(driver);
	}
	
	public WebElement getMensJeans() {
		return MensJeans;
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
	
	public void mouseHoverMen()
	{
		actionUtils.mouseHover(Mens);
	}
	
}
