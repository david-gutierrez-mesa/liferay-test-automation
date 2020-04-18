package portalObjects.layoutObject;

import portalObjects.pageObject.abstracts.LiferayPO;

import java.net.URL;

import static browserManager.CommonMethods.isElementPresent;
import static portalObjects.paths.PrivateLayoutPaths.stickerOverlayLocator;

public class PrivateLayout extends LiferayLayout {

    public PrivateLayout(URL baseUrl, LiferayPO pageObject) {
        super(baseUrl);
        page = pageObject;
    }

    //
    // Common Page Parts for logged in users by composition. For example menus
    //

    public boolean stickerOverlayIsDisplayed() {
        return (isElementPresent(stickerOverlayLocator));
    }
}
