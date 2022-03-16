package academy;

import java.io.IOException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavigationBar extends Base {
	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("baseUrl"));
		LandingPage landing = new LandingPage(driver);
		AssertJUnit.assertTrue(landing.getNavBar().isDisplayed());
		driver.quit();
	}
}
