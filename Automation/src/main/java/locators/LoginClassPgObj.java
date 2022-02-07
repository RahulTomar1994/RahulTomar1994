/**
 * 
 */
package locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author rahulsingh.tomar
 *
 */
public class LoginClassPgObj {

	WebDriver driver;

	public LoginClassPgObj(WebDriver ldriver) {
		this.driver = ldriver;
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='logonId']")
	WebElement usernameTextBox;

	@FindBy(xpath = "//input[@id='logonPassword']")
	WebElement passwordTextBox;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedSecondary']")
	WebElement loginButton;

	@FindBy(xpath = "//div[@class='exehdJ' and text()='Rahul Singh']")
	WebElement profileICon;

	
	public boolean loginInToXyzBank(String username, String password) {
		try {
			usernameTextBox.sendKeys(username);
			passwordTextBox.sendKeys(password);
			loginButton.click();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public void verifyProfileIcon() {
		Assert.assertTrue(profileICon.isDisplayed());
	}
}
