/**
 * 
 */
package Automation.Automation;



import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import locators.LoginClassPgObj;
import locators.RedemptionScreen;

/**
 * @author rahulsingh.tomar
 *
 */
public class LoginTest extends BaseClass{
	@Test(priority=0,enabled=true)
	public void verifyXyzBank() {
		
		LoginClassPgObj loginClassPgObj = PageFactory.initElements(driver, LoginClassPgObj.class);
		driver.get(prop.getProperty("url"));
		loginClassPgObj.loginInToXyzBank(prop.getProperty("userName"), prop.getProperty("passWord"));
		loginClassPgObj.verifyProfileIcon();
		System.out.println("Login Is Successfully Done");
	}
	@Test(priority=1,enabled=true)
	public void verifyRedemptionThroughCash() {
		
		LoginClassPgObj loginClassPgObj = PageFactory.initElements(driver, LoginClassPgObj.class);
		RedemptionScreen redemptionScreen = PageFactory.initElements(driver, RedemptionScreen.class);
		
		driver.get(prop.getProperty("url"));
		loginClassPgObj.loginInToXyzBank(prop.getProperty("userName"), prop.getProperty("passWord"));
		
		redemptionScreen.verifyRedemtionScreen();
		System.out.println("Redemption Screen Is Displayed Successfully");
		
		redemptionScreen.clickEarlyRedemtionLink(0);
		System.out.println("Early Redemption Link Is Clicked Successfully");
		
		redemptionScreen.verifyEarlyRedemtionScreen();
		System.out.println("Early Redemption Screen Is Displayed Successfully");
		
		redemptionScreen.verifyTotalNominalAmountIsPreFilled();
		System.out.println("Nominal Amount Is Pre-filled");
		
		redemptionScreen.selectRedemptionTypeRadioButton(0);
		System.out.println("Cash Redemption Type Radio Button Is Selected");
		
		redemptionScreen.enterTextInCashTextBox(prop.getProperty("cashText"));
		System.out.println("Entered Text in Cash Text Box");
		
		redemptionScreen.clickSubmitButton();
		System.out.println("Submit Button Is Clicked Successfully");
		
		redemptionScreen.verifyTransactionSuccessMessage();
		System.out.println("Transaction is Completed Successfully");
		
	}
	@Test(priority=2,enabled=true)
	public void verifyRedemptionThroughShares() {
		
		LoginClassPgObj loginClassPgObj = PageFactory.initElements(driver, LoginClassPgObj.class);
		RedemptionScreen redemptionScreen = PageFactory.initElements(driver, RedemptionScreen.class);
		
		driver.get(prop.getProperty("url"));
		loginClassPgObj.loginInToXyzBank(prop.getProperty("userName"), prop.getProperty("passWord"));
		
		redemptionScreen.verifyRedemtionScreen();
		System.out.println("Redemption Screen Is Displayed Successfully");
		
		redemptionScreen.clickEarlyRedemtionLink(0);
		System.out.println("Early Redemption Link Is Clicked Successfully");
		
		redemptionScreen.verifyEarlyRedemtionScreen();
		System.out.println("Early Redemption Screen Is Displayed Successfully");
		
		redemptionScreen.verifyTotalNominalAmountIsPreFilled();
		System.out.println("Nominal Amount Is Pre-filled");
		
		redemptionScreen.selectRedemptionTypeRadioButton(1);
		System.out.println("Shares Redemption Type Radio Button Is Selected");
		
		redemptionScreen.enterTextInSharesTextBox(prop.getProperty("shareText"));
		System.out.println("Entered Text in Shares Text Box");
		
		redemptionScreen.clickSubmitButton();
		System.out.println("Submit Button Is Clicked Successfully");
		
		redemptionScreen.verifyTransactionSuccessMessage();
		System.out.println("Transaction is Completed Successfully");
		
	}
	@Test(priority=3,enabled=true)
	public void verifyRedemptionThroughSplit() {
		
		LoginClassPgObj loginClassPgObj = PageFactory.initElements(driver, LoginClassPgObj.class);
		RedemptionScreen redemptionScreen = PageFactory.initElements(driver, RedemptionScreen.class);
		
		driver.get(prop.getProperty("url"));
		loginClassPgObj.loginInToXyzBank(prop.getProperty("userName"), prop.getProperty("passWord"));
		
		redemptionScreen.verifyRedemtionScreen();
		System.out.println("Redemption Screen Is Displayed Successfully");
		
		redemptionScreen.clickEarlyRedemtionLink(0);
		System.out.println("Early Redemption Link Is Clicked Successfully");
		
		redemptionScreen.verifyEarlyRedemtionScreen();
		System.out.println("Early Redemption Screen Is Displayed Successfully");
		
		redemptionScreen.verifyTotalNominalAmountIsPreFilled();
		System.out.println("Nominal Amount Is Pre-filled");
		
		redemptionScreen.selectRedemptionTypeRadioButton(2);
		System.out.println("Shares Redemption Type Radio Button Is Selected");
		
		redemptionScreen.enterTextInCashTextBox(prop.getProperty("cashText"));
		System.out.println("Entered Text in Cash Text Box");
		
		redemptionScreen.enterTextInSharesTextBox(prop.getProperty("shareText"));
		System.out.println("Entered Text in Shares Text Box");
		
		redemptionScreen.clickSubmitButton();
		System.out.println("Submit Button Is Clicked Successfully");
		
		redemptionScreen.verifyTransactionSuccessMessage();
		System.out.println("Transaction is Completed Successfully");
		
	}
	
}
