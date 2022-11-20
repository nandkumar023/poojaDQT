/**
 * 
 */
package DocquityWeb.DocQT.Page;

import DocquityWeb.DocQT.TestUtils.*;
import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.testng.*;

import java.util.*;

/**
 * @author SarabjitSingh
 *
 */
public class UDP extends BasePage {
	@Override
	public BasePage waitForPage() {
		return null;
	}

	public UDP(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(UDP.class);
	
	
	@FindBy(xpath="(//img[contains(@class,'position')])[1]") private List<WebElement> DROPDOWN;
	@FindBy(xpath = "(//div//a[@class='prfl-list pt-2 pb-2 ng-tns-c402-0'])[1]") private List<WebElement> MYPROFILE;
	@FindBy(xpath = "(//div//a[@class='prfl-list pt-2 pb-2 ng-tns-c402-0'])[2]") private List<WebElement> MYVAULT;


	public void verifyMyProfile() throws Exception {
		TestUtils.waitForPageLoad(driver);
		TestUtils.waitForElement(driver, DROPDOWN);
		TestUtils.waitForVisibilityOf(driver, DROPDOWN.get(0)).click();
		String text = TestUtils.waitForVisibilityOf(driver, MYPROFILE.get(0)).getText();
		Assert.assertEquals(text,"View Profile");

	}

	public void verifyMyVault() throws Exception {
		TestUtils.waitForPageLoad(driver);
		TestUtils.waitForElement(driver, DROPDOWN);
		TestUtils.waitForVisibilityOf(driver, DROPDOWN.get(0)).click();
		String text = TestUtils.waitForVisibilityOf(driver, MYVAULT.get(0)).getText();
		Assert.assertEquals(text,"My Vault");

	}


}