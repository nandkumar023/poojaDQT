package DocquityWeb.DocQT.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import DocquityWeb.DocQT.DataProvider.DataProviders;
import DocquityWeb.DocQT.Page.GrandRoundPage;
import DocquityWeb.DocQT.Page.LoginPage;
import DocquityWeb.DocQT.Page.UserDropDownPage;
import DocquityWeb.DocQT.Page.UserDropDownPage1;
import io.github.bonigarcia.wdm.WebDriverManager;



public class UserDropDownTest extends BaseTest {

	GrandRoundPage GRPage;
	LoginPage loginPage;
	UserDropDownPage1 userDropDownPage1;

	public UserDropDownTest() {
		// TODO Auto-generated constructor stub
		super();
	}

//Verify the options under the he user dropdown section on the GR
	@Test(dataProvider = "loginTest", dataProviderClass = DataProviders.class, groups = { "SmokeTest" })
	public void verifyOptionsUnderUserDropdown(final String number, final String otp, final String country)
			throws Exception {
//	
//		driver.get(PostURL);
//		WebDriverManager.chromedriver().setup();
//		loginPage = new LoginPage().waitForPage();
		Thread.sleep(5000);
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		userDropDownPage1.waitForPage( );
		userDropDownPage1.clickOnUserDropdown();
		userDropDownPage1.verifyViewProfileUsermenuIsVisible("View Profile");
		userDropDownPage1.verifyMyVaultUsermenuIsVisible("My Vault");
		userDropDownPage1.verifyCalendarUsermenuIsVisible("Calendar");
		userDropDownPage1.verifyBookmarksUsermenuIsVisible("Bookmarks");
		userDropDownPage1.verifySettingsUsermenuIsVisible("Settings");
		userDropDownPage1.verifySendFeedbackUsermenuIsVisible("Send Feedback");
		userDropDownPage1.verifyTermsConditionsUsermenuIsVisible("Terms & Conditions");
		userDropDownPage1.verifylogoutUsermenuIsVisible("Logout");
	}

	// @Override
	public void afterTest() {
		// TODO Auto-generated method stub
		driver.quit();
	}
}
		
		
		