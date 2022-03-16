package Academy;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage landing = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		landing.getNoThanksButton().click();
		landing.getLogin().click();
		login.getEmail().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		login.getLoginButton().click();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getData() {
		// Row is for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456788";
		data[1][2] = "Non restrictec user";
		return data;
	}

}
