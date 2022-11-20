package Pooja;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserDropDownPage extends Base {
	@FindBy(id="mobile_no")
	private WebElement MOBILE_NUMBER; 
	
	@FindBy(id="requestOtpClick")
	private WebElement REQUEST_OTP;
	
	@FindBy(xpath="//input[@inputmode='numeric']")
	private WebElement ENTER_OTP;
	
	@FindBy(id="1")
	private WebElement OTP_TEXTFIELD;  
	
	@FindBy(xpath="//button[contains(@class,'btn-success')]")
	private WebElement VERIFY_BUTTON;
	
	@FindBy(xpath="//button[contains(@class, 'btn-success')]")
	private WebElement ACCEPT_BUTTON;
	
	@FindBy(xpath = "//div[@class='c-btn']")
	private WebElement COUNTRY_DROPDOWN;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement COUNTRY_SEARCH;
	
	@FindBy(xpath = "//li[@class='pure-checkbox']")
	private WebElement FIRST_COUNTRY;
	
	@FindBy(xpath = "//span[@class='c-label']/span")
	private WebElement DEFAULT_COUNTRY;
	
	public UserDropDownPage() {

		PageFactory.initElements(driver,this);
}

    public void p1() {
    	
    	System.out.println("p1");
    }

    public void docquityLogin(String mobileNumber) {
    	Base.wait()
}


}

