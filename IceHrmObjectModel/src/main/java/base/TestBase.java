package base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Excel_Libraries;
import utils.Extent_Report;
import utils.TestUtil;

public class TestBase {
	protected static WebDriver driver;
	protected static PageBase basePage;
	public static Properties prop;
	public boolean checkBlnMethod;
	
	@BeforeSuite
    public void launchApplication(ITestContext context) throws Throwable {
		TestUtil.propertyFileConfiguration();
		setChromeDriverProperty();
		driver.get(prop.getProperty("AppUrl"));
		Excel_Libraries.createExcel(getClass().getSimpleName());
		Extent_Report.createExcelFile(getClass().getSimpleName());
	}

	
	public void Reporting(String desc,String actual,String exp,String status) throws Throwable {
		
		
		if(status.equalsIgnoreCase("PASS")) {
			Extent_Report.Report("Pass", desc, actual, exp);
		}else {
			Extent_Report.Report("Fail", desc, actual, exp);
		}
		
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
