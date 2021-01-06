package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;

public class HomePage extends PageBase {
	@FindBy(xpath = "//a[@id='atteandanceLink']")
	 public WebElement attendanceTab;
	
	@FindBy(xpath = "//a[@class='logo']")
	public WebElement homeBtn;
	
	
	@FindBy(xpath = "//a[@id='leavesLink']")
	public WebElement leaveTab;
	
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
		else
			return false;
	}
}
