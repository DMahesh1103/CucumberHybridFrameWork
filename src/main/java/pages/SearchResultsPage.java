package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {
	WebDriver driver;
	private ElementUtils elementUtils;
	
    public SearchResultsPage(WebDriver driver) 
    {
		this.driver=driver;
		PageFactory.initElements(driver, this);      //this or HomePAGE
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath="//input[@value='Search']/following-sibling::p")
	private WebElement messageText;
	
	public boolean displayStatusOfValidProduct() 
	{
		return elementUtils.displaystatusOfElement(validHPProduct,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return validHPProduct.isDisplayed();
	}
	
	public String getMessageText() 
	{
		return elementUtils.getTextFromElements(messageText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		//return messageText.getText();
	}
}
