package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import POM.homePage;
import POM.searchPage;
import base.baseClass;

public class searchTest extends baseClass{
	
	homePage HomePage;
	searchPage SearchPage;
	
	@Test (priority = 1)
	public void searchByValidInput()
	{
		HomePage = new homePage(driver);
		SearchPage = new searchPage(driver);
		HomePage.validSearch(datafile.getProperty("searchValid"));
		String validmsg = SearchPage.validVerification();
		System.out.println(validmsg);
		Assert.assertTrue(validmsg.contains(datafile.getProperty("searchValidMessage")));
	}
	
	@Test(priority = 2)
	public void searchByInvalidInput()
	{
		HomePage = new homePage(driver);
		SearchPage = new searchPage(driver);
		HomePage.invalidSearch(datafile.getProperty("searchinvalid"));
		String invalidmsg = SearchPage.invalidVerification();
		System.out.println(invalidmsg);
		Assert.assertTrue(invalidmsg.contains(datafile.getProperty("searchInvalidMessage")));
	}
}
