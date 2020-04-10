package portalObjects.layoutObject;

import portalObjects.pageObject.abstracts.PublicPO;
import portalObjects.pagePartsObject.LoginPPO;

import java.net.URL;

public class PublicLayout extends LiferayLayout {

    private LoginPPO loginPPO;

    public PublicLayout(URL baseUrl, PublicPO pageObject) {
        super(baseUrl);
        loginPPO = new LoginPPO(baseUrl);
        page = pageObject;
    }


    //
    // Common Page Parts when not logged in by composition
    //

    public LoginPPO getLoginPPO() {
        return loginPPO;
    }

}
