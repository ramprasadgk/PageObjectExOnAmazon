package PageObjectExOnAmazon;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

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
	Logger log = Logger.getLogger("Purchaseordertest");
	Properties prop = new Properties();
	
	
	
	@BeforeClass 
	public void setup(){
				
		
		log.setLevel(Level.ALL);
		log.info("initializing - trying to load configuration file ...");

		//Properties preferences = new Properties();
		try {
		    
		    InputStream configFile = PurchaseorderTest.class.getResourceAsStream("/app.properties");
		    LogManager.getLogManager().readConfiguration(configFile);
		    
		    
		    InputStream in = PurchaseorderTest.class.getResourceAsStream("/webdriver.properties");
		    prop.load(in);
		    
		    
		} catch (IOException ex)
		{
		    System.out.println("WARNING: Could not open configuration file");
		    System.out.println("WARNING: Logging not configured (console output only)");
		}
		

		
		    
		    
		log.info("starting myApp");
		System.out.println("Before class");		
		System.out.println();
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromewebdriver"));
		wd = new ChromeDriver();
		wd.manage().window().maximize();
		wd.get("http://www.amazon.com");
	}
	
	@Test(dataProvider = "search", dataProviderClass = DataProviderForSearch.class)
	public void purchaseIphone(String searchString,Integer a) {
		
		System.out.println(searchString);
		
		AmazonHomePage ahp =new AmazonHomePage(wd);
		AmazonSearchResultsPage arp = ahp.searchFor(searchString);
		//arp.selectBrand("Apple");
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
