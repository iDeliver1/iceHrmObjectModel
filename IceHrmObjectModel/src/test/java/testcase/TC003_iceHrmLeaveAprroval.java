package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.AdminLeavePage;
import pages.HomePage;
import pages.LoginPage;

public class TC003_iceHrmLeaveAprroval extends TestBase{
	LoginPage pgLogin;
	HomePage pgHome;
	AdminLeavePage pgAdmin;
	
	@Test
	public void iceHrmLeaveAprroval() throws Throwable {
		//Login
		pgLogin = new LoginPage(driver);
		pgHome = pgLogin.userLogin(prop.getProperty("AdminUser"),prop.getProperty("password"));
		
		try {
			Assert.assertNotNull(pgHome);
			reporting("Login Validation", "User should log in", "User Logged in Successfully", "Pass");
			
		}catch(AssertionError E) {
			reporting("Login Validation", "User should log in", "User Login Failed", "Fail");
		}
		
		//Approve leave
		pgAdmin = (AdminLeavePage) pgHome.clickOnTab("Leave Approval");
		checkBlnMethod = pgAdmin.clickOnLeaveTableAction();
		
		try {
			Assert.assertEquals(true, checkBlnMethod);
			reporting("Leave Approval Validation", "Admin Should Approve Leave Request", "Leave Request Approved Successfully", "Pass");
		}catch(AssertionError E) {
			reporting("Leave Approval Validation", "Admin Should Approve Leave Request", "Leave Request Approval Failed", "Fail");
		}
	}

}
