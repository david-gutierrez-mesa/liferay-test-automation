package portalObjects.pageObject;

import portalObjects.pageObject.abstracts.PrivatePO;
import portalObjects.pagePartsObject.MyAmazingFragmentPPO;

public class MyAmazingPagePO extends PrivatePO {
    private MyAmazingFragmentPPO myAmazingFragmentPPO;

    public MyAmazingPagePO() {
        myAmazingFragmentPPO = new MyAmazingFragmentPPO();
    }

    @Override
    public String getPagePath() {
        return "group/guest/my-amazing-page/";
    }

    @Override
    public String getPageName() {
        return "My Amazing Page";
    }


    public MyAmazingFragmentPPO getMyAmazingFragmentPPO() {
        return myAmazingFragmentPPO;
    }
}
