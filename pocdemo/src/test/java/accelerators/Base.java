package accelerators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Property;

public class Base {

	public static WebDriver driver;
	public static Property configProps = new Property(
			System.getProperty("user.dir") + File.separator + "config.properties");
	public static String browser;
	public static XSSFSheet objInputSheet, objAssertionSheet = null;
	public List<String> data = new ArrayList<String>();

	@BeforeMethod
	public void setUp()
			throws Throwable {
		
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("ignore-certificate-errors");
			options.addArguments("--incognito");
			options.addArguments("start-maximized");
			options.addArguments("enable-automation");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--disable-browser-side-navigation");
			options.addArguments("--disable-gpu");
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-gpu");
			options.addArguments("disable-features=NetworkService");
			options.addArguments("--force-device-scale-factor=1");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			//driver.get(configProps.getProperty("URL"));
		}
		

	@AfterMethod
	public void quitebrowser(ITestResult result) throws IOException {
				driver.quit();
	}

	@AfterTest
	public void quitbrowser() throws IOException {
		//ExcelDataProvider.closeworkbook();
	}
	
	public static void main(String[] args) {
		System.out.println(System.getProperty("ENVIRONMENT"));
	}

}
