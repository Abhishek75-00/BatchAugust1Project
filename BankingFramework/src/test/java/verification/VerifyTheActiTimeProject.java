package verification;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.HTMLReporter;

import browser.Base;
import pom.Home;
import pom.LoginCredentails;
import utilitypac.UtilityClass;

public class VerifyTheActiTimeProject extends Base  {

	WebDriver driver;
	LoginCredentails l;
	Home h;
	int testid;
	String user;
	String pass;
	
	
	static ExtentTest test; 
	static HTMLReporter reporter;
	
	
	
	
	@Parameters("browserName")
	@BeforeTest 
	public void LaunchBrowser(String browser) {
		System.out.println("before test");
	
		
		reporter=new HTMLReporter(".\\test-output\\Extent\\Extent.html");
		ExtentReports extend=new ExtentReports();
		extend.flush();
		
		
		if(browser.equals("Chrome")) {
			driver=openChromeBrowser();
		}
		
		if(browser.equals("Firefox")) {
			driver=openFirefoxBrowser();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	

	@BeforeClass   
	public void createPomObjects() {
           l=new LoginCredentails(driver);
           h=new Home(driver);
		

		
	}
	
	@BeforeMethod    // Login and to create the objects
	public void LoginToapplication() {
		driver.get("https://online.actitime.com/marolix11/login.do");	
	 l=new LoginCredentails(driver);
	 
	 //l.SendUsername();
		String user=UtilityClass.FetchData("Sheet1", 1, 0);
		 l.SendUsername(user);
		 String pass=UtilityClass.FetchData("Sheet1", 1, 1);
		 l.Sendpassword(pass);
	 l.ClickOnKeepMeSignIn();
	 l.ClickOnLoginbutton();
	 
	 
	 h=new Home(driver);
	}
	
	@Test
	public void ToVerifyTheTask() {
	testid=001;
		
		h.opentask();
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		System.out.println(url);
		System.out.println(title);
		
		Assert.assertEquals("actiTIME - Enter Time-Track", "actiTIME - Enter Time-Track");
		
	}
		@Test
		public void ToVerifyTheReports() {
			
			testid=002;
			h.openReport();
			
			String url1=driver.getCurrentUrl();
			String title1=driver.getTitle();
			System.out.println(url1);
			System.out.println(title1);

			Assert.assertEquals("https://online.actitime.com/marolix11/reports/dashboard.do","https://online.actitime.com/marolix11/reports/dashboard.do");
		}
	
		@AfterMethod   // logout code
		public void Logout(ITestResult result) throws Exception {
			if(ITestResult.FAILURE==result.getStatus()) {
				UtilityClass.capture(driver, testid=002,"ToVerifyTheTask");
			}
			
			
			h.ClickOnLogout();
				
		}
		
		@AfterClass  // quiting the browser
		public void clearObject()
		{
		  l=null;
		  h=null;
		}
		@AfterTest
		public void closedBrowser() {
			driver.quit();
			driver=null;
			System.gc(); // garbage collector
		}
}
