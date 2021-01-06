package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.AttendancePage;
import pages.HomePage;
import pages.LeavePage;
import pages.LoginPage;

public class TC001_iceHrmAttendenceTest extends TestBase{
	LoginPage pgLogin;
	HomePage pgHome;
	AttendancePage pgAtten;
	LeavePage pgLeave;
	
	@Test
	public void icehrmAttendenceTest() throws Throwable {
		//Login
		pgLogin = new LoginPage(driver);
		pgHome = pgLogin.userLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		try {
			Assert.assertNotNull(pgHome);
			reporting("Login Validation", "User should log in", "User Logged in Successfully", "Pass");
			
		}catch(AssertionError E) {
			reporting("Login Validation", "User should log in", "User Login Failed", "Fail");
		}
		
		
		//Punch In
		pgAtten = (AttendancePage) pgHome.clickOnTab("Attendance");
		checkBlnMethod = pgAtten.icehrmAttendancePage("IN",0);
		
		try {
			Assert.assertEquals(true, checkBlnMethod);
			reporting("Punch System Validation", "User should Punch In", "User Punch In Successful", "Pass");
		}catch(AssertionError E) {
			reporting("Punch System Validation", "User should Punch In", "User punch In Failed", "Fail");
		}
		
		
		//Apply for Leave
		pgLeave = (LeavePage) pgHome.clickOnTab("Leave");
		pgLeave.applyForLeave("Causal Leave");
		checkBlnMethod = pgLeave.checkEntryTable();
		
		try {
			Assert.assertEquals(true, checkBlnMethod);
			//fail
			reporting("Leave Validation", "User must be able to apply for leave ", "User failed to applied for leave", "Fail");
		}catch(AssertionError E) {
			//pass
			reporting("Leave  Validation", "User must be able to apply for leave ", "User Successfully applied for leave", "Pass");
		}
		
		
		//Punch Out
		pgHome.homeBtn.click();
		pgHome.attendanceTab.click();
		checkBlnMethod = pgAtten.icehrmAttendancePage("OUT",1);
	
		try {
			
			Assert.assertEquals(true, checkBlnMethod);
			reporting("Punch System Validation", "User should Punch Out", "User Punch Out Successful", "Pass");
		}catch(AssertionError E) {
			reporting("Punch System Validation", "User should Punch Out", "User Punch Out Failed", "Fail");
		}
	}

}
