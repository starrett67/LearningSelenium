package roomstogo.com.home;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home {
	
	private WebDriver driver;
	
	public TopNavigation topNav;
	
	public MobileNavigation mobNav;
	
	public Home(WebDriver driver) {
		this.topNav = new TopNavigation(driver);
		this.mobNav = new MobileNavigation(driver);
		this.driver = driver;
	}
	
	public List<WebElement> findBrokenLinks() throws InterruptedException {
		// Fix this later if you have time
		Thread.sleep(1000);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Iterator<WebElement> linksIt = links.iterator();
		List<WebElement> brokenLinks = new ArrayList<WebElement>();
		while(linksIt.hasNext()) {
			WebElement link = linksIt.next();
			String url = link.getAttribute("href");
			if(url == null || url.isEmpty()) {
				continue;
			}
			
			if(!url.contains("www.roomstogo")) {
				continue;
			}
			
			try {
                HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());                
                huc.setRequestMethod("HEAD");                
                huc.connect();
                
                int respCode = huc.getResponseCode();                
                if(respCode >= 400){
                	brokenLinks.add(link);
                    System.out.println(link.getText() + " link is broken. Status code " + respCode + " " + url);
                }
                else {
                	System.out.println(link.getText() + " link is valid" + " " + url);
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
		}
		return brokenLinks;
	}
}
