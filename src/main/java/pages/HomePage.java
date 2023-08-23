package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementUtils =new ElementUtils(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement SearchButton;
	
	public void clickONMyAccount() {
		//myAccountDropMenu.click();
		elementUtils.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);  //after creation of elementutils class
	}
	public LoginPage selectLoginOption() {
		/*loginOption.click();
		return new LoginPage(driver);*/
		
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
	}
	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//registerOption.click();
		return new RegisterPage(driver);
	}
	public void enterProductIntoSearchBox(String ProductText) {
		elementUtils.typeTextIntoElement(searchBoxField,ProductText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//searchBoxField.sendKeys(ProductText);
	}
	public SearchResultsPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(SearchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//SearchButton.click();
		return new SearchResultsPage(driver);
	}
}
 