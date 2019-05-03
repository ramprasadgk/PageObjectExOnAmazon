package tutorial.po.pageobjects.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;


public class AmazonHomePage  {
	public WebDriver wd;
	@FindBy(how = How.ID, using = "twotabsearchtextbox")
    @CacheLookup
	private WebElement searchBox;
	
	@FindBy(how = How.XPATH, using = "contains(text(),'iphone 6'")
	private WebElement searchResultVerifyText;
	
	public AmazonHomePage(WebDriver wd) {
		this.wd=wd;
		 PageFactory.initElements(wd, this);
	}
	
	public AmazonSearchResultsPage searchFor(String text) {
		System.out.println("Searching for" +text);
		searchBox.sendKeys(text);
		searchBox.submit();
		AmazonSearchResultsPage arp =new AmazonSearchResultsPage(wd);
		return  arp;	
		
	}

}
