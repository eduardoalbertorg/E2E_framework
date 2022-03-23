package academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) {
		driver.get(prop.getProperty("baseUrl"));
		LandingPage landing = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		if(landing.isNoThanksButtonPresent()) {
			landing.getNoThanksButton().click();	
		}
		landing.getLogin().click();
		login.getEmail().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.getLoginButton().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		// Row is for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non restricted User";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Restricted user";
	
		return data;
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}

}
