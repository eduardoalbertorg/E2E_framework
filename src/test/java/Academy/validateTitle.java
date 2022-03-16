package academy;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import resources.Base;

public class validateTitle extends Base {
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage landing = new LandingPage(driver);
		String actualTitle = landing.getFeaturedCoursesTitle().getText();
		AssertJUnit.assertEquals(actualTitle, "Featured Courses");
		driver.quit();
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

}
