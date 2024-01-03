package verification;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoPractise {

	
	@BeforeClass
	public void beforeclass() {
		System.out.println("Before class - open browser");
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("Before method- login ");
	}
	@Test (timeOut=3000)
	public void  testA() throws Exception {
		System.out.println("Test A");
		Thread.sleep(2000);
		System.out.println("Hello");
	}
	@Test (priority=1 ,invocationCount=2)
	public void testB() {
		System.out.println("Test B");
	}
	@Test (priority=4 ,dependsOnMethods={"testA","testB"})
	public void testC() {
		System.out.println("Test C");
	}
	@Test (priority=3 , enabled=false)
	public void testD() {
		System.out.println("Test D");
	}
	
	
	@AfterMethod
	public void Aftermethod() {
		System.out.println("After method -- logout");
	}
	@AfterClass
	public void Afterclass() {
		System.out.println("After Class -- Quit browser");
	}
	

}
