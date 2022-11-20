package DocquityWeb.DocQT.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DocquityWeb.DocQT.DataProvider.DataProviders;
import DocquityWeb.DocQT.Page.GrandRoundPage;
import DocquityWeb.DocQT.Page.LoginPage;
import DocquityWeb.DocQT.TestUtils.TestUtils;

/**
 * @author SarabjitSingh
 *
 */
public class GrandRoundTest extends BaseTest {
	
	GrandRoundPage GRPage;
	LoginPage loginPage;
	
	public GrandRoundTest() {
		// TODO Auto-generated constructor stub
	super();
	}
	
	//Verify the options under the discussion section on the GR
	@Test (dataProvider="loginTest" , dataProviderClass = DataProviders.class, groups= {"SmokeTest"})
	public void verifyOptionsUnderDiscussion(final String number, final String otp, final String country) {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		GRPage.waitForPage();
		GRPage.verifyDiscussionSectionIsVisible("Discussion");
		GRPage.verifyClinicalCaseIsVisible("Clinical Cases");
		GRPage.verifyPollIsVisible("Poll");
	}
	
	// Verify the options under the learning section on the GR
	@Test(dataProvider = "loginTest", dataProviderClass = DataProviders.class, groups= {"SmokeTest"})
	public void verifyOptionsUnderLearning(final String number, final String otp, final String country) {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		GRPage.waitForPage();
		GRPage.verifyLearningSectionIsVisible("Learning");
		GRPage.verifyArticlesIsVisible("Articles");
		GRPage.verifyCPDIsVisible("CPD");
		GRPage.verifyDoctalksIsVisible("DocTalks");
		GRPage.verifyWebinarsIsVisible("Webins");
		GRPage.verifyCalendarIsVisible("Calendar");
		GRPage.verifyConnectionIsVisible("Connection");
	}
	
	// Verify the options under the Docquity Exclusive section on the GR
	@Test(dataProvider = "loginTest", dataProviderClass = DataProviders.class, groups= {"SmokeTest"})
	public void verifyOptionsUnderDocquityExclusive(final String number, final String otp, final String country) {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		GRPage.waitForPage();
		GRPage.moveCursorToScrollBelowFeed();
		GRPage.scrollDownToDocquityExclusive();
		GRPage.verifyDocquityExclusiveSectionIsVisible("Docquity Exclusive");
		GRPage.verifyEventsIsVisible("Events");
		GRPage.verifyBookMarksIsVisible("Bookmarks");
		GRPage.verifyChannelsIsVisible("Channels");
		GRPage.verifyPharmaIsVisible("Pharma");
		GRPage.verifyNEJMIsVisible("NEJM");
		GRPage.verifySurveysIsVisible("Surveys");
		GRPage.verifyDrugSamplesIsVisible("Drug Samples");
		GRPage.verifyOnlineEventIsVisible("Online Event");
	}
	
	// Verify to post on the profile
	@Test(dataProvider = "loginTest", dataProviderClass = DataProviders.class, groups= {"SmokeTest"})
	public void clickStartAPost(final String number, final String otp, final String country) throws InterruptedException {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		GRPage.waitForPage();
		GRPage.clickStartAPost();
		GRPage.enterTextForPost("This Post is created through automation ");
		GRPage.uploadImage("Test_Image.png");
		GRPage.uploadVideo("bigbuckbunny2p1mb.mp4");
		GRPage.uploadPdf("pdf-test.pdf");
		GRPage.clickNextButton();
		GRPage.verifyVisibilityOfisThisIsACaseSwitch();
		GRPage.selectFirstSpeciality();
		GRPage.clickNextButton();
		GRPage.clickPostButton();
		GRPage.verifyIfPostIsVisible("This Post is created through automation "+TestUtils.currentDate());
		Thread.sleep(2000);
	}
	
	// Verify whether all elements on the GR screen are visible or not`
	//@Test(dataProvider = "loginTest", dataProviderClass = DataProviders.class, groups= {"SmokeTest"})
	public void verifyTheUIElementsOfGRScreen(final String number, final String otp, final String country) {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		GRPage.waitForPage();
	}
	
	//@Override
	public void afterTest() {
		// TODO Auto-generated method stub
		driver.quit();	
	}
}
