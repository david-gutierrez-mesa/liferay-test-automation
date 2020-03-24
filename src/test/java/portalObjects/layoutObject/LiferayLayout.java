package portalObjects.layoutObject;

import browserManager.DriverManager;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import portalObjects.pageObject.abstracts.LiferayPO;

public abstract class LiferayLayout {
    private static final int WAIT_TIME_IN_SECONDS = 60;
    protected WebDriverWait wait;
    protected LiferayPO page;
    private String baseUrl;

    public LiferayLayout(String baseUrl) {
        wait = new WebDriverWait(DriverManager.getDriver(), WAIT_TIME_IN_SECONDS);
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
