package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginCredentails {
	@FindBy (xpath="//input[@id='username']")
	 private WebElement UserName;
	 
	 @FindBy(xpath="//input[@name='pwd']")
	 private WebElement PassWord;
	 
	 @FindBy(xpath="//input[@id='keepLoggedInCheckBox']")
	 private WebElement KeepMeSignIn;
	 
	 @FindBy (xpath="//td[@id='loginButtonContainer']")
	 private WebElement LoginButton;
	 
	 private WebDriver driver;
	 private WebDriverWait wait;
	 private Actions act;
	 
	 public LoginCredentails(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
		
	
	public void SendUsername(String user) {
		
		act.moveToElement(UserName).sendKeys(user).build().perform();;
	}
	
	public void Sendpassword(String password) {
		PassWord.sendKeys(password);
	}
	public void ClickOnKeepMeSignIn() {
		KeepMeSignIn.click();
	}
	public void ClickOnLoginbutton() {
		LoginButton.click();
	}
	
	 
	}	 

