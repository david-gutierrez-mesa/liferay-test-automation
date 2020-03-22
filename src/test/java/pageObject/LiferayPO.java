package pageObject;

import browserManager.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class LiferayPO {
	private static final int WAIT_TIME_IN_SECONDS = 60;
	protected WebDriverWait wait;

	public LiferayPO() {
		wait = new WebDriverWait(DriverManager.getDriver(), WAIT_TIME_IN_SECONDS);
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	abstract String getPagePath();

	public void navigateToPage(String baseUrl) {
		DriverManager.getDriver().get(String.format("%s%s", baseUrl, this.getPagePath()));
	}
}
