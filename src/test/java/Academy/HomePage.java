package Academy;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	
	@Test
	public void basePageNavigation() throws IOException {
		driver = initializeDriver();
		driver.get("http://qaclickacademy.com");
		LandingPage landing = new LandingPage(driver);
		LoginPage login = new LoginPage(driver);
		landing.getNoThanksButton().click();
		landing.getLogin().click();
		login.getEmail().sendKeys("abc@qw.com");
		login.getPassword().sendKeys("12345");
		login.getLoginButton().click();
	}

}
