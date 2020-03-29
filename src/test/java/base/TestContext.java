package base;

import portalObjects.layoutObject.LiferayLayout;
import portalObjects.usersObjects.RegisteredUserUO;

public class TestContext {
	private LiferayLayout currentLiferayPO;
	private String baseUrl;
	private RegisteredUserUO user;

	public TestContext() {
		this("http://localhost:8080/");
	}

	private TestContext(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public LiferayLayout getCurrentLiferayPO() {
		return currentLiferayPO;
	}

	public RegisteredUserUO getUser() {
		return user;
	}

	public void setCurrentLiferayPO(LiferayLayout currentLiferayPO) {
		this.currentLiferayPO = currentLiferayPO;
	}

	public void setUser(RegisteredUserUO user) {
		this.user = user;
	}
}