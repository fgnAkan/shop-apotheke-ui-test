package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;


public class Driver {
	protected static WebDriver driver;
	protected static WebDriver wait;
	protected static BrowserTypeEnum browserType=BrowserTypeEnum.chrome;
	
	public Driver(BrowserTypeEnum browser) {
	browserType=browser;
	}
	
	@BeforeClass
	public void getDriver() {
		switch(browserType) {
		case chrome:
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			driver=new ChromeDriver();
			break;
		case firefox:
			System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
			driver=new FirefoxDriver();
			break;
			default:
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
				driver=new ChromeDriver();
				break;
		}
		driver.get("https://www.shop-apotheke.com/nl/login.htm");
		driver.manage().window().maximize();
	}
}
