package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {

	@FindBy(xpath="//a[@class='content tasks']")
	private WebElement task;
	
	@FindBy(xpath="//a[@class='content reports']")
	private WebElement reports;
	
	@FindBy (xpath="//a[@class='content users']")
	private WebElement user;
	
	@FindBy (xpath="(//a[contains(@id,'logoutLink')])[1]")
	private WebElement LogoutButton;
	
	private WebDriver driver;
	private Actions act;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Alert alt;
	
	public Home(WebDriver driver ) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		act=new Actions(driver);
		js=(JavascriptExecutor)driver;
	}
	
	public void opentask() {
		
		act.moveToElement(task).click().build().perform();
	}
	public void openReport() {
		wait.until(ExpectedConditions.visibilityOf(reports));
		reports.click();
	}
	public void openUsers() {
		js.executeScript("arguments[0].click();",user);
		
	}
	public void ClickOnLogout() {
		wait.until(ExpectedConditions.visibilityOf(LogoutButton));
		act.moveToElement(LogoutButton).click().build().perform();
	}
}
