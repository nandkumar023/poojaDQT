package DocquityWeb.DocQT.Test;

import DocquityWeb.DocQT.Page.*;
import org.testng.annotations.Test;

import DocquityWeb.DocQT.DataProvider.DataProviders;


public class UserDropDownTest extends BaseTest {

	GrandRoundPage GRPage;
	LoginPage loginPage;
	UserDropDownPage userDropDownPage;
	UDP udp;

	public UserDropDownTest() {
		// TODO Auto-generated constructor stub
		super();
	}

//Verify the options under the he user dropdown section on the GR
	@Test(dataProvider = "loginTest", dataProviderClass = DataProviders.class, groups = { "SmokeTest" })
	public void verifyOptionsUnderUserDropdown(final String number, final String otp, final String country) throws Exception {
//		driver.get(PostURL);
		driver.get("http://website.docquity.com/");
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		Thread.sleep(5000);
		new UDP(driver).verifyMyProfile();
		driver.navigate().refresh();
		new UDP(driver).verifyMyVault();

//		userDropDownPage.waitForPage();

//
//		userDropDownPage.clickOnUserDropdown();
//		userDropDownPage.verifyViewProfileUsermenuIsVisible("View Profile");
//		userDropDownPage.verifyMyVaultUsermenuIsVisible("My Vault");
//		userDropDownPage.verifyCalendarUsermenuIsVisible("Calendar");
//		userDropDownPage.verifyBookmarksUsermenuIsVisible("Bookmarks");
//		userDropDownPage.verifySettingsUsermenuIsVisible("Settings");
//		userDropDownPage.verifySendFeedbackUsermenuIsVisible("Send Feedback");
//		userDropDownPage.verifyTermsConditionsUsermenuIsVisible("Terms & Conditions");
//		userDropDownPage.verifylogoutUsermenuIsVisible("Logout");
	}

	// @Override
	public void afterTest() {
		// TODO Auto-generated method stub
//		driver.quit();
	}
}
		
		
		