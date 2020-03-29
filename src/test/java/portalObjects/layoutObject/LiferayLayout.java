package portalObjects.layoutObject;

import browserManager.DriverManager;
import org.openqa.selenium.support.PageFactory;
import portalObjects.pageObject.abstracts.LiferayPO;

public abstract class LiferayLayout {
    protected LiferayPO page;
    private String baseUrl;

    public LiferayLayout(String baseUrl) {
        PageFactory.initElements(DriverManager.getDriver(), this);
        this.baseUrl = baseUrl;
    }

    public void navigateToPage(String pageObjectClass) {
        Class<?> c= null;
        try {
            c = Class.forName("portalObjects.pageObject.".concat(pageObjectClass).concat("PO"));
            page = (LiferayPO) c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        navigateToCurrentPage();
    }

    public LiferayPO getPage() {
        return page;
    }

    public void navigateToCurrentPage() {
        page.navigateToPage(baseUrl);
    }
}
