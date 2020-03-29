package portalObjects.pageObject;

import portalObjects.pageObject.abstracts.PrivatePO;

public class MyAmazingPagePO extends PrivatePO {
    public MyAmazingPagePO() {
    }

    @Override
    public String getPagePath() {
        return "group/guest/my-amazing-page/";
    }

    @Override
    public String getPageName() {
        return "My Amazing Page";
    }
}
