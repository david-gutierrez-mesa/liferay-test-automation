package portalObjects.pageObject.abstracts;

import java.net.URL;

import static common.CommonMethods.getPageTitle;
import static common.CommonMethods.navigateTo;

public abstract class LiferayPO {

    public LiferayPO() {
    }

    public boolean assertPageIsCorrect() {
        return getPageTitle().contains(getPageName());
    }

    public abstract String getPagePath();

    public abstract String getPageName();

    public void navigateToPage(URL baseUrl) {
        navigateTo(baseUrl, this.getPagePath());
    }

}
