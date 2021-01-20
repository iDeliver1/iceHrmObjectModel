package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;
import pages.HomePage;
import pages.LoginPage;
import pages.TravelPage;

public class TC002_iceHrmTravelRequestTest extends TestBase{
	LoginPage pgLogin;
	HomePage pgHome;
	TravelPage pgTravel;
	
	@Test
	public void iceHrmTravelRequest() throws Throwable {
		//Login
		pgLogin = new LoginPage(driver);
		pgHome = pgLogin.userLogin(prop.getProperty("username"),prop.getProperty("password"));
		
		try {
			Assert.assertNotNull(pgHome);
			reporting("Login Validation", "User should log in", "User Logged in Successfully", "Pass");
			
		}catch(AssertionError E) {
			reporting("Login Validation", "User should log in", "User Login Failed", "Fail");
		}
		
		//Travel Request
		pgHome.clickOnTab("Travel");
		pgTravel = new TravelPage(driver);
		pgTravel.addTravelRequest();
		
	}

}
