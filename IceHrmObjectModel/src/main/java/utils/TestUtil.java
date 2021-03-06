package utils;

import java.io.File;
<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;


public class TestUtil extends TestBase{
	static String rootdir;
	public static String brow;
	public static String reportFolderPath = prop.getProperty("reportFolder");

	public static String getBrowserVersion() throws IOException {
		
		try {
			Runtime rt = Runtime.getRuntime();
			try {
				rootdir = System.getProperty("user.dir");
				rt.exec("cmd  /K \"dir /B/AD \"C:/Program Files (x86)/Google/Chrome/Application/\"|findstr /R /C:\"^[0-9].*\\..*[0-9]$\" > "+ rootdir +"\\version.txt\"");
				brow = getVersion();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			return brow.substring(0, brow.length() - 4);
		}
		catch(Exception e){
			brow = e.toString();
			return brow;
		}
	}

//--------------------Return Stored value of Chrome Browser Version----------------------------
	public static String getVersion() {
		 String data = "";
		try {
		  File myObj = new File(rootdir+"/version.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	         data = myReader.nextLine();
	         break;
	      }
	      myReader.close();
	      return data;
	    } catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
		return null;
	}
	
	public static String getCurrentDate()
	{
		Date date = new Date();  
	    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = dateformat.format(date); 
	    return strDate;
	}
	
	public static String getTimeStamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String time = dateFormat.format(now);
		return time.replace("-", "");
	}
	
	
	//-------------------------------------------TimeStamp Function----------------------------------	
	public static String getAttendenceTime(int hour)
	{
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(new Date());              
		cal.add(Calendar.HOUR_OF_DAY, hour);  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(cal.getTime());
		return time;
	}
	
	
	//---------------------------------Function For Current Date---------------------------------		
	public static String getLeaveDate(int date)
	{
	    Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, date);
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = dateformat.format( cal.getTime()); 
	    return strDate;
	}
	
	//---------------------------------------Select Item--------------------------------------------
	public static void selectItem(WebElement element,int LeaveFormat) {
		Select Leave = new Select(element);
		Leave.selectByIndex(LeaveFormat);
	}
	
	//------------------------get date by format---------------------------------------------------
	public static String getDatebyFormat(String dateFormat ,int addToDate)
	{
	    Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, addToDate);
	    SimpleDateFormat dateformat = new SimpleDateFormat(dateFormat);  
	    String strDate = dateformat.format( cal.getTime()); 
	    return strDate;
=======
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;


public class TestUtil extends TestBase{
	static String rootdir;
	public static String brow;
	public static String Report_Folder_path = "C:\\Reporting";

	public static String getBrowserVersion() throws IOException {
		
		try {
			Runtime rt = Runtime.getRuntime();
			try {
				rootdir = System.getProperty("user.dir");
				rt.exec("cmd  /K \"dir /B/AD \"C:/Program Files (x86)/Google/Chrome/Application/\"|findstr /R /C:\"^[0-9].*\\..*[0-9]$\" > "+ rootdir +"\\version.txt\"");
				brow = getversion();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			return brow.substring(0, brow.length() - 4);
		}
		catch(Exception e){
			brow = e.toString();
			return brow;
		}
	}

//--------------------Return Stored value of Chrome Browser Version----------------------------
	public static String getversion() {
		 String data = "";
		try {
		  File myObj = new File(rootdir+"/version.txt");
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	         data = myReader.nextLine();
	         break;
	      }
	      myReader.close();
	      return data;
	    } catch (FileNotFoundException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
		return null;
	}
	
	public static String GetCurrentDate()
	{
		Date date = new Date();  
	    SimpleDateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");  
	    String strDate = dateformat.format(date); 
	    return strDate;
	}
	
	public static String Timestamp()
	{
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
		String time = dateFormat.format(now);
		return time.replace("-", "");
	}
	
	
	
	//------------------Function for Reading Property file---------------
	public static void propertyFileConfiguration() throws Throwable {
		try {
			prop = new Properties();
			String path = System.getProperty("user.dir");
			FileInputStream ip = new FileInputStream(path+"\\src\\main\\java\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
				e.printStackTrace();
		}
	}
	
	//-------------------------------------------TimeStamp Function----------------------------------	
	public static String getTimeStamp(int hour)
	{
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(new Date());              
		cal.add(Calendar.HOUR_OF_DAY, hour);  
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(cal.getTime());
		return time;
	}
	
	
	//---------------------------------Function For Current Date---------------------------------		
	public static String getCurrentDate(int date)
	{
	    Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, date);
	    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");  
	    String strDate = dateformat.format( c.getTime()); 
	    return strDate;
	}
	
	//---------------------------------------Select Item--------------------------------------------
	public static void SelectItem(WebElement element,int LeaveFormat) {
		Select Leave = new Select(element);
		Leave.selectByIndex(LeaveFormat);
>>>>>>> branch 'master' of https://github.com/iDeliver1/iceHrmObjectModel.git
	}
}
	
