package stepDefinition;

import base.TestContext;
import io.cucumber.java.After;

public class BaseTest {
	TestContext testContext;

	public BaseTest(TestContext testContext) {
		this.testContext = testContext;
	}

	@After
	public void tearDown() {
		this.testContext.getWebDriverManager().quitDriver();
	}
}
