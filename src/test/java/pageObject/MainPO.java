package pageObject;

import pagePartsObject.LoginPPO;

public class MainPO extends LiferayPO {

    private LoginPPO loginPPO;

    public MainPO() {
        super();
        loginPPO = new LoginPPO(wait);
    }

    @Override
    String getPagePath() {
        return "";
    }

    public LoginPPO getLoginPPO() {
        return loginPPO;
    }
}
