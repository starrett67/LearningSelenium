package test.java.Desktop;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import roomstogo.com.utils;
import roomstogo.com.home.Home;
import roomstogo.com.home.TopNavigation;
import test.java.WebDriverHelper;

@TestInstance(Lifecycle.PER_CLASS)
class DesktopHomeTest {

	WebDriver driver;

	@BeforeAll
	public void init() {
		driver = WebDriverHelper.getWebDriver();
	}

	@BeforeEach
	public void navigateHome() {
		driver.get("https://www.roomstogo.com");
		utils.waitForPageToLoad(driver);
	}

	@Test
	void TopNavLinksTest() {
		Home homePage = new Home(driver);

		homePage.topNav.goToKidsSite();
		homePage.topNav.goToRoomsToGoSite();

		homePage.topNav.clickLink(TopNavigation.Links.CreditOptions,
				"https://www.roomstogo.com/view/creditOptions.jsp");
		homePage.topNav.clickLink(TopNavigation.Links.CustomerService,
				"https://www.roomstogo.com/content/Customer-Service");
		homePage.topNav.clickLink(TopNavigation.Links.GiftCards,
				"https://www.roomstogo.com/product/adults/GIFT-CARD/83333333/");
		homePage.topNav.clickLink(TopNavigation.Links.OrderStatus, "https://www.roomstogo.com/orderstatus/");
		homePage.topNav.clickLink(TopNavigation.Links.StoreLocator, "https://www.roomstogo.com/storelocator/");
	}

	@Test
	void FindBrokenLinksTest() throws InterruptedException {
		Home homePage = new Home(driver);

		List<WebElement> brokenLinks = homePage.findBrokenLinks();
		Assertions.assertEquals(brokenLinks.size(), 0);
	}

	@AfterAll
	public void done() {
		driver.close();
	}
}