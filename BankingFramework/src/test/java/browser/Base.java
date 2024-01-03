package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import login.Test;

public class Base extends Test{

	public static WebDriver openChromeBrowser() {
		
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Browsers\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		WebDriver driver=new FirefoxDriver(options);
		return driver;
	}
	public static WebDriver openEdgeBrowser() {
		WebDriver driver=new EdgeDriver();
		return driver;
	}
	
	
}
