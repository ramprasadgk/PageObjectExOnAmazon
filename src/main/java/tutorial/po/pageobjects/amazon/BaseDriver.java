package tutorial.po.pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class BaseDriver {
	
	public  WebDriver wd;
	
	public BaseDriver() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		wd = new ChromeDriver();
		
	}
	

}
