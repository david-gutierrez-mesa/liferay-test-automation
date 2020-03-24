package stepDefinition;

import base.TestContext;
import io.cucumber.java8.En;
import portalObjects.layoutObject.PublicLayout;
import portalObjects.pageObject.WelcomePagePO;
import portalObjects.usersObjects.RegisteredUserUO;
import portalObjects.usersObjects.UserFactory;
import portalObjects.usersObjects.UserTypes;

public class MyAmazingFragmentTest implements En {

    TestContext testContext;

    public MyAmazingFragmentTest(TestContext testContext) {
        this.testContext = testContext;

        Given("^I am logged in Liferay as \"([^\"]*)\"$", (UserTypes userType) -> {
            RegisteredUserUO user = UserFactory.getUser(userType);
            this.testContext.setUser(user);

            this.testContext.setCurrentLiferayPO(new PublicLayout(this.testContext.getBaseUrl(), new WelcomePagePO()));
            this.testContext.getCurrentLiferayPO().navigateToCurrentPage();

           ((PublicLayout) this.testContext.getCurrentLiferayPO()).getLoginPPO().doLogin(this.testContext.getUser());
        });
        And("^I navigate to \"([^\"]*)\"$", (String page) -> {
            this.testContext.getCurrentLiferayPO().navigateToPage(page);
        });

    }
}
