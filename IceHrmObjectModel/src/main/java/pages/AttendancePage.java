package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;
import utils.TestUtil;

public class AttendancePage extends PageBase {
	@FindBy(xpath = "//button[@id='punchButton']")
	WebElement punchBtn;
	
	@FindBy(xpath = "//input[@id='time']")
	WebElement Time;
	
	@FindBy(xpath = "//textarea[@id='note']")
	WebElement note;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	@FindBy(xpath = "//button[@id='punchButton']")
	WebElement punchout;
	
	
	public AttendancePage(WebDriver driver) {
		setWebDriver(driver);
	}

	
	public void PunchSystem(String Status,int time) {
		Time.clear();
		Time.sendKeys(TestUtil.getTimeStamp(time));
		note.clear();
		note.sendKeys(Status);
		saveBtn.click();
	}
	
	public void punchIn() {
		punchBtn.click();
	}
	
	
	public void punchOut() {
		punchout.click();
	}
	
	public boolean icehrmAttendancePage(String AttendanceWay,int time) {
		
		try {
		switch(AttendanceWay) {
			case "IN"	:punchIn();
						 PunchSystem(AttendanceWay,time);
						 return true;
						
			case "OUT"	:punchOut();
						 PunchSystem(AttendanceWay, time);
						 return true;
						 
			default		:System.out.println("invalid section");
						 return false;
			}
			
		}catch(Exception e) {
			return false;
		}
			
	}
	
}
