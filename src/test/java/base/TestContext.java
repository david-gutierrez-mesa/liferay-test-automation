package base;

import org.openqa.selenium.WebDriver;

import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import pageObject.LiferayPO;

public class TestContext {
	private DriverManager webDriverManager;
	private DriverType DRIVER_TYPE;
	private LiferayPO currentLiferayPO;
	private String baseUrl;

	public TestContext() {
		this(DriverType.CHROME, "http://localhost:8080/");
	}

	private TestContext(DriverType driveType, String baseUrl) {
		this.DRIVER_TYPE = driveType;
		this.baseUrl = baseUrl;
		webDriverManager = DriverManagerFactory.getManager(DRIVER_TYPE);
	}

	public DriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public WebDriver getDriver() {
		return webDriverManager.getDriver();
	}

	public String getBaseurl() {
		return this.baseUrl;
	}

	public LiferayPO getCurrentLiferayPO() {
		return currentLiferayPO;
	}

	public void setCurrentLiferayPO(LiferayPO currentLiferayPO) {
		this.currentLiferayPO = currentLiferayPO;
	}

}