package testCases;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.cartPage;
import POM.homePage;
import base.baseClass;

public class cartTest extends baseClass 
{
	homePage HomePage;
	cartPage CartPage;
	
	@Test
	public void verifyCartOpen()
	{
		HomePage = new homePage(driver);
		CartPage = new cartPage(driver);
		HomePage.clickOnCart();
		String carttxt =CartPage.CartVerification();
		System.out.println(carttxt);
		Assert.assertTrue(carttxt.contains("your cart"));
	}
	 //@AfterMethod
	    //public void tearDown() {
	      //  if (driver != null) {
	          //  driver.quit();
	        //}}
}
