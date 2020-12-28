package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;
import utils.TestUtil;

public class LeavePage extends PageBase {

	@FindBy(xpath = "//button[contains(text(),'Apply Leave')]")
	WebElement applyLeaveBtn;
	
	@FindBy(xpath = "//select[@id='leave_type']")
	 WebElement selectLeave;
	
	
	@FindBy(xpath = "//input[@id='date_start']")
	WebElement startDate;
	
	
	@FindBy(xpath = "//input[@id='date_end']")
	WebElement endDate;
	
	
	@FindBy(xpath = "//textarea[@id='details']")
	WebElement leaveDetails;

	
	@FindBy(xpath = "//button[contains(text(),'Continue')]")
	WebElement continueBtn;
	
	@FindBy(xpath = "//tbody[@id='leave_days_table_body']//child::td")
	WebElement checkLeaveDate;
	
	
	@FindBy(xpath = "//select[@class='days']")
	WebElement leaveFormat;
	
	@FindBy(xpath = "//div[contains(@class,'controls')]//button[contains(@class,'btn')][contains(text(),'Apply')]")
	WebElement applyBtn;
	

	@FindBy(xpath = "//p[@id='messageModelBody']")
	WebElement msgBody;
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	WebElement okBtn;

	public LeavePage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	
	public void applyForLeave(String Leave) throws InterruptedException {
		Thread.sleep(5000);
		waitForElementToAppear(applyLeaveBtn);
		applyLeaveBtn.click();

		try {
			waitForElementToAppear(selectLeave);
			selectLeave.click();
			TestUtil.SelectItem(selectLeave, 2);
		}catch(Exception e  ) {
			pbDriver.get(pbDriver.getCurrentUrl());
			waitDriver();
			applyLeaveBtn.click();
			TestUtil.SelectItem(selectLeave, 2);
		}
		
		startDate.sendKeys(TestUtil.getCurrentDate(0));
		endDate.sendKeys(TestUtil.getCurrentDate(0));
		continueBtn.click();
		TestUtil.SelectItem(leaveFormat, 1);
		applyBtn.click();
		waitForElementToAppear(msgBody);
		msgBody.click();
		okBtn.click();
	}

}
