package portalObjects.pagePartsObject;

import portalObjects.layoutObject.PrivateLayout;
import portalObjects.pageObject.HomePagePO;
import portalObjects.usersObjects.RegisteredUserUO;

import java.net.URL;

import static browserManager.CommonMethods.*;
import static portalObjects.paths.LoginPaths.*;

public class LoginPPO {
    private URL baseUrl;

    public LoginPPO(URL baseUrl) {
        this.baseUrl = baseUrl;
    }

    public PrivateLayout doLogin(RegisteredUserUO user) {
        this.openLoginPopUp();
        inputText(NAME_FIELD_ID, user.getEmail());
        inputText(PASSWORD_FIELD_ID, user.getPassword());
        click(SIGN_IN_BUTTON);

        return new PrivateLayout(this.baseUrl, new HomePagePO());
    }

    public void openLoginPopUp() {
        click(SIGN_IN_LINK);
        waitForElementToBeVisible(NAME_FIELD_ID);
    }

}
