package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class LoginPage extends PageBase{
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginBtn;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement enterUserName;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPassWord;
	
	
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

	
	public HomePage userLogin(String strUserName, String strPasswprd) {
		setUserName(strUserName);
		setPassword(strPasswprd);
		clickOnLogInButton();
		return new HomePage(pbDriver);
	}
	
}
