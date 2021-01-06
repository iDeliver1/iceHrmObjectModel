package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import base.PageBase;
import basePage.TestBase;
import pageModules.HomePage;

public class LoginPage extends PageBase{
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement enterUserName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassWord;
	
	@FindBy(xpath = "//a[contains(text(),'IceHrm Employee')]")
	WebElement validateUser;
	
	
	public LoginPage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void setUserName(String userName){
		enterUserName.clear();
		enterUserName.sendKeys(userName);
	}
	
	public void setPassword(String pwd){
		enterPassWord.clear();
		enterPassWord.sendKeys(pwd);
	}
	
	public void clickOnLogInButton(){
		loginBtn.click();
	}

	public boolean validate() {
		return validateUser.isDisplayed();
	}
	
	public HomePage userLogin(String strUserName, String strPasswprd) {
		setUserName(strUserName);
		setPassword(strPasswprd);
		clickOnLogInButton();
		
		try {
			Assert.assertEquals(true,validate());
			return new HomePage(pbDriver);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
