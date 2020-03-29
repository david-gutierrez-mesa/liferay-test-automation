package stepDefinition;

import base.TestContext;
import io.cucumber.java8.En;
import portalObjects.layoutObject.PrivateLayout;
import portalObjects.layoutObject.PublicLayout;
import portalObjects.pageObject.HomePagePO;
import portalObjects.pageObject.abstracts.PrivatePO;
import portalObjects.usersObjects.RegisteredUserUO;
import portalObjects.usersObjects.UserFactory;
import portalObjects.usersObjects.UserTypes;

import static junit.framework.TestCase.assertTrue;

public class MyAmazingFragmentTest implements En {

    TestContext testContext;

    public MyAmazingFragmentTest(TestContext testContext) {
        this.testContext = testContext;

        Given("^I am logged in Liferay as \"([^\"]*)\"$", (UserTypes userType) -> {
            RegisteredUserUO user = UserFactory.getUser(userType);
            this.testContext.setUser(user);

            this.testContext.setCurrentLiferayPO(new PublicLayout(this.testContext.getBaseUrl(), new HomePagePO()));
            this.testContext.getCurrentLiferayPO().navigateToCurrentPage();

            this.testContext.setCurrentLiferayPO(((PublicLayout) this.testContext.getCurrentLiferayPO()).getLoginPPO().doLogin(this.testContext.getUser()));

            assertTrue(((PrivateLayout) this.testContext.getCurrentLiferayPO()).stickerOverlayIsDisplayed());
        });

        And("^I navigate to \"([^\"]*)\"$", (String page) -> {
            this.testContext.getCurrentLiferayPO().navigateToPage(page);
            assertTrue(((PrivatePO)this.testContext.getCurrentLiferayPO().getPage()).assertPageIsCorrect());
        });

    }
}
