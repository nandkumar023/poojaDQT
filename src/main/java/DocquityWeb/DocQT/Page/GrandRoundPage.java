package DocquityWeb.DocQT.Page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import DocquityWeb.DocQT.TestUtils.TestUtils;


public class GrandRoundPage extends BasePage {
	
	private WebDriver driver;
	private static final Logger LOGGER = LogManager.getLogger(GrandRoundPage.class);

	public GrandRoundPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "searchBox")
	private WebElement SEARCH_BAR;
	
	@FindBy(xpath = "(//P[contains(@class,'mb-1')])[1]")
	private WebElement DISCUSSION_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[4]/a/span[2]")
	private WebElement CLINICALCASES_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[5]/a/span[2]")
	private WebElement POLL_TEXT;
	
	@FindBy(xpath = "(//P[contains(@class,'mb-1')])[2]")
	private WebElement LEARNING_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[7]/a/span[2]")
	private WebElement CPD_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[8]/a/span[2]")
	private WebElement ARTICLES_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[9]/a/span[2]")
	private WebElement DOCTALKS_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[10]/a/span[2]")
	private WebElement WEBINARS_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[11]/a/span[2]")
	private WebElement CALENDAR_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[12]/a/span[2]")
	private WebElement CONNECTION_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[13]/a/span[2]")
	private WebElement EVENTS_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[15]/a/span[2]")
	private WebElement BOOKMARKS_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[16]/a/span[2]")
	private WebElement CHANNELS_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[17]/a/span[2]")
	private WebElement PHARMA_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[18]/a/span[2]")
	private WebElement NEJM_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[19]/a/span[2]")
	private WebElement SURVEYS_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[20]/a/span[2]")
	private WebElement DRUG_SAMPLES_TEXT;
	
	@FindBy(xpath = "(//li[contains(@class,'ng-star-inserted')])[21]/a/span[2]")
	private WebElement ONLINE_EVENT_TEXT;
	
	@FindBy(xpath = "(//P[contains(@class,'mb-1')])[3]")
	private WebElement DOCQUITY_EXCLUSIVE_TEXT;
	
	@FindBy(xpath = "//button[contains(@class,'createpost-dummy')]")
	private WebElement START_A_POST;
	
	@FindBy(xpath = "//textarea[contains(@placeholder,'Share your thoughts')]")
	private WebElement SHARE_YOUR_THOUGHTS_TEXTAREA;
	
	@FindBy(xpath = "//ul[@class='d-table']/li[1]/label")
	private WebElement GALLERY_ICON;
	
	@FindBy(xpath = "//ul[@class='d-table']/li[2]/label")
	private WebElement DOCUMENTS_ICON;
	
	@FindBy(xpath = "//button[@type='button' and contains(@class,'btn-success')]")
	private WebElement NEXT_BUTTON;
	
	@FindBy(xpath = "//div[contains(@class,'profile-post')]")
	private WebElement POST_AS_BUTTON;
	
	@FindBy(xpath = "//label[contains(@class,'switch')]")
	private WebElement IS_THIS_A_CASE_SWICTH;
	
	@FindBy(xpath = "(//label[contains(@class,'checkbox-container')])[1]")
	private WebElement FIRST_SPECIALITY;
	
	@FindBy(xpath = "//button[@type='button' and contains(@class,'btn-success')]")
	private WebElement POST_BUTTON;
	
	@FindBy(xpath = "//p[contains(text(), 'This is a post')]")
	private WebElement AUTOMATION_POST;
	
	@FindBy(xpath = "//p[contains(text(),' Your post is going live, stay calm')]")
	private WebElement POST_IS_GOING_LIVE;
	
	@FindBy(xpath = "//div[@id='tempprofile']")
	private WebElement PROFILE_CARD;
	
	
	public void verifyDiscussionSectionIsVisible(final String discussionText) {
		Log.info("Verify visibility of discussion section", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, DISCUSSION_TEXT).getText(), discussionText, "Discussion section is not visible`");
	}
	
	public void verifyClinicalCaseIsVisible(final String clinicalCasesText) {
		Log.info("Verify visibility of clinical cases under the discussion", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, CLINICALCASES_TEXT).getText(), clinicalCasesText, "Clinical cases is not visible`");
	}
	
	public void verifyPollIsVisible(final String pollText) {
		Log.info("Verify visibility of poll under the discussion", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, POLL_TEXT).getText(), pollText, "Poll Text is not visible`");
	}

	public void verifyLearningSectionIsVisible(final String learningText) {
		Log.info("Verify visibility of discussion section", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, LEARNING_TEXT).getText(), learningText, "Learning section is not visible`");
	}
	
	public void verifyCPDIsVisible(final String cpdText) {
		Log.info("Verify visibility of cpd under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, CPD_TEXT).getText(), cpdText, "CPD is not visible`");
	}
	
	public void verifyArticlesIsVisible(final String articlesText) {
		Log.info("Verify visibility of articles under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, ARTICLES_TEXT).getText(), articlesText, "Artciles Text is not visible`");
	}
	
	@Override
	public GrandRoundPage waitForPage() {
		//This method will make the script wait until the page is loaded
		Log.info("Waiting for home page to be visible", LOGGER);
		TestUtils.calculatePageLoadTime(driver);
		TestUtils.waitForVisibilityOf(driver, SEARCH_BAR);
		return this;
	}

	public void verifyDoctalksIsVisible(final String doctalksText) {
		Log.info("Verify visibility of doctalks under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, DOCTALKS_TEXT).getText(), doctalksText, "Doctalks Text is not visible");	
	}

	public void verifyWebinarsIsVisible(final String webinarsText) {
		Log.info("Verify visibility of webinars under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, WEBINARS_TEXT).getText(), webinarsText, "Webinars Text is not visible");
	}

	public void verifyCalendarIsVisible(final String calendarText) {
		Log.info("Verify visibility of calendar under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, CALENDAR_TEXT).getText(), calendarText, "Calendar Text is not visible");
	}

	public void verifyConnectionIsVisible(final String connectionText) {
		Log.info("Verify visibility of connection under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, CONNECTION_TEXT).getText(), connectionText, "Connection Text is not visible");
	}
	
	public void verifyDocquityExclusiveSectionIsVisible(final String docquityExclusiveText) {
		Log.info("Verify visibility of docquity Exclusive section", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, DOCQUITY_EXCLUSIVE_TEXT).getText(), docquityExclusiveText, "Docquity exclusive text section is not visible`");
	}
	
	public void verifyEventsIsVisible(final String eventsText) {
		Log.info("Verify visibility of Events under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, EVENTS_TEXT).getText(), eventsText, "Events Text is not visible");	
	}

	public void verifyBookMarksIsVisible(final String bookMarksText) {
		Log.info("Verify visibility of BookMarks under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, BOOKMARKS_TEXT).getText(), bookMarksText, "BookMarks Text is not visible");
	}

	public void verifyChannelsIsVisible(final String channelsText) {
		Log.info("Verify visibility of channels under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, CHANNELS_TEXT).getText(), channelsText, "Channels Text is not visible");
	}

	public void verifyPharmaIsVisible(final String pharmaText) {
		Log.info("Verify visibility of pharma under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, PHARMA_TEXT).getText(), pharmaText, "Pharma Text is not visible");
	}
	
	public void verifyNEJMIsVisible(final String nejmText) {
		Log.info("Verify visibility of nejm under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, NEJM_TEXT).getText(), nejmText, "NEJM Text is not visible");
	}
	
	public void verifySurveysIsVisible(final String surveysText) {
		Log.info("Verify visibility of surveys under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, SURVEYS_TEXT).getText(), surveysText, "Surveys is not visible");
	}
	
	public void verifyDrugSamplesIsVisible(final String durgSamplesText) {
		Log.info("Verify visibility of drug samples under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, DRUG_SAMPLES_TEXT).getText(), durgSamplesText, "Drug Samples Text is not visible");
	}
	
	public void verifyOnlineEventIsVisible(final String onlineEventText) {
		Log.info("Verify visibility of online event under the learning", LOGGER);
		Assert.assertEquals(TestUtils.waitForVisibilityOf(driver, ONLINE_EVENT_TEXT).getText(), onlineEventText, "Online Event is not visible");
	}
	
	public void moveCursorToScrollBelowFeed() {
		Log.info("Move cursor to scroll under the feed", LOGGER);
		TestUtils.moveToElement(driver, LEARNING_TEXT);
	}
	
	public void scrollDownToDocquityExclusive() {
		Log.info("Scroll down till element is visible", LOGGER);
		TestUtils.scrollTillElementIsVisible(driver, ONLINE_EVENT_TEXT);
	}
	
	public void clickStartAPost() {
		Log.info("Click on the start a post", LOGGER);
		START_A_POST.click();
	}
	
	public void enterTextForPost(final String text) {
		Log.info("Entering the text in start a post " +text +TestUtils.currentDate() , LOGGER);
		TestUtils.waitForVisibilityOf(driver, SHARE_YOUR_THOUGHTS_TEXTAREA).sendKeys(text+TestUtils.currentDate());
	}
	
	public void uploadImage(final String fileName) {
		Log.info("Trying to upload the image file - " +fileName, LOGGER);
		TestUtils.uploadFile(driver, GALLERY_ICON, fileName);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadVideo(final String fileName) {
		// TODO Auto-generated method stub
		Log.info("Trying to upload the video file - " +fileName, LOGGER);
		TestUtils.uploadFile(driver, GALLERY_ICON, fileName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void uploadPdf(final String fileName) {
		// TODO Auto-generated method stub
		Log.info("Trying to upload the pdf file - " +fileName, LOGGER);
		TestUtils.uploadFile(driver, DOCUMENTS_ICON, fileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickNextButton() {
		Log.info("Trying to click on the Next Button", LOGGER);
		TestUtils.clickElementUsingJavaScriptExecutor(driver, NEXT_BUTTON);
	}
	
	public void verifyVisibilityOfisThisIsACaseSwitch() {
		Log.info("Verify if is this a case is visible", LOGGER);
		TestUtils.waitForVisibilityOf(driver, IS_THIS_A_CASE_SWICTH);
	}

	public void selectFirstSpeciality() {
		// TODO Auto-generated method stub
		Log.info("Trying to select the First Speciality from the list", LOGGER);
		TestUtils.clickElementUsingJavaScriptExecutor(driver, FIRST_SPECIALITY);
	}
	
	public void clickPostButton() {
		Log.info("Trying to click on the Post Button", LOGGER);
		TestUtils.clickElementUsingJavaScriptExecutor(driver, POST_BUTTON);
	}

	public void verifyIfPostIsVisible(final String text) {
		TestUtils.waitForElementToBeInvisible(driver, POST_IS_GOING_LIVE);
		TestUtils.scrollTillElementIsVisible(driver, AUTOMATION_POST);	
	}
	
	public boolean verifyProfileCardIsDisplayed() {
		 return PROFILE_CARD.isDisplayed();
	}
}
