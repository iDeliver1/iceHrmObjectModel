package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AdminTravelPage;
import pages.HomePage;
import pages.LoginPage;

public class TC004_iceHrmTravelAproval extends TestBase{
	LoginPage pgLogin;
	HomePage pgHome;
	AdminTravelPage pgAdmin;
	
	@Test
	public void iceHrmTravelAproval() throws Throwable {
		//Login
		pgLogin = new LoginPage(driver);
		pgHome = pgLogin.userLogin(prop.getProperty("AdminUser"),prop.getProperty("password"));
				
		try {
			Assert.assertNotNull(pgHome);
			reporting("Login Validation", "User should log in", "User Logged in Successfully", "Pass");
			
		}catch(AssertionError E) {
			reporting("Login Validation", "User should log in", "User Login Failed", "Fail");
		}
		
		//Approve Travel Request by Admin
		pgAdmin = (AdminTravelPage) pgHome.clickOnTab("Travel Approval");
		checkBlnMethod = pgAdmin.empTravelAction();
		
		try {
			Assert.assertEquals(true, checkBlnMethod);
			reporting("Travel Approval Validation", "Admin Should Approve Travel Request", "Travel Request Approved Successfully", "Pass");
		}catch(AssertionError E) {
			reporting("Travel Approval Validation", "Admin Should Approve Travel Request", "Travel Request Approval Failed", "Fail");
		}
		
	}

}
