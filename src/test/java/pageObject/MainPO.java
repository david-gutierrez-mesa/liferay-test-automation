package pageObject;

import org.openqa.selenium.WebDriver;
import sectionObject.LoginSO;

public class MainPO extends LiferayPO {

    private LoginSO loginSO;

    public MainPO(WebDriver driver) {
        super(driver);
        loginSO = new LoginSO(driver, wait);
    }

    @Override
    String getPagePath() {
        return "";
    }

    public LoginSO getLoginSO() {
        return loginSO;
    }
}
