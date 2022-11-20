package DocquityWeb.DocQT.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import DocquityWeb.DocQT.DataProvider.DataProviders;
import DocquityWeb.DocQT.Page.GrandRoundPage;
import DocquityWeb.DocQT.Page.LoginPage;

/**
 * @author SarabjitSingh
 *
 */
public class LoginTest extends BaseTest {
	
	GrandRoundPage GRPage;
	LoginPage loginPage;
	
	public LoginTest() {
		// TODO Auto-generated constructor stub
	super();
	}
	
	//Verify user is able to login
	@Test (dataProvider="loginTest" , dataProviderClass = DataProviders.class, groups= {"SmokeTest"})
	public void verifySuccessfulUserLogin(final String number, final String otp, final String country) {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		GRPage = loginPage.loginWithMobileAndCountry(number, otp, country);
		GRPage.waitForPage();
		Assert.assertTrue(GRPage.verifyProfileCardIsDisplayed());
		
	}
	
	// Verify user is able to login
	@Test(groups = { "SmokeTest" })
	public void verifyDefaultUserCountry() {
		driver.get(PostURL);
		loginPage = new LoginPage(driver).waitForPage();
		Assert.assertEquals(loginPage.verifyDefaultUserCountry(), "91", "Country Label is not correct");
	}
		
	//@Override
	public void afterTest() {
		// TODO Auto-generated method stub
		driver.quit();	
	}
}
