package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPO extends LiferayPO {

	private static final String PAGE_TITLE = "Form - Forms";
	private static final String CONFORMATION_MESSAGE = "Your information was successfully received. Thank you for filling out the form.";

	public ConfirmationPO(WebDriver driver) {
		super(driver);
	}

	@Override
	String getPagePath() {
		return null;
	}

	public boolean checkConfirmationMessageExist() {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText.contains(CONFORMATION_MESSAGE);
	}

	public boolean checkTitleIsExpectedOne() {
		return checkTitleIs(PAGE_TITLE);
	}
}
