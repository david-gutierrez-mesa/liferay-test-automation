package browserManager;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

public class DriverManager {

	private static final String BROWSER_PROPERTY = "browser";

	private static DriverManager driverManager = null;
	private WebDriver driver;
	private DriverManagerType type;

	private DriverManager() {
		String browser = System.getProperty(BROWSER_PROPERTY);
		if ((browser == null) || (browser.equals(""))) {
			this.type = CHROME;
		}
		else {
			this.type = DriverManagerType.valueOf(System.getProperty(BROWSER_PROPERTY).toUpperCase());
		}
	}

	public static DriverManager getInstance() {
		if (driverManager == null) {
			driverManager = new DriverManager();
		}
		return driverManager;
	}

	public static void quitDriver() {
		if (null != getInstance().driver) {
			getInstance().driver.quit();
			getInstance().driver = null;
		}

	}

	public static WebDriver getDriver() {
		if (null == getInstance().driver) {
			createDriver();
		}
		return getInstance().driver;
	}

	protected static void createDriver(){
		if (getInstance().type == DriverManagerType.FIREFOX) {
			WebDriverManager.firefoxdriver().setup();
			getInstance().driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			getInstance().driver = new ChromeDriver();
		}
	}
}
