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
 * @author r.singh.tomar
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

	@FindBy(xpath = "//input[@id='searchInput'][1]")
	WebElement searchBox;

	@FindBy(xpath = "//button[@name='profile-button']")
	WebElement myAccountButton;

	@FindBy(xpath = "//input[@id='logonId']")
	WebElement userNameCreateAccount;

	@FindBy(xpath = "//input[@id='logonPassword']")
	WebElement userPasswordCreateAccount;

	@FindBy(xpath = "//input[@id='logonPasswordVerify']")
	WebElement userPasswordVerifyCreateAccount;

	@FindBy(xpath = "//p[contains(@class,'MuiTypography-root')]//a[text()='Create an account']")
	WebElement createAccountLink;
	//

	@FindBy(xpath = "//p[contains(@class,'MuiTypography-root') and text()='Suggested Products']//parent::div//img")
	List<WebElement> suggestedProducts;

	@FindBy(xpath = "(//a[contains(@data-link-attr,'GlobalNav:Clothing-View All Clothing') and text() = 'Clothing'])[1]")
	WebElement CatClothing;

	@FindBy(xpath = "(//a[@data-link-attr='GlobalNav:Clothing-Departments-Skirts' and text()='Skirts'])[1]")
	WebElement subCategory;

	@FindBy(xpath = "//button[@class='offer-control close']//span")
	WebElement offerCloseXIcon;

	@FindBy(xpath = "//input[@name='email']")
	WebElement emailBoxOffer;

	@FindBy(xpath = "//input[@name='submit']")
	WebElement emailBoxOffeSubmit;

	@FindBy(xpath = "//iframe[contains(@id,'fcopt-offer-')]")
	WebElement frame;

	public boolean loginInToFlipkart(String username, String password) {
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

	public void enterText() {
		searchBox.sendKeys("Bi-Stretch Slim-Leg Pants");
	}

	public void clickFirstProudct() {
		suggestedProducts.get(1).click();
	}

	public void clickMyAccountButton() {
		myAccountButton.click();
	}

	public void hoverCategory() {
		Actions action = new Actions(driver);
		action.moveToElement(CatClothing).build().perform();
	}

	public void clickSubCategory() throws InterruptedException {
		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(subCategory).build().perform(); Thread.sleep(2000);
		 */
		subCategory.click();
	}

	public void closeIconClick() {
		try {
			Thread.sleep(1000);
			driver.switchTo().frame(frame);
			Thread.sleep(1000);
			System.out.println("Switched-----------");
			
			// Print the frame source code
			System.out.println("Frame Source" +driver.getPageSource());
			/*WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='offer-control close']//span")))
					.click();*/
			
			WebElement element = driver.findElement(By.xpath("//button[@class='offer-control close']//span"));
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);
			
			
		/*	WebElement element = driver.findElement(By.xpath("//input[@name='submit']"));
			 JavascriptExecutor jse = (JavascriptExecutor)driver;
			 jse.executeScript("arguments[0].click();", element);
			 //jse.executeScript("arguments[0].value='himanshu@gmail.com';", element);
*/			System.out.println("Clicked-----------");
			// offerCloseXIcon.click();
			// driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println("Error----"+e);
			
		}
	}

	public void enterEmailoffer() throws InterruptedException {
		emailBoxOffer.sendKeys("abcd@gmail.com");
		Thread.sleep(2000);
		emailBoxOffeSubmit.click();
	}

	public void clickCreateAccountLink() throws InterruptedException {

		createAccountLink.click();
	}

	public void enterUserName(String userName) throws InterruptedException {
		userNameCreateAccount.sendKeys(userName);
		Thread.sleep(2000);
	}

	public void enterPsssword(String password) throws InterruptedException {
		userPasswordCreateAccount.sendKeys(password);
		Thread.sleep(2000);
	}

	public void enterConfirmPsssword(String confirmPassword) throws InterruptedException {
		userPasswordVerifyCreateAccount.sendKeys(confirmPassword);
		Thread.sleep(2000);
	}
}
