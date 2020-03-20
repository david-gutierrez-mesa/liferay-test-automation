package stepDefinition;

import base.TestContext;
import io.cucumber.java8.En;
import pageObject.ConfirmationPO;
import pageObject.LiferayFormPO;
import static org.junit.Assert.*;

public class LiferayFormTest implements En {

	TestContext testContext;

	public LiferayFormTest(TestContext testContext) {
		this.testContext = testContext;

		Given("I am in Liferay Form page", () -> {
			this.testContext.setCurrentLiferayPO(new LiferayFormPO(this.testContext.getDriver()));
			((LiferayFormPO) this.testContext.getCurrentLiferayPO()).navigateToPage(this.testContext.getBaseurl());
		});

		Given("I fill name field with {string}", (String name) -> {
			((LiferayFormPO) this.testContext.getCurrentLiferayPO()).enterName(name);
		});

		Given("I fill date of birth with month {string} from this one and day {string}", (String month, String day) -> {
			((LiferayFormPO) this.testContext.getCurrentLiferayPO()).enterBirthday(month, day);
		});

		Given("I fill tell me about you field with value {string}", (String tellMeAboutYou) -> {
			((LiferayFormPO) this.testContext.getCurrentLiferayPO()).enterTellMeAboutYou(tellMeAboutYou);
		});

		When("I press submit button", () -> {
			this.testContext.setCurrentLiferayPO(((LiferayFormPO) this.testContext.getCurrentLiferayPO()).submit());
		});

		Then("I am redirected to confirmation page", () -> {
			assertTrue("We are not in expected page",
					((ConfirmationPO) this.testContext.getCurrentLiferayPO()).checkTitleIsExpectedOne());
		});

		Then("I text {string} is present", (String text) -> {
			assertTrue(((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkTextExistInPage(text));
		});

		Then("I stay in Liferay Form page", () -> {
			this.testContext.setCurrentLiferayPO(new LiferayFormPO(this.testContext.getDriver()));
			assertTrue("We are not in expected page",
					((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkTitleIsExpectedOne());
		});

		And("I get success message", () -> {
			assertTrue("Confirmation message is not present",
					((ConfirmationPO) this.testContext.getCurrentLiferayPO()).checkConfirmationMessageExist());
		});

		And("I get {string} error message for field {string}", (String message, String fieldName) -> {
			boolean checkResult;
			switch (fieldName) {
			case "name":
				checkResult = ((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkNameMessageContainsExpectedOne(message);
				break;
			case "birthday":
				checkResult = ((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkBirthdayMessageContainsExpectedOne(message);
				break;
			case "comments":
				checkResult = ((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkCommentsMessageContainsExpectedOne(message);
				break;
			default:
				throw new UnsupportedOperationException(String.format("Option %s not implemented for this step", fieldName));
			}
			assertTrue("Message is not the expected one",checkResult);
		});
		
		And("I get no error message for field {string}", (String fieldName) -> {
			boolean checkResult;
			switch (fieldName) {
			case "name":
				checkResult = ((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkNameMessageDoesNotExist();
				break;
			case "birthday":
				checkResult = ((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkBirthdayFieldMessageDoesNotExist();
				break;
			case "comments":
				checkResult = ((LiferayFormPO) this.testContext.getCurrentLiferayPO()).checkCommentsFieldMessageDoesNotExist();
				break;
			default:
				throw new UnsupportedOperationException(String.format("Option %s not implemented for this step", fieldName));
			}
			assertTrue("Message is present",checkResult);
		});
	}
}
