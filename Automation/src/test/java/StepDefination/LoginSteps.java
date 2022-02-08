package StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
WebDriver driver;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		 System.out.println("User is on Login Page");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserExe\\chromedriver.exe");
		driver.get("www.xyzredemption.com/");
	   
	}

	@When("User enters user name and password")
	public void user_enters_user_name_and_password() {
	   System.out.println("User enters user name and password");
	   driver.findElement(By.xpath("loginId")).sendKeys("userName");
	   driver.findElement(By.xpath("password")).sendKeys("passWord");
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() {
	   System.out.println("User clicks on login button");
	   driver.findElement(By.xpath("loginButton")).click();
	}

	@Then("User should be land to homepage successfully.")
	public void user_should_be_land_to_homepage_successfully() {
	   System.out.println("User should be land to homepage successfully.");
	   Assert.assertTrue(driver.findElement(By.xpath("homePageIcon")).isDisplayed());
	}
	
}
