package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExcelLibraries;
import utils.ExtentReport;
import utils.TestUtil;

public class TestBase {
	protected static WebDriver driver;
	protected static PageBase basePage;
	public static Properties prop;
	public boolean checkBlnMethod;
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/"
					+ "config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeSuite
    public void launchApplication(ITestContext context) throws Throwable {
		setChromeDriverProperty();
		driver.get(prop.getProperty("AppUrl"));
		ExcelLibraries.createExcel(getClass().getSimpleName());
		ExtentReport.createExcelFile(getClass().getSimpleName());
	}

	
	public void reporting(String desc,String exp,String actual,String status) throws Throwable {
		
		if(status.equalsIgnoreCase("PASS")) {
			ExtentReport.Report("Pass", desc, actual, exp);
		}else {
			ExtentReport.Report("Fail", desc, actual, exp);
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
