package portalObjects.layoutObject;

import portalObjects.pageObject.abstracts.LiferayPO;

public class PrivateLayout extends LiferayLayout {

    public PrivateLayout(String baseUrl, LiferayPO pageObject) {
        super(baseUrl);
        page = pageObject;
    }

    //
    // Common Page Parts for logged in users by composition. For example menus
    //

}
