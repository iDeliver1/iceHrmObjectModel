package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;
import utils.TestUtil;

public class TravelPage extends PageBase{
	@FindBy(xpath = "//button[contains(text(),'Add New')]")
	public WebElement addNewBtn;
	
	@FindBy(xpath = "//select[@id='type']")
	public WebElement meansOfTransport;
	
	@FindBy(xpath = "//textarea[@id='purpose']")
	public WebElement purposeOfTravel;
	
	@FindBy(xpath = "//input[@id='travel_from']")
	public WebElement travelFrom;
	
	@FindBy(xpath = "//input[@id='travel_to']")
	public WebElement travelTo;
	
	@FindBy(xpath = "//input[@id='travel_date']")
	public WebElement travelDate;
	
	@FindBy(xpath = "//input[@id='return_date']")
	public WebElement returnDate;
	
	@FindBy(xpath = "//select[@id='currency']")
	public WebElement currency;
	
	@FindBy(xpath = "//input[@id='funding']")
	public WebElement funding;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public WebElement saveBtn;
	
	public TravelPage(WebDriver driver) {
		setWebDriver(driver);
	}
	
	public void addTravelRequest() throws Throwable {
		addNewBtn.click();
		TestUtil.selectItem(meansOfTransport, 0);
		purposeOfTravel.sendKeys("Company Meeting");
		travelFrom.sendKeys("Mumbai");
		travelTo.sendKeys("Delhi");
		travelDate.sendKeys(TestUtil.getDatebyFormat("YYYY-MM-DD hh:mm:ss", 0));
		returnDate.sendKeys(TestUtil.getDatebyFormat("YYYY-MM-DD hh:mm:ss", 1));
		TestUtil.selectItem(currency, 56);
		Thread.sleep(5000);
		funding.sendKeys("2500");
		saveBtn.click();
	}

}
