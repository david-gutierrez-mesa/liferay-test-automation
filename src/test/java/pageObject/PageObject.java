package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
	private static final int WAIT_TIME_IN_SECONDS = 60;
	protected WebDriver driver;
	protected WebDriverWait wait;

	public PageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, WAIT_TIME_IN_SECONDS);
		PageFactory.initElements(driver, this);
	}

	public boolean checkTextExistInPage(String message) {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		return bodyText.contains(message);
	}

	public boolean checkTitleIs(String title) {
		return driver.getTitle().contains(title);
	}
}
