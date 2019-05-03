package tutorial.po.pageobjects.amazon;

import org.openqa.selenium.WebDriver;

import tutorial.po.pageobjects.amazon.utils.GenericUtils;

public abstract class BasePage {
	public WebDriver wd;
	public BasePage(WebDriver wd) {
		this.wd=wd;
		//String strLong = Long.toString(System.currentTimeMillis();
		try {
			GenericUtils.takeSnapShot(wd, System.getProperty("user.home")+"latest" );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public abstract void verifyTitle(String title);
}
	
	
