package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.AttendancePage;
import pages.HomePage;
import pages.LeavePage;
import pages.LoginPage;

public class TC001_iceHrmAttendenceTest extends TestBase{
	
	@Test
	public void icehrmAttendenceTest() throws InterruptedException {
		//Login
		LoginPage pglogin = new LoginPage(driver);
		HomePage pghome = pglogin.userLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		//Punch In
		AttendancePage pgAtten = (AttendancePage) pghome.clickOnTab("Attendance");
		boolean checkblnmethod = pgAtten.icehrmAttendancePage("IN",0);
		Assert.assertEquals(true, checkblnmethod);
		
		//Apply for Leave
		LeavePage pgleave = (LeavePage) pghome.clickOnTab("Leave");
		pgleave.applyForLeave("Causal Leave");
		
		//Punch Out
		pgAtten = (AttendancePage) pghome.clickOnTab("Attendance");
		checkblnmethod = pgAtten.icehrmAttendancePage("OUT",0);
		Assert.assertEquals(true, checkblnmethod);
	}

}
