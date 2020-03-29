package portalObjects.pagePartsObject;

import portalObjects.layoutObject.PrivateLayout;
import portalObjects.pageObject.HomePagePO;
import portalObjects.usersObjects.RegisteredUserUO;

import static common.CommonMethods.*;
import static portalObjects.paths.LoginPaths.*;

public class LoginPPO {
    private String baseUrl;

    public LoginPPO(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public PrivateLayout doLogin(RegisteredUserUO user){
        this.openLoginPopUp();
        inputText(NAME_FIELD_ID, user.getUserName());
        inputText(PASSWORD_FIELD_ID, user.getUserPassword());
        click(SIGN_IN_BUTTON);

        return new PrivateLayout(this.baseUrl, new HomePagePO());
    }

    public void openLoginPopUp(){
        click(SIGN_IN_LINK);
        waitForElementToBeVisible(NAME_FIELD_ID);
    }

}
