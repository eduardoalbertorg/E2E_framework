package academy;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("baseUrl"));
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		LandingPage landing = new LandingPage(driver);
		AssertJUnit.assertTrue(landing.getNavBar().isDisplayed());
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
}
