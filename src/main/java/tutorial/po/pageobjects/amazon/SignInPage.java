package tutorial.po.pageobjects.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

	public WebDriver wd;
	
	
	public SignInPage(WebDriver wd) {
		this.wd=wd;
	}
	
	
	public void createNewDummyAccount() {

		

		
		wd.findElement(By.id("createAccountSubmit")).click();
	    wd.findElement(By.id("ap_customer_name")).sendKeys("dummyusername");
	    wd.findElement(By.id("ap_email")).sendKeys("r2321312@gmail.com");
	    wd.findElement(By.id("ap_password")).sendKeys("dummypwd");
	    wd.findElement(By.id("ap_password_check")).sendKeys("dummypwd");
	    wd.findElement(By.id("continue")).click();
	    
		
	}
}	
