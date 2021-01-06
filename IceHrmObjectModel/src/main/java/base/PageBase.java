package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	protected static WebDriver pbDriver;
	private WebDriverWait wait;
	private static final int iTimeOut = 20; //seconds
	private  static final int iPolling = 100; //milliseconds
	
	    
	public void setWebDriver(WebDriver driver) {
		PageBase.pbDriver = driver;
		 wait = new WebDriverWait(pbDriver, iTimeOut, iPolling);
	    PageFactory.initElements(new AjaxElementLocatorFactory(PageBase.pbDriver, iTimeOut), this);
	}
	
	protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
	
	public void waitDriver() {
		pbDriver.manage().timeouts().implicitlyWait(iTimeOut,TimeUnit.SECONDS);
	}
}
