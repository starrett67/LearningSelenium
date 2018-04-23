package test.java;


import java.net.MalformedURLException;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import roomstogo.com.utils;
import roomstogo.com.home.Home;
import roomstogo.com.home.TopNavigation;

@TestInstance(Lifecycle.PER_CLASS)
@RunWith(DataProviderRunner.class)
class SeleniumTest {

	WebDriver driver;

	@BeforeAll
	public void init() throws MalformedURLException {
		driver = WebDriverHelper.getWebDriver();
		driver.get("https://www.roomstogo.com");		
		utils.waitForPageToLoad(driver);
	}

	@DataProvider
	private static Object[] links() {
		return new Object[][] {
				{TopNavigation.Links.CreditOptions,
						"https://www.roomstogo.com/view/creditOptions.jsp"},
				{TopNavigation.Links.CustomerService,
						"https://www.roomstogo.com/content/Customer-Service"},
				{TopNavigation.Links.GiftCards,
						"https://www.roomstogo.com/product/adults/GIFT-CARD/83333333/"},
				{TopNavigation.Links.OrderStatus, "https://www.roomstogo.com/orderstatus/"},
				{TopNavigation.Links.StoreLocator, "https://www.roomstogo.com/storelocator/"}
		};
	}

	@Test
	@UseDataProvider("links")
	void shouldTopNavLinks(TopNavigation.Links link, String expectedUrl) {

		Home homePage = new Home(driver);

		homePage.topNav.clickLink(link, expectedUrl);
	}

	@AfterAll
	public void done() {
		driver.close();
	}
}
