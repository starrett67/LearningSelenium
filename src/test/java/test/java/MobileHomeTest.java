package test.java;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;

import roomstogo.com.utils;
import roomstogo.com.home.Home;
import roomstogo.com.home.MobileNavigation;

@TestInstance(Lifecycle.PER_CLASS)
class MobileHomeTest {

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
	void MobileNavDrawerTest() {
		Home homePage = new Home(driver);

//		homePage.mobNav.clickNavLink(MobileNavigation.Links.CreditOptions,
//				"https://www.roomstogo.com/view/creditOptions.jsp");
//		homePage.mobNav.clickNavLink(MobileNavigation.Links.CustomerService,
//				"https://www.roomstogo.com/content/Customer-Service");
		homePage.mobNav.clickNavLink(MobileNavigation.Links.GiftCards,
				"https://www.roomstogo.com/product/adults/GIFT-CARD/83333333/");
//		homePage.mobNav.clickNavLink(MobileNavigation.Links.OrderStatus, "https://www.roomstogo.com/orderstatus/");
//		homePage.mobNav.clickNavLink(MobileNavigation.Links.StoreLocator, "https://www.roomstogo.com/storelocator/");
	}
	
	@AfterAll
	public void done() {
		driver.close();
	}

}
