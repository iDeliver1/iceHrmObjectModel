package utils;

import java.io.File;
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
	        System.out.println(data);
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
		System.out.println(cal.getTime());
	    SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-mm-dd HH-mm-ss");
		String time = dateFormat.format(cal.getTime());
		System.out.println(time);
		return time;
	}
	
	
	//---------------------------------Function For Current Date---------------------------------		
	public static String getCurrentDate(int date)
	{
		/*Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, date);
	    SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-mm-dd");  
	    String strDate = dateformat.format( c.getTime()); 
	    return strDate;*/
	    
	    Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, date);
		//System.out.println(c.getTime());
	    SimpleDateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");  
	    String strDate = dateformat.format( c.getTime()); 
	   // System.out.println(strDate);
	    return strDate;
	}
	
	//---------------------------------------Select Item--------------------------------------------
	public static void SelectItem(WebElement element,int LeaveFormat) {
		Select Leave = new Select(element);
		Leave.selectByIndex(LeaveFormat);
	}
}
	
