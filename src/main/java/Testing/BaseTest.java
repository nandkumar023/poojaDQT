package Testing;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	
	public WebDriver driver;
	
	@BeforeClass
	public void LaunchBrowser() {
	WebDriverManager.chromedriver().setup();
	
	
	}

}
