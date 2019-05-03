package tutorial.po.pageobjects.amazon;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AmazonProductPage {
	public WebDriver wd;
	public AmazonProductPage(WebDriver wd) {
		this.wd=wd;
		PageFactory.initElements(wd, this);
	}
	
	public SignInPage addToWishList() {
		wd.findElement(By.id("add-to-wishlist-button-submit")).click();
		return new SignInPage(wd);
		
	}
	
	

	
	
}
