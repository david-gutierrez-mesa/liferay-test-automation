package stepDefinition;

import base.TestContext;
import browserManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseTest {
    private static boolean firstExecution = false;
    protected TestContext testContext;

    public BaseTest(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() {
        if (!firstExecution) {
            Runtime.getRuntime().addShutdownHook(new Thread(DriverManager::quitDriver));
            firstExecution = true;
        }
    }

    @After
    public void tearDown() {
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().navigate().refresh();
    }
}
