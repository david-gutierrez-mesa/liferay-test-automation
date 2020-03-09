package base;

import org.openqa.selenium.WebDriver;

import browserManager.DriverManager;
import browserManager.DriverManagerFactory;
import browserManager.DriverType;
import pageObject.PageObject;

public class TestContext {
	private DriverManager webDriverManager;
	private DriverType DRIVER_TYPE;
	private PageObject currentPageObject;
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

	public PageObject getCurrentPageObject() {
		return currentPageObject;
	}

	public void setCurrentPageObject(PageObject currentPageObject) {
		this.currentPageObject = currentPageObject;
	}

}