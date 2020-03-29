package portalObjects.pageObject;

import portalObjects.pageObject.abstracts.PublicPO;

public class HomePagePO extends PublicPO {

    public HomePagePO() {
        super();
    }

    @Override
    public String getPagePath() {
        return "";
    }

    @Override
    public String getPageName() {
        return "Home";
    }

}
