package browserManager;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager extends DriverManager {
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	@Override
	public void createDriver() {
		switch (getOs()) {
		case WINDOWS:
			System.setProperty(CHROME_DRIVER_PROPERTY, DRIVERS_PATH.resolve("chromedriver.exe").toString());
			break;
		case LINUX:
			System.setProperty(CHROME_DRIVER_PROPERTY, DRIVERS_PATH.resolve("chromedriver_unix").toString());
			break;
		case MAC:
			System.setProperty(CHROME_DRIVER_PROPERTY, DRIVERS_PATH.resolve("chromedriver_mac").toString());
			break;
		}
		driver = new ChromeDriver();
	}
}
