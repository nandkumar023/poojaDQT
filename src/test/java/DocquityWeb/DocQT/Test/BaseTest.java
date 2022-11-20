/**
 * 
 */
package DocquityWeb.DocQT.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import DocquityWeb.DocQT.Page.Log;
import DocquityWeb.DocQT.TestUtils.EmailTestReportUtilities;
import DocquityWeb.DocQT.TestUtils.TestUtils;
import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * @author SarabjitSingh
 *
 */
public abstract class BaseTest {
	
	public WebDriver driver;
	public static Properties prop;
	public File folder;
	public String PostURL;
	//public static ExtentReports extent;
	//public static ExtentTest extentLogger; //helps to generate logs in extent test report
	//public static ExtentHtmlReporter reporter;
	
	private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
	
	public BaseTest() {
			
			try {
				LOGGER.debug("<br>*******************        Loading Properties File        ****************************");
				prop= new Properties();
				FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config.properties");
				prop.load(fis);
			}
			catch(Exception e) {
				e.getMessage();
			}
		}
	
	 @BeforeSuite (alwaysRun = true)
	 public void beforeSuite() {
		 
	 }
	 
	 @BeforeTest  (alwaysRun = true)
	 public void beforeTest() {
		 Log.initialiseExtentReport(LOGGER);
	 }
	 
	 @AfterTest (alwaysRun = true)
	 public void tearDownAfterTest() {
		 Log.flushExtent(LOGGER);
		 
	 }
	
	@BeforeMethod (alwaysRun = true)
	public void initialization() {
		LOGGER.debug("<br>*******************        Initializing Browser       ****************************");
		String browserName=System.getProperty("browser",prop.getProperty("defaultBrowser"));
		switch(browserName) {
		case "Chrome":
			LOGGER.info("<br>*******************        Opening Chrome Browser       ***************************");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("start-maximized");
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        options.addArguments("--incognito");
	        driver = new ChromeDriver(options);
			break;
		case "Firefox":
			LOGGER.info("<br>*******************        Opening Firefox Browser       ***************************");
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case "IE":
			LOGGER.info("<br>*******************        Opening IE Browser       ***************************");
			WebDriverManager.iedriver().setup();
			driver= new InternetExplorerDriver();
			break;
		default:
			throw new IllegalStateException("Invalid browser name: "+browserName);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		PostURL=prop.getProperty("url");
	}
	
	public abstract void afterTest();
	
	@BeforeMethod (alwaysRun = true)
	public void beforeMethod(Method method) {
		Log.extentLogger= Log.extent.createTest(method.getName());
		LOGGER.debug("<br>****************************************************************************************");
		LOGGER.debug("<br>****************************************************************************************");
		LOGGER.debug("<br>$$$$$$$$$$$$$$$$$$$$              " + method.getName() + "       $$$$$$$$$$$$$$$$$$$$$$$");
		LOGGER.debug("<br>****************************************************************************************");
		LOGGER.debug("<br>****************************************************************************************");
	}

	@AfterMethod (alwaysRun = true)
	public void afterMethod(Method method, ITestResult result) throws IOException {
		Log.afterMethodLogResult(method, result, driver);
		LOGGER.debug("<br>XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
		LOGGER.debug("<br>X");
		LOGGER.debug("<br>X");
		LOGGER.debug("<br>X");
		afterTest();
	}
	
	@AfterClass (alwaysRun = true)
	public void afterMainClass() {
		LOGGER.debug("*******************    Driver Quit    *********************************");
		driver.quit();
	}
	
	@AfterSuite (alwaysRun = true)
	public void afterSuite() {
		LOGGER.debug("******************    Executing After Suites   ********************************");
		//EmailTestReportUtilities.SendMailSSLWithTestReport();
	}

}
