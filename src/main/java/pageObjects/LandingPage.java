package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin = By.cssSelector("a[href*='sign_in'");
	By noThanksButton = By.xpath("//button[contains(text(), 'NO THANKS')]");
	By featuredCoursesTitle = By.cssSelector(".text-center > h2");
	By navBar = By.cssSelector(".nav.navbar-nav>li>a");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}
	
	public WebElement getNoThanksButton() {
		return driver.findElement(noThanksButton);
	}
	
	public boolean isNoThanksButtonPresent() {
		return driver.findElements(noThanksButton).size() > 0;
	}
	
	public WebElement getFeaturedCoursesTitle() {
		return driver.findElement(featuredCoursesTitle);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
}
