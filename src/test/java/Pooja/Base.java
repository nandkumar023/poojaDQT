package Pooja;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	static Function<WebDriver,Boolean> testconditioWait;
	static WebDriverWait wait;
	
	@BeforeClass (alwaysRun = true)
	public void pj() {
	WebDriverManager.chromedriver().setup();	
	driver = new ChromeDriver();
	driver.get("http://website.docquity.com/");
	}
	
	public  static void wait (List<WebElement> element, String exception) throws Exception {
		try {
			testconditioWait = x-> element.size()>0;
			wait=new WebDriverWait(driver, 2000);
			wait.until(testconditioWait);
		}
		catch (Exception e){
			throw new Exception(exception);
		}
	
	
	}

}
