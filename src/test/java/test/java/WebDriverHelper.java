package test.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebDriverHelper{
	
	private static WebDriver driver;
	
	public static WebDriver getWebDriver() {
		if (driver == null) {
			init();
		}
		return driver;
	}
	
	private static void init() {			
			String chromePath = System.getProperty("google.chrome");
			ChromeOptions chromeOptions = new ChromeOptions();
			if (chromePath != null) {
			    chromeOptions.setBinary(chromePath);
			    chromeOptions.addArguments("--headless");
			    chromeOptions.addArguments("--disable-gpu");
			}
			try {
				driver = new ChromeDriver(chromeOptions);
			}
			catch(IllegalStateException ex) {
				String driverPath = "resources/chromedriver";
				if (System.getProperty("os.name").contains("Windows")) {
					driverPath += ".exe";
				}
				System.setProperty("webdriver.chrome.driver", driverPath);
				driver = new ChromeDriver(chromeOptions); 
			}
			driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
	}

}
