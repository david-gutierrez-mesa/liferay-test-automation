package base;

import portalObjects.layoutObject.LiferayLayout;
import portalObjects.usersObjects.RegisteredUserUO;

import java.net.MalformedURLException;
import java.net.URL;

public class TestContext {
    private LiferayLayout currentLiferayPO;
    private URL baseUrl;
    private RegisteredUserUO user;

    public TestContext() throws MalformedURLException {
        this(new URL("http://localhost:8080/"));
    }

    private TestContext(URL baseUrl) {
        this.baseUrl = baseUrl;
    }

    public URL getBaseUrl() {
        return this.baseUrl;
    }

    public LiferayLayout getCurrentLiferayPO() {
        return currentLiferayPO;
    }

    public void setCurrentLiferayPO(LiferayLayout currentLiferayPO) {
        this.currentLiferayPO = currentLiferayPO;
    }

    public RegisteredUserUO getUser() {
        return user;
    }

    public void setUser(RegisteredUserUO user) {
        this.user = user;
    }
}