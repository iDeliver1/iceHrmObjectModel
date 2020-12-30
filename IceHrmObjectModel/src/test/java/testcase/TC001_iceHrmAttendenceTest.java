package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.AttendancePage;
import pages.HomePage;
import pages.LeavePage;
import pages.LoginPage;

public class TC001_iceHrmAttendenceTest extends TestBase{
	boolean checkblnmethod;
	LoginPage pglogin;
	HomePage pghome;
	AttendancePage pgAtten;
	LeavePage pgleave;
	
	@Test
	public void icehrmAttendenceTest() throws Throwable {
		//Login
		 pglogin = new LoginPage(driver);
		 pghome = pglogin.userLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		try {
			Assert.assertNotNull(pghome);
			Reporting("Login Validation", "User should log in", "User log in Successful", "Pass");
			
		}catch(AssertionError E) {
			Reporting("Login Validation", "User should log in", "User log in Unsuccessful", "Fail");
		}
		
		
		//Punch In
		 pgAtten = (AttendancePage) pghome.clickOnTab("Attendance");
		checkBlnMethod = pgAtten.icehrmAttendancePage("IN",0);
		
		try {
			Assert.assertEquals(true, checkBlnMethod);
			Reporting("Punch System  Validation", "User should punch in", "User punch in Successful", "Pass");
		}catch(AssertionError E) {
			Reporting("Punch System Validation", "User should punch in", "User punch in Unsuccessful", "Fail");
		}
		
		
		//Apply for Leave
		 pgleave = (LeavePage) pghome.clickOnTab("Leave");
		 pgleave.applyForLeave("Causal Leave");
		
		checkBlnMethod = pgleave.checkEntryTable();
		
		try {
			Assert.assertEquals(true, checkBlnMethod);
			//fail
			Reporting("Leave Validation", "User must be able to apply for  leave ", "User unable to applied for  leave", "Fail");
		}catch(AssertionError E) {
			//pass
			Reporting("Leave  Validation", "User must be able to apply for  leave ", "User Successfully applied for  leave", "Pass");
		}
		
		
		//Punch Out
		pghome.homeBtn.click();
		pghome.attendanceTab.click();
		checkBlnMethod = pgAtten.icehrmAttendancePage("OUT",1);
	
		
		
		try {
			
			Assert.assertEquals(true, checkBlnMethod);
			Reporting("Punch System Validation", "User should punch out", "User punch out Successful", "Pass");
		}catch(AssertionError E) {
			Reporting("Punch System Validation", "User should log in", "User punch out Unsuccessful", "Fail");
		}
	}

}
