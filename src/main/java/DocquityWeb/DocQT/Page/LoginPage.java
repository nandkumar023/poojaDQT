/**
 * 
 */
package DocquityWeb.DocQT.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import DocquityWeb.DocQT.TestUtils.TestUtils;
import DocquityWeb.DocQT.TestUtils.WaitTime;

/**
 * @author SarabjitSingh
 *
 */
public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);
	
	
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
	
	public void pj(){
//		WebDriverManager.chromedriver().setup();
	}
	
	
	public void enterMobileNumber(final String mobileNumber) {
//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://website.docquity.com/");
		Log.info("Entering the mobile number" + mobileNumber, LOGGER);
		TestUtils.waitForVisibilityOf(driver, MOBILE_NUMBER).sendKeys(mobileNumber);
	}
	
	public void clickRequestOTP() {
		Log.info("Trying to click on the Request OTP button", LOGGER);
		TestUtils.waitForElementToBeClickable(driver, REQUEST_OTP).click();
	}
	
	public void enterOTP(final String otp) {
		Log.info("Trying to enter the OTP" + otp, LOGGER);
		TestUtils.waitForVisibilityOf(driver, ENTER_OTP).sendKeys(otp);
	}
	
	public GrandRoundPage clickVerifyButton() {
		Log.info("Trying to click on the Verify Button", LOGGER);
		TestUtils.waitForElementToBeClickable(driver, VERIFY_BUTTON).click();
		return new GrandRoundPage(driver);
	}
	
	public void clickAcceptCookiesButton() {
		Log.info("Trying to click on the Accept Button", LOGGER);
		TestUtils.waitForElementToBeClickable(driver, ACCEPT_BUTTON).click();
	}
	
	public void clickCountryDropdown() {
		Log.info("Trying to click on the country dropdown", LOGGER);
		TestUtils.waitForElementToBeClickable(driver, COUNTRY_DROPDOWN).click(); 
	}
	
	public void selectCountryFromDropdown(final String country) {
		Log.info("Selecting country from the dropdown - "+country, LOGGER);
		TestUtils.waitForElementToBeClickable(driver, COUNTRY_SEARCH).sendKeys(country); 
		TestUtils.waitForVisibilityOf(driver, FIRST_COUNTRY).click();
	}
	
	public GrandRoundPage loginWithMobileAndCountry(final String number, final String otp, final String country) {
		clickCountryDropdown();
		selectCountryFromDropdown(country);
		enterMobileNumber(number);
		clickRequestOTP();
		enterOTP(otp);
		clickVerifyButton();
		return new GrandRoundPage(driver);
	}
	
	@Override
	public LoginPage waitForPage() {
		// TODO Auto-generated method stub
		TestUtils.calculatePageLoadTime(driver);
		return this;
	}

	public String verifyDefaultUserCountry() {
		return DEFAULT_COUNTRY.getText();
	}
}