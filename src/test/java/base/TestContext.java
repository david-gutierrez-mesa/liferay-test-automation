package base;

import pageObject.LiferayPO;
import users.RegisteredUser;

public class TestContext {
	private LiferayPO currentLiferayPO;
	private String baseUrl;
	private RegisteredUser user;

	public TestContext() {
		this("http://localhost:8080/");
	}

	private TestContext(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getBaseUrl() {
		return this.baseUrl;
	}

	public LiferayPO getCurrentLiferayPO() {
		return currentLiferayPO;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setCurrentLiferayPO(LiferayPO currentLiferayPO) {
		this.currentLiferayPO = currentLiferayPO;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}
}