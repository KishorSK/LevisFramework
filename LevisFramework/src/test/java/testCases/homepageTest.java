package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import POM.homePage;
import POM.plp;
import base.baseClass;

public class homepageTest extends baseClass{
	homePage HomePage;
	plp Plp;
	
	@Test
	public void megamenuMenJeans() {
		HomePage = new homePage(driver);
		Plp = new plp(driver);
		HomePage.mouseHoverMen();
		HomePage.getMensJeans().click();
		String actual = Plp.getHeadingName();
		String expected = "Men Jeans";
		Assert.assertEquals(actual.trim().toLowerCase(),expected.trim().toLowerCase(), "Wrong collection");
	}
}
