package login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.Home;
import pom.LoginCredentails;
import utilitypac.UtilityClass;

public class Verify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	WebDriver driver=new ChromeDriver();
	LoginCredentails l;
	Home h ;	
		driver.get("https://online.actitime.com/marolix11/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 l=new LoginCredentails(driver);
//		l.SendUsername();
//		l.Sendpassword();
//		l.ClickOnKeepMeSignIn();
//		l.ClickOnLoginbutton();
		 l=new LoginCredentails(driver);
			String user=UtilityClass.FetchData("Sheet1", 1, 0);
			 l.SendUsername(user);
			 String pass=UtilityClass.FetchData("Sheet1", 1, 1);
			 l.Sendpassword(pass);
		 l.ClickOnKeepMeSignIn();
		 l.ClickOnLoginbutton();
		
		
	
		h=new Home(driver);
		
		//Test Cases 1 - Task
		
		driver.get("https://online.actitime.com/marolix11/login.do");
		l=new LoginCredentails(driver);
		l=new LoginCredentails(driver);
		String user1=UtilityClass.FetchData("Sheet1", 1, 0);
		 l.SendUsername(user1);
		 String pass1=UtilityClass.FetchData("Sheet1", 1, 1);
		 l.Sendpassword(pass1);
		 l.ClickOnKeepMeSignIn();
		 l.ClickOnLoginbutton();
		
		
		h.opentask();
	String url=	driver.getCurrentUrl();
	String title=driver.getTitle();
	System.out.println(url);
	System.out.println(title);
	if(url.equals("https://online.actitime.com/marolix11/tasks/tasklist.do") && title.equals("actiTIME - Task List")) {
		System.out.println("Pass");
	}
	else {
		System.out.println("Fail");
		
	}
	h.ClickOnLogout();
	
	// Testcase 2 - Reports 
	
	driver.get("https://online.actitime.com/marolix11/login.do");
	l=new LoginCredentails(driver);
	l=new LoginCredentails(driver);
	String user2=UtilityClass.FetchData("Sheet1", 1, 0);
	 l.SendUsername(user2);
	 String pass2=UtilityClass.FetchData("Sheet1", 1, 1);
	 l.Sendpassword(pass2);
	 l.ClickOnKeepMeSignIn();
	 l.ClickOnLoginbutton();
	
	h.openReport();
		String url1=driver.getCurrentUrl();
		String Title1=driver.getTitle();
		System.out.println(url1);
		System.out.println(Title1);
		if(url1.equals("https://online.actitime.com/marolix11/reports/dashboard.do") && Title1.equals("actiTIME - Reports Dashboard")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");

}
		h.ClickOnLogout();
		
	// Testcase - 3 - Users
		
		driver.get("https://online.actitime.com/marolix11/login.do");
		l=new LoginCredentails(driver);
		l=new LoginCredentails(driver);
		String user3=UtilityClass.FetchData("Sheet1", 1, 0);
		 l.SendUsername(user3);
		 String pass3=UtilityClass.FetchData("Sheet1", 1, 1);
		 l.Sendpassword(pass3);
		 l.ClickOnKeepMeSignIn();
		 l.ClickOnLoginbutton();
		
		h.openUsers();
		String url2=driver.getCurrentUrl();
		String Title2=driver.getTitle();
		System.out.println(url2);
		System.out.println(Title2);
		if(url2.equals("https://online.actitime.com/marolix11/administration/userlist.do") && Title2.equals("actiTIME - User List")) {
			System.out.println("Pass");
		}
		else {
			System.out.println("fails");
		}
		h.ClickOnLogout();

	
		
	}

}
