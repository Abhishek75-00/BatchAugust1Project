package demo.propertyFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class PropertyFiles {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\java\\testClass\\Data.properties");
		
		
		Properties p=new Properties();
		p.load(fis);
		String myBrowser=p.getProperty("browser");
		System.out.println(myBrowser);
		
		
		if(myBrowser.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver","D:\\abhi\\chromedriver-win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.flipkart.com/");
			
		}
		else if(myBrowser.equals("Firefox")) {
			WebDriver driver=new FirefoxDriver();
			driver.get("https://www.flipkart.com/");
		}
		
		else if(myBrowser.equals("Edge")) {
			WebDriver driver=new EdgeDriver();		
		driver.get("https://www.flipkart.com/");
		
		}
	}
	
	
	
}
