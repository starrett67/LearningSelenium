package roomstogo.com;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	public static void waitForElementSteady(WebDriver driver, final WebElement element) {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<WebElement>() {

	        private WebElement _element = element;
	        private Point _location = null;

	        @Override
	        public WebElement apply(WebDriver driver) {

	            try {
	                if(_element.isDisplayed()){
	                    Point location = _element.getLocation();
	                    if(location.equals(_location) && isOnTop(_element)) {
	                        return _element;
	                    }
	                    _location = location;
	                }
	            } catch (StaleElementReferenceException e) {
	                _element = null;
	            }

	            return null;
	        }
	        
	        public boolean isOnTop(WebElement element) {
	    	    WebDriver driver = ((RemoteWebElement)element).getWrappedDriver();

	    	    return (Boolean) ((JavascriptExecutor) driver).executeScript(
	    	        "var elm = arguments[0];" +
	    	        "var doc = elm.ownerDocument || document;" +
	    	        "var rect = elm.getBoundingClientRect();" +
	    	        "return elm === doc.elementFromPoint(rect.left + (rect.width / 2), rect.top + (rect.height / 2));"
	    	        , element);
	    	}
	    });	
	}
	
	public static void scrollToElement(WebDriver driver, final WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
