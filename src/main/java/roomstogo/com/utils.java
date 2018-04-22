package roomstogo.com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class utils {
	
	private static int timeout = Integer.parseInt(System.getProperty("timeout", "30"));
	
	public static void waitForPageToLoad(WebDriver driver) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return ((JavascriptExecutor) d)
				.executeScript("return document.readyState")
				.equals("complete");
            }
        });		
	}
	
	public static void waitForUrlEquals(WebDriver driver, final String url) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return d.getCurrentUrl().equals(url);
            }
        });		
	}
	
	
	public static void waitForTitleEquals(WebDriver driver, final String title) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
            	return d.getTitle().equals(title);
            }
        });		
	}
	
}
