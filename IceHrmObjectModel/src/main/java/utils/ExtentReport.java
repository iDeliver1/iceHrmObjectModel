package utils;

import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentReport {
	 
	static ExtentTest logger, childLogger, parentLogger;
	static ThreadLocal<ExtentTest> extentThread = new ThreadLocal<ExtentTest>();
	static ThreadLocal<ExtentReports> extentReporterThread = new ThreadLocal<ExtentReports>();
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static String extentFolderPath = TestUtil.reportFolderPath+"\\Report"+TestUtil.getTimeStamp(), reportName;
	static int iStepNumber = 1;
	  
	  
	public static void createExcelFile(String Step_details)   {
		
		htmlReporter = new ExtentHtmlReporter(extentFolderPath + "\\testReport.html");
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	    extent.setSystemInfo("OS", "OS");
	    extent.setSystemInfo("Browser", "browser");
	    htmlReporter.config().setDocumentTitle("Extent Report Demo");
	    htmlReporter.config().setReportName("Test Report");
	    htmlReporter.config().setTheme(Theme.STANDARD);
	    createReportName(Step_details);
	}


	 public synchronized ExtentReports getInstance() {	
		 return extentReporterThread.get();
	 }

	 
	 public static ExtentTest createReportName(String step_details){
		logger = extent.createTest(step_details);
		childLogger = logger.createNode("System Name - "+ System.getenv("COMPUTERNAME"));
		extentThread.set(childLogger);
		return extentThread.get();	
	 }
	  
	  
	  public synchronized ExtentTest getTest() {
	     return extentThread.get();
	  }
	  
	  public static void Report(String status, String description, String actualStep, String expectedStep) throws Throwable{
			
	  	String ReportStatus = "<b>Step Number "+iStepNumber+"<br>Description :</b> "+description+"<br><b>Expected :</b> "+expectedStep+"<br><b>Actual :</b> "+actualStep;
		ExcelLibraries.fExcelReporter(description, actualStep, expectedStep, status, TestUtil.getCurrentDate());
		try{
			if(status.equalsIgnoreCase("PASS")){	
				extentThread.get().log(Status.PASS, ReportStatus);
				flush();
			}
			else{
				extentThread.get().log(Status.FAIL, ReportStatus);
				flush();
				
			}
		
		}catch(Exception e){
			e.printStackTrace();
		}
		iStepNumber = iStepNumber + 1;
	}
	
	@AfterTest
	public static void flush(){
		extent.flush();
	}

}
