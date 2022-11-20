package DocquityWeb.DocQT.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DocquityWeb.DocQT.TestUtils.TestUtils;


public class UserDropDownPage1 extends BasePage {
	
//	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(UserDropDownPage1.class);

	public UserDropDownPage1() {
//		super(driver);
//		this.driver= driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "searchBox")
	private WebElement SEARCH_BAR;
	
	@FindBy(xpath = "(//img[contains(@class,'position')])[1]")
	private WebElement USER_DROPDOWN;

	@FindBy(xpath = "//a[@data-testid='viewprofile-userdropdown']")
	private WebElement VIEW_PROFILE_USERMENU;

	@FindBy(xpath = "//a[@data-testid='myvault-userdropdown']")
	private WebElement MY_VAULT_USERMENU;

	@FindBy(xpath = "//a[@data-testid='calendar-userdropdown']")
	private WebElement CALENDAR_USERMENU;

	@FindBy(xpath = "//a[@data-testid='bookmarks-userdropdown']")
	private WebElement BOOKMARKS_USERMENU;

	@FindBy(xpath = "//a[@data-testid='settings-userdropdown']")
	private WebElement SETTINGS_USERMENU;

	@FindBy(xpath = "//a[@data-testid='sendfeedback-userdropdown']")
	private WebElement SEND_FEEDBACK_USERMENU;

	@FindBy(xpath = "//a[@data-testid='tc-userdropdown']")
	private WebElement TERMS_CONDITIONS_USERMENU;

	@FindBy(xpath = "(//a[contains(@class,'prfl-list')])[8]")
	private WebElement LOGOUT_USERMENU;

	public void clickOnUserDropdown() {
		TestUtils.waitForVisibilityOf(driver, USER_DROPDOWN);
		Log.info("Click on the userDropdown option ", LOGGER);
		USER_DROPDOWN.click();
	}

	public void verifyViewProfileUsermenuIsVisible(final String viewProfileText) {
		Log.info("Verify visibility of viewProfile under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, VIEW_PROFILE_USERMENU).getText(), viewProfileText,
				"View Profile Text is not visible");
	}

	public void verifyMyVaultUsermenuIsVisible(final String myVaultText) {
		Log.info("Verify visibility of myVault under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, MY_VAULT_USERMENU).getText(), myVaultText,
				"My Vault Text is not visible");
	}

	public void verifyCalendarUsermenuIsVisible(final String calendarText) {
		Log.info("Verify visibility of calendar under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, CALENDAR_USERMENU).getText(), calendarText,
				"Calendar Text is not visible");
	}

	public void verifyBookmarksUsermenuIsVisible(final String bookmarksText) {
		Log.info("Verify visibility of bookmarks under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, BOOKMARKS_USERMENU).getText(), bookmarksText,
				"Bookmarks Text is not visible");
	}

	public void verifySettingsUsermenuIsVisible(final String settingsText) {
		Log.info("Verify visibility of Settings under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, SETTINGS_USERMENU).getText(), settingsText,
				"Settings Text is not visible");
	}

	public void verifySendFeedbackUsermenuIsVisible(final String sendFeedbackText) {
		Log.info("Verify visibility of Send Feedback under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, SEND_FEEDBACK_USERMENU).getText(), sendFeedbackText,
				" Send Feedback Text is not visible");
	}

	public void verifyTermsConditionsUsermenuIsVisible(final String termsConditionsText) {
		Log.info("Verify visibility of termsCondition under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, TERMS_CONDITIONS_USERMENU).getText(),
				termsConditionsText, "Terms & Conditions Text is not visible");
	}

	public void verifylogoutUsermenuIsVisible(final String logoutText) {
		Log.info("Verify visibility of logout under the userDropDown", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, LOGOUT_USERMENU).getText(), logoutText,
				"Logout Text is not visible");
	}
	
	@Override
	public UserDropDownPage1 waitForPage() {
		//This method will make the script wait until the page is loaded
		Log.info("Waiting for home page to be visible", LOGGER);
		TestUtils.calculatePageLoadTime(driver);
		TestUtils.waitForVisibilityOf(driver, SEARCH_BAR);
		return this;
	}

	
}
