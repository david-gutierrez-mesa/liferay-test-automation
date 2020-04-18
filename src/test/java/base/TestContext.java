package base;

import portalObjects.layoutObject.LiferayLayout;
import portalObjects.usersObjects.RegisteredUserUO;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.tools.SystemProperties.getUrl;

public class TestContext {
    private static final String DEFAULT_URL = "http://localhost:8080/";

    private LiferayLayout currentLiferayPO;
    private URL baseUrl;
    private RegisteredUserUO user;

    public TestContext() throws MalformedURLException {
        URL url = getUrl();
        if (url == null) {
            url = new URL(DEFAULT_URL);

        }
        this.baseUrl = url;

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