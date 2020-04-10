package utils.JSON;

import com.liferay.poshi.runner.util.PropsUtil;

public class Generic {
    static final String ADMIN_USER_EMAIL = "test@liferay.com";
    static final String ADMIN_USER_PASSWORD = "test";

    private Generic() {
    }

    public static String getPortalURL() {
        return PropsUtil.get("portal.url");
    }

    public static String getPortalInstanceName() {
        String testPortalInstance = PropsUtil.get("test.portal.instance");

        if ("true".equals(testPortalInstance)) {
            String portalURL = getPortalURL();
            return testPortalInstance.replace("http://", "").replace(":8080", "");
        } else {
            return "localhost";
        }
    }
}
