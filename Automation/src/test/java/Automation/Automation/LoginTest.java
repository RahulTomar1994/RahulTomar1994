/**
 * 
 */
package Automation.Automation;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import locators.LoginClassPgObj;

/**
 * @author rahulsingh.tomar
 *
 */
public class LoginTest extends BaseClass{
	@Test(priority=0,enabled=true)
	public void verifyLogin() {
		
		LoginClassPgObj loginClassPgObj = PageFactory.initElements(driver, LoginClassPgObj.class);
		driver.get(prop.getProperty("url"));
		loginClassPgObj.loginInToFlipkart(prop.getProperty("userName"), prop.getProperty("passWord"));
	}
	
}
