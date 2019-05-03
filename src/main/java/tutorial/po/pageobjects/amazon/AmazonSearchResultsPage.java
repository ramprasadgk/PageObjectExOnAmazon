package tutorial.po.pageobjects.amazon;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import tutorial.po.pageobjects.amazon.utils.GenericUtils;

public class AmazonSearchResultsPage extends BasePage{
	public WebDriver wd;
	
	@FindBy(how = How.ID, using = "brandsRefinements")
    @CacheLookup
	private WebElement brands;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Sort by:']")
	private WebElement sortBy;
	
	
	
	
	
	
	public AmazonSearchResultsPage(WebDriver wd) {
		super(wd);
		this.wd=wd;
		PageFactory.initElements(wd, this);
		this.verifyTitle("");
	}
	
	public void selectBrand(String text) {
		
		//WebElement ele = wd.findElement(By.id("brandsRefinements"));
		java.util.List<WebElement> links = brands.findElements(By.tagName("li"));
		for (int i = 0; i < links.size(); i++)
		{
			//System.out.println('['+links.get(i).getText()+']'+'['+text+']');
		    if(links.get(i).getText().equals(text)) {
		    	links.get(i).click();
		    	break;
		    }
		}
	}

	public void selectNewestArrival() {
		//WebElement ele = wd.findElement(By.xpath("//span[text()='Sort by:']"));
		sortBy.click();
		sortBy= wd.findElement(By.xpath("//*[@id=\"s-result-sort-select_4\"]"));
				
		
		
	}

	public void selectConditionAsNew() {
		WebElement ele = wd.findElement(By.xpath("//span[text()='New']"));
		ele.click();		
		
	}

	public AmazonProductPage clickOnFirstItem() {
		WebElement ele = wd.findElement(By.id("search"));
		//ele.findElement(By.xpath("//div[@data-index=\"0\"]")).click();
		WebElement inner =ele.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/h2/a"));
		inner.click();;
		return new AmazonProductPage(wd);
		
	}

	@Override
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		
	}

	
}
