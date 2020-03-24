package portalObjects.pageObject.abstracts;

import browserManager.DriverManager;

public abstract class LiferayPO {

	public LiferayPO() {
	}

	public abstract String getPagePath();

	public void navigateToPage(String baseUrl) {
		DriverManager.getDriver().get(String.format("%s%s", baseUrl, this.getPagePath()));
	}
}
