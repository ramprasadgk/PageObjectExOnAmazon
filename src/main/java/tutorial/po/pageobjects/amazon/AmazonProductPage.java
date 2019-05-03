package tutorial.po.pageobjects.amazon;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductPage extends BasePage{
	public WebDriver wd;
	
	@FindBy(how = How.ID, using = "add-to-wishlist-button-submit")
    @CacheLookup
	private WebElement wishList;
	
	
	public AmazonProductPage(WebDriver wd) {
		super(wd);
		this.wd=wd;
		PageFactory.initElements(wd, this);
		this.verifyTitle("");
	}
	
	public SignInPage addToWishList() {
		wishList.click();
		return new SignInPage(wd);
		
	}

	@Override
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
}
