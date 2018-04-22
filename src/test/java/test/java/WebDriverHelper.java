package test.java;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class WebDriverHelper{
	
	WebDriver driver;
	
	public WebDriverHelper() throws MalformedURLException {
		init();
		driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
	}
	
	private void init() throws MalformedURLException {
		
			String driverPath = "resources/chromedriver";
			if (System.getProperty("os.name").contains("Windows")) {
				driverPath += ".exe";
			}
			System.setProperty("webdriver.chrome.driver", driverPath);
			String env = System.getProperty("env");
			ChromeOptions chromeOptions = new ChromeOptions();
			
//			if (env != null && env.equals("test")) {
//				chromeOptions.addArguments("--headless");
//				chromeOptions.addArguments("disable-gpu");
//			}
			driver = new ChromeDriver(chromeOptions);
	}

}
