package login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pom.Home;
import pom.LoginCredentails;
import utilitypac.UtilityClass;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriver driver=new ChromeDriver();
		WebDriver driver =new FirefoxDriver();
		driver.get("https://online.actitime.com/marolix11/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		LoginCredentails l=new LoginCredentails(driver);
		
		
		 String user=UtilityClass.FetchData("Sheet1", 1, 0);
		 l.SendUsername(user);
		 String pass=UtilityClass.FetchData("Sheet1", 1, 1);
		 l.Sendpassword(pass);
		 l.ClickOnKeepMeSignIn();
		 l.ClickOnLoginbutton();
		
		
		Home h=new Home(driver);
		h.opentask();
		h.openReport();
		h.openUsers();
		h.ClickOnLogout();
	}

}
