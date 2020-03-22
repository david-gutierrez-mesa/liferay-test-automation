package stepDefinition;

import base.TestContext;
import browserManager.DriverManager;
import io.cucumber.java.After;

public class BaseTest {
	TestContext testContext;

	public BaseTest(TestContext testContext) {
		this.testContext = testContext;
	}

	@After
	public void tearDown() {
		DriverManager.getDriver().manage().deleteAllCookies();
		DriverManager.getDriver().navigate().refresh();
	}
}
