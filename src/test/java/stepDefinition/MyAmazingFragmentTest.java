package stepDefinition;

import base.TestContext;
import io.cucumber.java8.En;
import pageObject.MainPO;
import users.RegisteredUser;
import users.UserFactory;
import users.UserTypes;

public class MyAmazingFragmentTest implements En {

    TestContext testContext;

    public MyAmazingFragmentTest(TestContext testContext) {
        this.testContext = testContext;

        Given("^I am logged in Liferay as \"([^\"]*)\"$", (UserTypes userType) -> {
            RegisteredUser user = UserFactory.getUser(userType);
            this.testContext.setUser(user);

            this.testContext.setCurrentLiferayPO(new MainPO());
            this.testContext.getCurrentLiferayPO().navigateToPage(this.testContext.getBaseUrl());

            this.testContext.setCurrentLiferayPO(((MainPO) this.testContext.getCurrentLiferayPO()).getLoginPPO().doLogin(this.testContext.getUser()));
        });

    }
}
