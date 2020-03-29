package browserManager;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class DriverManager {

	private static final String BROWSER_PROPERTY = "browser";
	private static final long IMPLICIT_WAIT_TIME = 10;
	private static final int WAIT_TIME_IN_SECONDS = 60;

	private static DriverManager driverManager = null;

	private DriverManagerType type;
	private WebDriver driver;
	private WebDriverWait wait;


	private DriverManager() {
		String browser = System.getProperty(BROWSER_PROPERTY);

		if ((browser == null) || (browser.equals(""))) {
			this.type = CHROME;
		}
		else {
			this.type = DriverManagerType.valueOf(System.getProperty(BROWSER_PROPERTY).toUpperCase());
		}
	}

	protected static void createDriver(){
		if (getInstance().type == DriverManagerType.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			getInstance().driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			getInstance().driver = new ChromeDriver();
		}

		getInstance().driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);

	}

	public static WebDriver getDriver() {
		if (null == getInstance().driver) {
			createDriver();
		}

		return getInstance().driver;

	}

	public static DriverManager getInstance() {
		if (driverManager == null) {
			driverManager = new DriverManager();
		}

		return driverManager;
	}

	public static WebDriverWait getWait() {
		if (null == getInstance().wait) {
			getInstance().wait = new WebDriverWait(DriverManager.getDriver(), WAIT_TIME_IN_SECONDS);
		}

		return getInstance().wait;
	}

	public static void quitDriver() {
		if (null != getInstance().driver) {
			getInstance().driver.quit();
			getInstance().driver = null;
		}

	}
}
