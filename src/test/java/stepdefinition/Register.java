package stepdefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSucessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSucessPage accountSucessPage;
	private CommonUtils commonUtils;
	
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		
	 
	   driver=DriverFactory.getDriver();
	   
	   HomePage homePage =new HomePage(driver);
	   homePage.clickONMyAccount();
	   registerPage=homePage.selectRegisterOption();
	   
	   //driver.findElement(By.xpath("//span[text()='My Account']")).click();
	   
	   //driver.findElement(By.linkText("Register")).click();
		
	}
	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fiels(io.cucumber.datatable.DataTable dataTable) {
	    Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    
	    //registerPage=new RegisterPage(driver);   becouse alrady object creats global leval
	    
	    registerPage.enterFirstName(dataMap.get("firstName"));
	    registerPage.enterLastName(dataMap.get("lastName"));
	    
	    commonUtils=new CommonUtils();
	    registerPage.enterEmailAddress(commonUtils.getEmailwithTimeStamp());
	    registerPage.enterTelephone(dataMap.get("telephone"));
	    registerPage.enterPassword(dataMap.get("password"));
	    registerPage.enterConfirmPassword(dataMap.get("password"));
	    
	    /*driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	    driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	    driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getEmailWithTimeStamp());
	    driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	    driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	    driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));*/
	    
	    
	}
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(io.cucumber.datatable.DataTable dataTable) {
	    Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	    
	   // RegisterPage registerPage =new RegisterPage(driver);
	    
	    registerPage.enterFirstName(dataMap.get("firstName"));
	    registerPage.enterLastName(dataMap.get("lastName"));
	    registerPage.enterEmailAddress(dataMap.get("email"));
	    registerPage.enterTelephone(dataMap.get("telephone"));
	    registerPage.enterPassword(dataMap.get("password"));
	    registerPage.enterConfirmPassword(dataMap.get("password"));
	    
	    /*driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
	    driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
	    driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
	    driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
	    driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
	    driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));*/
	    
	    
	}
	
	@And("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
		//RegisterPage registerPage =new RegisterPage(driver);
		
		registerPage.selectPrivacyPolicy();
		
	    //driver.findElement(By.name("agree")).click();
	}
	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		
		//RegisterPage registerPage =new RegisterPage(driver);
		accountSucessPage=registerPage.clickONContinueButton();
		
		//driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    
	}
	@Then("User account should get created sucessfully")
	public void user_account_should_get_created_sucessfully() {
		
		//accountSucessPage=new AccountSucessPage(driver);
		
		Assert.assertEquals("Your Account Has Been Created!",accountSucessPage.getPageHeading());
	    
	}
	@And("user selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
		
		//RegisterPage registerPage =new RegisterPage(driver);
		
		registerPage.selectYesNewsletterOption();
		
		//driver.findElement(By.xpath("//input[@name='newsletter']")).click();
	   
	}
	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
		
		//RegisterPage registerPage =new RegisterPage(driver);
		
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
	   
	}
	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
		
		
		//registerPage=new RegisterPage(driver);
		
		registerPage.enterFirstName("");
	    registerPage.enterLastName("");
	    registerPage.enterEmailAddress("");
	    registerPage.enterTelephone("");
	    registerPage.enterPassword("");
	    registerPage.enterConfirmPassword("");
	   
	}
	@Then("User should get proper warning messages for every mandatory fields")
	public void user_should_get_proper_warning_messages_for_every_mandatory_fields() {
		
		Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		
        Assert.assertEquals("First Name must be between 1 and 32 characters!", registerPage.getFirstNameWarning());
	    
	    Assert.assertEquals("Last Name must be between 1 and 32 characters!", registerPage.getLastNameWarning());
	    
	    Assert.assertEquals("E-Mail Address does not appear to be valid!", registerPage.getEmailWarning());
	     
	    Assert.assertEquals("Telephone must be between 3 and 32 characters!", registerPage.getTelephoneWarning());
	     
	    Assert.assertEquals("Password must be between 4 and 20 characters!", registerPage.getPasswordWarning());
	    
	    
		/*Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
		
	    Assert.assertEquals("First Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText());
	    
	    Assert.assertEquals("Last Name must be between 1 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText());
	    
	     Assert.assertEquals("E-Mail Address does not appear to be valid!", driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
	     
	     Assert.assertEquals("Telephone must be between 3 and 32 characters!", driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText());
	     
	     Assert.assertEquals("Password must be between 4 and 20 characters!",driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText());*/
	    
	    
	}
}
