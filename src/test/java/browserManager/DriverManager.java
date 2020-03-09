package browserManager;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

	private static OSType OS = null;
	protected WebDriver driver;
	protected static final Path DRIVERS_PATH = Paths.get("src", "test", "resources", "drivers");

	protected enum OSType {
		WINDOWS, MAC, LINUX
	}

	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}

	}

	public WebDriver getDriver() {
		if (null == driver) {
			createDriver();
		}
		return driver;
	}

	protected abstract void createDriver();

	protected static OSType getOs() {
		String operativeSystem = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
		if (OS == null) {
			if ((operativeSystem.contains("mac")) || (operativeSystem.contains("darwin"))) {
				OS = OSType.MAC;
			} else if (operativeSystem.contains("win")) {
				OS = OSType.WINDOWS;
			} else if (operativeSystem.contains("nux")) {
				OS = OSType.LINUX;
			}
		}
		return OS;
	}

}
