package roomstogo.com.home;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import roomstogo.com.utils;

public class TopNavigation {
	
	public static enum Links {
		CreditOptions, GiftCards, StoreLocator, OrderStatus, CustomerService
	}

	// Driver
	WebDriver driver;
	
	// Container
	By container = By.id("topnavigation");
	
	// Tabs
	By roomToGoTab = By.linkText("Rooms To Go");
	By kidsAndTeensTab = By.linkText("Kids & Teens");

	// Links
	By credOptionsLink = By.xpath("div/ul[2]/li[1]/a");
	By giftCardsLink = By.xpath("div/ul[2]/li[2]/a");
	By storeLocatorLink = By.xpath("div/ul[2]/li[3]/a");
	By orderStatusLink = By.xpath("div/ul[2]/li[4]/a");
	By customerServiceLink = By.xpath("div/ul[2]/li[5]/a");
	
	
	public TopNavigation(WebDriver driver) {
		this.driver = driver;
	}
	
	private WebElement getElement(By by) {
		return driver.findElement(container).findElement(by);
	}
	
	public void goToKidsSite() {
		WebElement siteTab = getElement(kidsAndTeensTab);
		siteTab.click();
		utils.waitForTitleEquals(driver, "Baby & Kids Furniture: Bedroom Furniture Store");
	}
	
	public void goToRoomsToGoSite() {
		WebElement siteTab = getElement(roomToGoTab);
		siteTab.click();
		utils.waitForTitleEquals(driver, "Furniture Store: Affordable Home Furniture for Less Online");
	}
	
	public void clickLink(Links link, String expectedUrl) {
		WebElement siteLink = null;
		switch(link) {
			case CreditOptions:
				siteLink = getElement(credOptionsLink);
				break;
			case GiftCards:
				siteLink = getElement(giftCardsLink);
				break;
			case StoreLocator:
				siteLink = getElement(storeLocatorLink);
				break;
			case OrderStatus:
				siteLink = getElement(orderStatusLink);
				break;
			case CustomerService:
				siteLink = getElement(customerServiceLink);
				break;
			default:
				break;
		}
		siteLink.click();
		utils.waitForPageToLoad(driver);
		Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
	}

}
