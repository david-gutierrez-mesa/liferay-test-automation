package pageObject;

import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LiferayFormPO extends LiferayPO {

	private static final long WAIT_TIME_FOR_BUTTON = 2000;
	private static final String PAGE_TITLE = "This is one Liferay Forms";
	private static final String PAGE_PATH = "web/forms/shared/-/form/1246931";
	private static final String FIND_DAY_FORMAT = "//*[starts-with(@id, 'calendaryui_patched_') and substring(@id, 58)='_%s']";

	@FindBy(css = "[id*=WhatsYourName]")
	private WebElement name;

	@FindBy(css = "[id*=TellMeAboutYou]")
	private WebElement tellMeAboutYou;

	@FindBy(xpath = "//*[text()='Submit']")
	private WebElement submitButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div/div/form/div/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div/div/div/input[1]")
	private WebElement openCalendarButton;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/a[1]")
	private WebElement previousMonthButton;

	@FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/div[1]/a[2]")
	private WebElement nextMonthButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div/div/form/div/div[2]/div/div/div[1]/div/div/div[1]/div[1]/div/div/div[2]")
	private WebElement nameFieldMessage;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div/div/form/div/div[2]/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]")
	private WebElement birthdayFieldMessage;

	@FindBy(xpath = "/html/body/div[3]/div/div/div/div/div/div/div/div/form/div/div[2]/div/div/div[1]/div/div/div[2]/div/div/div/div[2]")
	private WebElement commentsFieldMessage;

	public LiferayFormPO(WebDriver driver) {
		super(driver);
	}

	@Override
	String getPagePath() {
		return null;
	}

	public void navigateToPage(String baseUrl) {
		driver.get(String.format("%s%s", baseUrl, PAGE_PATH));
	}

	public void enterName(String firstName) {
		this.name.clear();
		this.name.sendKeys(firstName);
	}

	public void enterTellMeAboutYou(String tellMeAboutYou) {
		this.tellMeAboutYou.clear();
		this.tellMeAboutYou.sendKeys(tellMeAboutYou);
	}

	public void enterBirthday(String month, String day) {
		int monthInt = Integer.parseInt(month);

		this.openCalendarButton.click();

		if (monthInt != 0) {
			WebElement buttonToClick;
			int iterations;
			if (monthInt < 0) {
				buttonToClick = this.previousMonthButton;
				iterations = -1 * monthInt;
			} else {
				buttonToClick = this.nextMonthButton;
				iterations = monthInt;
			}
			IntStream.rangeClosed(0, iterations).forEach(i -> buttonToClick.click());
		}
		By dayToSelect = By.xpath(String.format(FIND_DAY_FORMAT, day));
		wait.until(ExpectedConditions.visibilityOfElementLocated(dayToSelect)).click();
	}

	public ConfirmationPO submit() {
		wait.until(ExpectedConditions.elementToBeClickable(this.submitButton));
		try {
			Thread.sleep(WAIT_TIME_FOR_BUTTON);
			this.submitButton.click();
			Thread.sleep(WAIT_TIME_FOR_BUTTON);
		} catch (InterruptedException e) {
			System.out.println(String.format("Sleep interrupted with message: %s", e.getMessage()));
		}
		return new ConfirmationPO(this.driver);
	}

	public boolean checkTitleIsExpectedOne() {
		return checkTitleIs(PAGE_TITLE);
	}

	public boolean checkNameMessageContainsExpectedOne(String expectedMessage) {
		return this.nameFieldMessage.getText().contains(expectedMessage);
	}

	public boolean checkBirthdayMessageContainsExpectedOne(String expectedMessage) {
		return this.birthdayFieldMessage.getText().contains(expectedMessage);
	}

	public boolean checkCommentsMessageContainsExpectedOne(String expectedMessage) {
		return this.commentsFieldMessage.getText().contains(expectedMessage);
	}

	public boolean checkNameMessageDoesNotExist() {
		return checkMessageDoesNotExistForElement(this.nameFieldMessage);
	}

	public boolean checkBirthdayFieldMessageDoesNotExist() {
		return checkMessageDoesNotExistForElement(this.birthdayFieldMessage);
	}

	public boolean checkCommentsFieldMessageDoesNotExist() {
		return checkMessageDoesNotExistForElement(this.commentsFieldMessage);
	}

	private boolean checkMessageDoesNotExistForElement(WebElement element) {
		boolean result;
		try {
			result = !element.isDisplayed();
		} catch (NoSuchElementException ex) {
			result = true;
		}
		return result;
	}
}
