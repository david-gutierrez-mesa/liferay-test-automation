package stepDefinition;

import base.TestContext;
import io.cucumber.java.Before;
import io.cucumber.java8.En;
import portalObjects.layoutObject.PrivateLayout;
import portalObjects.layoutObject.PublicLayout;
import portalObjects.pageObject.HomePagePO;
import portalObjects.pageObject.MyAmazingPagePO;
import portalObjects.pageObject.abstracts.PrivatePO;
import portalObjects.usersObjects.RegisteredUserUO;
import portalObjects.usersObjects.UserFactory;
import portalObjects.usersObjects.UserTypes;
import utils.JSON.Users;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static junit.framework.TestCase.assertTrue;
import static utils.JSON.Users.deleteUser;

public class MyAmazingFragmentTest implements En {

    private static boolean firstExecution = false;
    protected TestContext testContext;

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

        When("^I navigate to \"([^\"]*)\"$", (String page) -> {
            this.testContext.getCurrentLiferayPO().navigateToPage(page);
            assertTrue(((PrivatePO) this.testContext.getCurrentLiferayPO().getPage()).assertPageIsCorrect());
        });
        Then("^I can see my name$", () -> {
            String myName = testContext.getUser().getFirstName();
            assertTrue(((MyAmazingPagePO) this.testContext.getCurrentLiferayPO().getPage()).getMyAmazingFragmentPPO().assertFirstNameIs(myName));
        });
        Then("^I can see my e-mail$", () -> {
            String myEmail = testContext.getUser().getEmail();
            assertTrue(((MyAmazingPagePO) this.testContext.getCurrentLiferayPO().getPage()).getMyAmazingFragmentPPO().assertEmailIs(myEmail));
        });

    }

    @Before
    public void beforeAll() throws IOException, TimeoutException {
        if (!firstExecution) {
            RegisteredUserUO user = UserFactory.getUser(UserTypes.STANDARD_USER);
            Runtime.getRuntime().addShutdownHook(new Thread() {
                public void run() {
                    try {
                        deleteUser(user);
                    } catch (IOException | TimeoutException e) {
                        e.printStackTrace();
                    }
                }
            });
            Users.createUser(user);
            Users.addUserToASiteByEmail(user.getEmail(), "Guest");
            firstExecution = true;
        }
    }
}
