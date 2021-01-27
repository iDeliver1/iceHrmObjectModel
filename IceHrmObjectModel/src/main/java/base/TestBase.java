package base;

<<<<<<< HEAD
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
=======
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
		
>>>>>>> branch 'master' of https://github.com/iDeliver1/iceHrmObjectModel.git
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
