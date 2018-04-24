package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverHelper {

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

			String device = System.getProperty("device");
			if (device != null && !device.isEmpty()) {
				Map<String, String> mobileEmulation = new HashMap<String, String>();
				mobileEmulation.put("deviceName", device.replace('_', ' '));
				chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			}
		}
		try {
			driver = new ChromeDriver(chromeOptions);
		} catch (IllegalStateException ex) {
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
