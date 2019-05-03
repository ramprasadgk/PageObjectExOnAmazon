package PageObjectExOnAmazon;

import org.testng.annotations.DataProvider;

public class DataProviderForSearch {
	
	
		  @DataProvider(name = "search")
		  public static Object[][] createData() {
			  return new Object[][] {
				   { "samsung", new Integer(36) },
				   { "iphone", new Integer(37)},
				 };

		  }}



