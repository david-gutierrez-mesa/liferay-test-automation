package portalObjects.layoutObject;

import portalObjects.pageObject.abstracts.PublicPO;
import portalObjects.pagePartsObject.LoginPPO;

public class PublicLayout extends LiferayLayout{

    private LoginPPO loginPPO;

    public PublicLayout(String baseUrl, PublicPO pageObject) {
        super(baseUrl);
        loginPPO = new LoginPPO(wait);
        page = pageObject;
    }


    //
    // Common Page Parts when not logged in by composition
    //

    public LoginPPO getLoginPPO() {
        return loginPPO;
    }

}
