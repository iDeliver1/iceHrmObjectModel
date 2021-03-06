package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import base.PageBase;

public class AdminLeavePage extends PageBase {
	
	
	@FindBy(xpath = "//a[@id='tabEmployeeLeave']")
	public WebElement empLeaveTab;
	
	@FindBy(xpath = "//div[@class='row']/following-sibling::table[@style='width: 1055px;']/tbody/child::tr")
	public List <WebElement> empLeaveTable;
	
	@FindBy(xpath = "//div[@class='row']/following-sibling::table[@style='width: 1055px;']/tbody/child::tr/td/child::div/img")
	public List <WebElement> empLeaveTableActionButton;
	
	@FindBy(xpath = "//select[@id='leave_status']")
	public WebElement empLeaveStatus;
	
	
	@FindBy(xpath = "//button[contains(text(),'Change Leave Status')]")
	public WebElement empLeaveBtn;
	
	
	@FindBy(xpath = "//button[contains(text(),'Ok')]")
	public WebElement okBtn;
	
	
	int iActionRequest=1,iCancelRequest=2,iTableCount;
	String strTableValue;

	public AdminLeavePage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	//public void clickOnEmpployeeTab() {
	//	empLeaveTab.click();
	//}
	

	public boolean clickOnLeaveTableAction() {
		empLeaveTab.click();
		//iTableCount = empLeaveTable.size();
		strTableValue = empLeaveTable.get(0).getText();
			try {
				if(!(strTableValue.equalsIgnoreCase("No data available in table"))) {
				//if (iTableCount!=0) {
					for(int iTable=0;iTable<iTableCount;iTable++) {
						empLeaveTableActionButton.get(iActionRequest).click();
						try {	
							Select leaveStatus =new Select(empLeaveStatus);
							leaveStatus.selectByIndex(0);
							empLeaveBtn.click();
							okBtn.click();
						}
						catch(Exception f) {
							return false;
						 }
						//iTableCount=iTableCount-1;
					}
				}
				return true;
			}
			catch (Exception E) {
				return false;	
			}	
		}
	
	}

