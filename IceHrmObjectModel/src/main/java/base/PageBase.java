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
	private static final int timeOut = 20; //seconds
	private  static final int polling = 100; //milliseconds
	
	    
	public void setWebDriver(WebDriver driver) {
		PageBase.pbDriver = driver;
		 wait = new WebDriverWait(pbDriver, timeOut, polling);
	    PageFactory.initElements(new AjaxElementLocatorFactory(PageBase.pbDriver, timeOut), this);
	}
	
	protected void waitForElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
	
	public void waitDriver() {
		pbDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
}
