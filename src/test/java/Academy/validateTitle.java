package academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("baseUrl"));
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		LandingPage landing = new LandingPage(driver);
		String actualTitle = landing.getFeaturedCoursesTitle().getText();
		AssertJUnit.assertEquals("featured courses", actualTitle.toLowerCase());
	}
	
	@DataProvider
	public Object[][] getData() {
		// Row is for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[1][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		return data;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
