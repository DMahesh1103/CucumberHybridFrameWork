package stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	
	@Given("User has navigated to login page")
	public void  User_has_navigated_to_login_page() {
		
		
		driver=DriverFactory.getDriver();
		
		HomePage homepage=new HomePage(driver);
		homepage.clickONMyAccount();
		loginPage=homepage.selectLoginOption();
		
		
		/*driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();*/
	}
	/*@When("User enters valid email address {string} into email field")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	    
		//loginPage=new LoginPage(driver);
		loginPage.enterEmailAdress(emailText);
		
	   //driver.findElement(By.id("input-email")).sendKeys(emailText);
	}
	@And("User enters valid password {string} into password field")
	public void user_enters_valid_password_into_password_field(String passwordText) {
	   
		loginPage.enterPassword(passwordText);
		
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	    
	}*/
	
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText) {
	    
		//loginPage=new LoginPage(driver);
		loginPage.enterEmailAdress(emailText);
		
	   //driver.findElement(By.id("input-email")).sendKeys(emailText);
	}
	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
	   
		loginPage.enterPassword(passwordText);
		
		//driver.findElement(By.id("input-password")).sendKeys(passwordText);
	    
	} 
	
	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		accountPage=loginPage.clickOnLoginButton();
	    
		//driver.findElement(By.xpath("//input[@value='Login']")).click();
	   
	}
	@Then("User should get Successfully logged in")
	public void user_should_get_successfully_logged_in() {
	   
		//accountPage =new AccountPage(driver);
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
		
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	    
	}
	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		//loginPage =new LoginPage(driver);
		
	    commonUtils=new CommonUtils();
		loginPage.enterEmailAdress(commonUtils.getEmailwithTimeStamp());
		
		//driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	    
	}
	@And("users enters invalid password {string} into password field")
	public void users_enters_invalid_password_into_password_field(String invalidpasswordText) {
		
		loginPage.enterPassword(invalidpasswordText);
	    
		//driver.findElement(By.id("input-password")).sendKeys(invalidpasswordText);
	}
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
		
		Assert.assertTrue(loginPage.getwarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	    
		//Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}
	
	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		//loginPage=new LoginPage(driver);
		
		loginPage.enterEmailAdress("");
	   
		
		//driver.findElement(By.id("input-email")).sendKeys(" ");
	}
	@And("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		//loginPage =new LoginPage(driver);
		
		loginPage.enterPassword("");
		
		//driver.findElement(By.id("input-password")).sendKeys(" ");
	    
	}
}
