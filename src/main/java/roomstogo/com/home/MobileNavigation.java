package roomstogo.com.home;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import roomstogo.com.utils;


public class MobileNavigation {

    public static enum Links {
        CreditOptions, GiftCards, StoreLocator, OrderStatus, CustomerService
    }

    private WebDriver driver;

    //container
    private By container = By.id("mainHeader");

    // Nav Drawer
    By navDrawer = By.id("navOpen");
    // Sites
    By roomToGo = By.linkText("Rooms To Go Furniture");
    By kidsAndTeens = By.linkText("Rooms To Go Kids Furniture");
    // Links
    By credOptions = By.linkText("Credit Options");
    By giftCards = By.linkText("Buy Gift Card");
    By storeLocator = By.linkText("Find A Store");
    By orderStatus = By.linkText("Order Status");
    By customerService = By.linkText("Customer Service");


    public MobileNavigation(WebDriver driver){
        this.driver = driver;
    }

    private WebElement getElement(By by) {
        return driver.findElement(container).findElement(by);
    }

    public void goToKidsSite() {
        WebElement siteTab = getElement(kidsAndTeens);
        siteTab.click();
        utils.waitForTitleEquals(driver, "Baby & Kids Furniture: Bedroom Furniture Store");
    }

    public void goToRoomsToGoSite() {
        WebElement siteTab = getElement(roomToGo);
        siteTab.click();
        utils.waitForTitleEquals(driver, "Furniture Store: Affordable Home Furniture for Less Online");
    }

    public void openNavDrawer(){
        WebElement nav = getElement(navDrawer);
        nav.click();
    }

    public void clickNavLink(Links link, String expectedUrl) {
        WebElement siteLink = null;
        switch(link) {
            case CreditOptions:
                siteLink = getElement(credOptions);
                break;
            case GiftCards:
                siteLink = getElement(giftCards);
                break;
            case StoreLocator:
                siteLink = getElement(storeLocator);
                break;
            case OrderStatus:
                siteLink = getElement(orderStatus);
                break;
            case CustomerService:
                siteLink = getElement(customerService);
                break;
            default:
                break;
        }
        siteLink.click();
        utils.waitForPageToLoad(driver);
        Assertions.assertEquals(expectedUrl, driver.getCurrentUrl());
    }

}
