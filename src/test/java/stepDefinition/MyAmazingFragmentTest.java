package stepDefinition;

import base.TestContext;
import io.cucumber.java8.En;
import pageObject.LoggedInPO;
import pageObject.MainPO;

public class MyAmazingFragmentTest implements En {

    TestContext testContext;

    public MyAmazingFragmentTest(TestContext testContext) {
        this.testContext = testContext;

        Given("^I am logged in Liferay as \"([^\"]*)\"$", (String user) -> {
            this.testContext.setCurrentLiferayPO(new MainPO(this.testContext.getDriver()));
            this.testContext.getCurrentLiferayPO().navigateToPage(this.testContext.getBaseurl());
            LoggedInPO loggedInPO =((MainPO) this.testContext.getCurrentLiferayPO()).getLoginSO().doLogin(user, "test");
            this.testContext.setCurrentLiferayPO(loggedInPO);
        });

    }
}
