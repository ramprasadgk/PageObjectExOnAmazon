package PageObjectExOnAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import tutorial.po.pageobjects.amazon.AmazonHomePage;
import tutorial.po.pageobjects.amazon.AmazonProductPage;
import tutorial.po.pageobjects.amazon.AmazonSearchResultsPage;
import tutorial.po.pageobjects.amazon.SignInPage;

public class PurchaseorderTest {
	public WebDriver wd;
	@Test
	public  void test1(){
		System.out.println("BEGIN.");
		//AmazonHomePage hp = new AmazonHomePage();
		System.out.println("DONE.");
	}	
	@BeforeClass 
	public void setup(){
		System.out.println("Before class");		
		System.out.println();
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://www.amazon.com");
	}
	
	@Test
	public void purchaseIphone() {
		AmazonHomePage ahp =new AmazonHomePage(wd);
		AmazonSearchResultsPage arp = ahp.searchFor("iphone");
		arp.selectBrand("Apple");
		arp.selectNewestArrival();
		arp.selectConditionAsNew();
		AmazonProductPage app = arp.clickOnFirstItem();
		SignInPage sip = app.addToWishList();
		sip.createNewDummyAccount();
	}
	
	
	@AfterClass
	public void housekeeping() {
		System.out.println("Afer class");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		wd.quit();
	}
	
	
	
	 

	 

}
