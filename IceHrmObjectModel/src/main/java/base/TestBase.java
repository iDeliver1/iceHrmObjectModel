package base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestUtil;

public class TestBase {
	protected static WebDriver driver;
	protected static PageBase basePage;
	public static Properties prop;
	
	@BeforeSuite
    public void launchApplication() throws Throwable {
		TestUtil.propertyFileConfiguration();
		setChromeDriverProperty();
		driver.get(prop.getProperty("AppUrl"));
	}

	
    @AfterSuite
    public static void closeBrowser() {
            driver.close();
            driver.quit();
    }
    
    private static void setChromeDriverProperty() throws Throwable{
    	String BrowserVersion = TestUtil.getBrowserVersion();	
		System.out.println("Browser Version- "+BrowserVersion);
		WebDriverManager.chromedriver().version(BrowserVersion).setup();
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
}
