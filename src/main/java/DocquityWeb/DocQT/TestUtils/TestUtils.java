package DocquityWeb.DocQT.TestUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import DocquityWeb.DocQT.Page.Log;

/**
 * @author SarabjitSingh
 *
 */
public class TestUtils {
	
	public static int PAGE_LOAD_TIMEOUT=20;
	public static int IMPLICIT_WAIT=30;
	private static final Logger LOGGER = LogManager.getLogger(TestUtils.class);
	
	public static void performRightClick(WebElement element, WebDriver driver) {
		Log.debug("Trying to perform right click", LOGGER);
		Actions actions = new Actions(driver);
		WebElement elementLocator = element;
		actions.contextClick(elementLocator).perform();
	}
	
	public static void performAcceptAlert(WebDriver driver) {
		Log.debug("Trying to accept alert", LOGGER);
		driver.switchTo().alert().accept();
	}
	
	public static void refresh(WebDriver driver) {
		Log.debug("Trying to refresh the Page", LOGGER);
		driver.navigate().refresh();
	}
	
	public static WebElement waitForVisibilityOf(WebDriver driver, WebElement element) {
		Log.debug("Waiting for element to be visible", LOGGER);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
		Log.debug("Waiting for element to be clickable ", LOGGER);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}
	
	public static void waitTillAlertIsPresent(WebDriver driver) {
		Log.debug("Waiting for alert to be present ", LOGGER);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
	Log.debug("Waiting for element to be invisible", LOGGER);
	WebDriverWait wait= new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void calculatePageLoadTime(WebDriver driver) {
		Log.debug("Calculating the page load time", LOGGER);
		double loadTime=0;
		WebDriverWait wait= new WebDriverWait(driver, 60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // time of the process of navigation and page load
	    loadTime = (Double) js.executeScript(
	        "return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
	    Log.info("Page load time calculated in seconds is "+loadTime , LOGGER);
	}
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		Log.debug("Moving to element", LOGGER);
		Actions action = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		action.moveToElement(element);
	}

	public static void scrollTillElementIsVisible(WebDriver driver, WebElement element) {
		Log.debug("Scroll till element is visible", LOGGER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void uploadFile(WebDriver driver, WebElement element, final String fileName) {
		Log.debug("Trying to upload the file - " + fileName, LOGGER);
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\TestUploadFiles\\" + fileName;
		waitForElementToBeClickable(driver, element);
		// file path passed as parameter to StringSelection
		StringSelection ss = new StringSelection(path);
		// Clipboard copy
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		// Robot Object Creation
		try {
			Robot r = new Robot();
			r.delay(2000);
			// pressing enter
			r.keyPress(KeyEvent.VK_ENTER);
			// releasing enter
			r.keyRelease(KeyEvent.VK_ENTER);
			// pressing ctrl+v
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			// releasing ctrl+v
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			// pressing enter
			r.keyPress(KeyEvent.VK_ENTER);
			// releasing enter
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clickElementUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
		Log.debug("Trying to click element using JavaScript Executor", LOGGER);
		waitForVisibilityOf(driver, element);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	public static String currentDate() {
		Log.debug("Returning the current date", LOGGER);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		return formatter.format(date);
	}
}
