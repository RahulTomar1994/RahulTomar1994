/**
 * 
 */
package locators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * @author rahulsingh.tomar
 *
 */
public class RedemptionScreen {

	WebDriver driver;

	public RedemptionScreen(WebDriver ldriver) {
		this.driver = ldriver;
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//input[@id='abcd']")
	WebElement redemptionScreen;
	
	@FindBy(xpath = "//input[@id='abcd']")
	WebElement earlyRedemptionScreen;
	
	@FindBy(xpath = "//input[@id='logonId']")
	List<WebElement> earlyRedemptionLinks;
	
	@FindBy(xpath = "//input[@id='abcd']")
	WebElement totalNominalAmount;
	
	@FindBy(xpath = "//input[@id='radioButton']")
	List<WebElement> redemptionTypeRadioButton;

	@FindBy(xpath = "//input[@id='abcd']")
	WebElement cashTextBox;
	
	@FindBy(xpath = "//input[@id='abcd']")
	WebElement sharesTextBox;
	
	@FindBy(xpath = "//input[@id='abcd']")
	WebElement spilitTextBox;
	
	@FindBy(xpath = "//input[@id='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//input[@id='successMessage']")
	WebElement transactionSuccessMessage;
	
	public void clickEarlyRedemtionLink(int index) {
		earlyRedemptionLinks.get(index).click();
	}
	public void verifyEarlyRedemtionScreen() {
		Assert.assertTrue(earlyRedemptionScreen.isDisplayed());
	}
	public void verifyRedemtionScreen() {
		Assert.assertTrue(redemptionScreen.isDisplayed());
	}
	public void verifyTotalNominalAmountIsPreFilled() {
		String nominalAmountPrefilled = totalNominalAmount.getText();
		Assert.assertFalse(nominalAmountPrefilled.isEmpty());
	}
	
	public void selectRedemptionTypeRadioButton(int index) {
		redemptionTypeRadioButton.get(index).click();
	}
	public void enterTextInCashTextBox(String CashText) {
		cashTextBox.sendKeys(CashText);
	}
	public void enterTextInSharesTextBox(String SharesText) {
		sharesTextBox.sendKeys(SharesText);
	}
	public void enterTextInSpilitTextBox(String SpilitText) {
		spilitTextBox.sendKeys(SpilitText);
	}
	public void clickSubmitButton() {
		submitButton.click();
	}
	public void verifyTransactionSuccessMessage() {
		Assert.assertTrue(transactionSuccessMessage.isDisplayed());
	}
	
}
