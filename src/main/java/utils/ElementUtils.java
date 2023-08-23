package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	public ElementUtils(WebDriver driver) 
	{
		this.driver=driver;
	}
	//WebElement clickonmethod
	public void clickOnElement(WebElement element,long durationInSeconds) {
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		webElement.click();
	}
	
	//typeTextIntoElement
	public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {
		
		/*WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));*/
		
		WebElement webElement=waitForElement(element,durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
		
	}
	public WebElement waitForElement(WebElement element,long durationInSeconds) {
		
		WebElement webElement=null;
		
		try {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {
		
		WebElement webElement = waitForElement(element,durationInSeconds);
		Select select =new Select(element);
		select.selectByVisibleText(dropDownOption);
		
	}

	public void acceptAlert(long durationInSeconds) {
		
		Alert alert=WaitForAlert(durationInSeconds);
		alert.accept();
	}
	public void dismissAlert(long durationInSeconds) {
		
		Alert alert=WaitForAlert(durationInSeconds);
		alert.dismiss();
	}
	
	
	public Alert WaitForAlert(long durationInSeconds) {
		
		Alert alert=null;
		
		try {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	public void mouseHoverAndclick(WebElement element,long durationInSeconds) {
		
		/*WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		WebElement webElement=wait.until(ExpectedConditions.visibilityOf(element));*/
		
		WebElement webElement=waitForVisiblityOfElement(element,durationInSeconds);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}
	public WebElement waitForVisiblityOfElement(WebElement element,long durationInSeconds) {

		WebElement webElement=null;
		try {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(durationInSeconds));
		webElement=wait.until(ExpectedConditions.visibilityOf(element));
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return webElement;
	}
	public void javaScriptClick(WebElement element,long durationInSeconds) {
		WebElement webElement=waitForVisiblityOfElement(element,durationInSeconds);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click()", webElement);
	}
	
	public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {
		
		WebElement webElement=waitForVisiblityOfElement(element,durationInSeconds);
		JavascriptExecutor jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);  //it is dynamic
	}
	public String getTextFromElements(WebElement element,long durationInSeconds) {
		WebElement webElement =waitForElement(element,durationInSeconds);
		return webElement.getText();
	}
	public boolean displaystatusOfElement(WebElement element,long durationInSeconds) {
		try {
		WebElement webElement=waitForVisiblityOfElement(element,durationInSeconds);
		return webElement.isDisplayed();
		}catch(Throwable e) {
			//e.printStackTrace();
			return false;
		}
		
	}
}
