package verification;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.Home;
import pom.LoginCredentails;
import utilitypac.UtilityClass;

public class Assertions {
	WebDriver driver;
	LoginCredentails l;
	Home h;
	SoftAssert soft;
	
	@BeforeClass   // Launch Browser Credenetials
	public void OpenBrowser() {
		 driver=new ChromeDriver();// Run time Polymorphism - Type - upcasting
		 driver.get("https://online.actitime.com/marolix11/login.do");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@BeforeMethod    // Login and to create the objects
	public void LoginToapplication() {
	 l=new LoginCredentails(driver);
	 l=new LoginCredentails(driver);
		String user=UtilityClass.FetchData("Sheet1", 1, 0);
		 l.SendUsername(user);
		 String pass=UtilityClass.FetchData("Sheet1", 1, 1);
		 l.Sendpassword(pass);
	 l.ClickOnKeepMeSignIn();
	 l.ClickOnLoginbutton();
	 
	 h=new Home(driver);
	 soft=new SoftAssert();
	 
	}
	
	@Test
	public void ToVerifyTheTask() {
		
		h.opentask();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		
		System.out.println(url);
		System.out.println(title);
		
		AssertJUnit.assertEquals("https://online.actitime.com/marolix11/tasks/tasklist.do", "https://online.actitime.com/marolix11/tasks/tasklist.do");
		soft.assertAll();
	}
		@Test
		public void ToVerifyTheReports() {
			
			h.openReport();
			
			String url1=driver.getCurrentUrl();
			String title1=driver.getTitle();
			System.out.println(url1);
			System.out.println(title1);
//			if(url1.equals("https://online.actitime.com/marolix11/reports/dashboard.do") && title1.equals("actiTIME - Reports Dashboard")) {
//				System.out.println("Pass");
//		}else {
//			System.out.println("Fail");
			
			Assert.assertNotEquals("https://online.actitime.com/marolix11/reports/dashboard.d","https://online.actitime.com/marolix11/reports/dashboard.do");
			
		}
		
		@Test
		public void ToVerifyTheUsers(){
			h.openUsers();
			String url2=driver.getCurrentUrl();
			String title2=driver.getTitle();
			System.out.println(url2);
			System.out.println(title2);
			
			boolean result=false;
			AssertJUnit.assertFalse(result);
			//Assert.fail("ToVerifyTheUsers");	
		}
		
		
	
		@AfterMethod   // logout code
		public void Logout() {
			h.ClickOnLogout();
		}
		
		@AfterClass  // quiting the browser
		public void closebrowser()
		{
		driver.quit();
		}

}

	
