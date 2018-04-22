package roomstogo.com.home;

import org.openqa.selenium.WebDriver;

public class Home {
	
	public TopNavigation topNav;
	
	public Home(WebDriver driver) {
		this.topNav = new TopNavigation(driver);
	}
}
