package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;

public class HomePage extends PageBase {
	@FindBy(xpath = "//a[@id='atteandanceLink']")
<<<<<<< HEAD
	public WebElement attendanceTab;
=======
	 public WebElement attendanceTab;
>>>>>>> branch 'master' of https://github.com/iDeliver1/iceHrmObjectModel.git
	
	@FindBy(xpath = "//a[@class='logo']")
	public WebElement homeBtn;
	
	@FindBy(xpath = "//a[@id='leavesLink']")
	public WebElement leaveTab;
<<<<<<< HEAD
	
	@FindBy(xpath = "//a[@id='mytravelLink']")
	public WebElement travelTab;
	
	@FindBy(xpath = "//a[@id='leaveLink']")
	public WebElement adminLeaveTab;
	
	@FindBy(xpath = "//a[@id='travelLink']")
	WebElement adminTravelTab;
=======
>>>>>>> branch 'master' of https://github.com/iDeliver1/iceHrmObjectModel.git
	
	public HomePage(WebDriver driver) {
		setWebDriver(driver);
	}

	public Object clickOnTab(String TabName) {
		homeBtn.click();
		if(TabName.equalsIgnoreCase("Attendance")) {
			attendanceTab.click();
			return new AttendancePage(pbDriver);
		}
		else if(TabName.equalsIgnoreCase("Leave")) {
			leaveTab.click();
			 return new LeavePage(pbDriver);
		}
		
		else if(TabName.equalsIgnoreCase("Travel")) {
			travelTab.click();
			return new TravelPage(pbDriver);
		}
		
		else if(TabName.equalsIgnoreCase("Leave Approval")) {
			adminLeaveTab.click();
			return new AdminLeavePage(pbDriver);
		}
		
		else if(TabName.equalsIgnoreCase("Travel Approval")) {
			adminTravelTab.click();
			return new AdminTravelPage(pbDriver);
		}
		
		else
			return false;
	}
}
