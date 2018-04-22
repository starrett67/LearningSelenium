package test.java;


import java.net.MalformedURLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

import roomstogo.com.utils;
import roomstogo.com.home.Home;
import roomstogo.com.home.TopNavigation;

@TestInstance(Lifecycle.PER_CLASS)
class SeleniumTest {

	WebDriver driver;

	@BeforeAll
	public void init() throws MalformedURLException {
		WebDriverHelper helper = new WebDriverHelper();
		driver = helper.driver;
		driver.get("https://www.roomstogo.com");		
		utils.waitForPageToLoad(driver);
	}

	@Test
	void ValidateTopNav() {

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

	@AfterAll
	public void done() {
		driver.close();
	}
}
