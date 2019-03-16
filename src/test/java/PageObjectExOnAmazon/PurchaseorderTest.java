package PageObjectExOnAmazon;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PurchaseorderTest {
	@Test
	public  void test1(){
		System.out.println("DONE.");
	}	
	@BeforeClass 
	public void setup(){
		System.out.println("Before class");
	}
	
	@AfterClass
	public void housekeeping(){
		System.out.println("Afer class");
	}
	
	
	
	 

	 

}
