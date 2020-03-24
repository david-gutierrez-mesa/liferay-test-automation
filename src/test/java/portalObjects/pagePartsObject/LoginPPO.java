package portalObjects.pagePartsObject;

import browserManager.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import portalObjects.layoutObject.LiferayLayout;
import portalObjects.layoutObject.PrivateLayout;
import portalObjects.pageObject.WelcomePagePO;
import portalObjects.usersObjects.RegisteredUserUO;

import static portalObjects.paths.LoginPaths.*;

public class LoginPPO {
    protected WebDriverWait wait;

    public LoginPPO(WebDriverWait wait) {
        this.wait = wait;
    }

    public void doLogin(RegisteredUserUO user){
        this.openLoginPopUp();
        DriverManager.getDriver().findElement(NAME_FIELD_ID).clear();
        DriverManager.getDriver().findElement(NAME_FIELD_ID).sendKeys(user.getUserName());
        DriverManager.getDriver().findElement(PASSWORD_FIELD_ID).sendKeys(user.getUserPassword());
        DriverManager.getDriver().findElement(SIGN_IN_BUTTON).click();
    }

    public void openLoginPopUp(){
        DriverManager.getDriver().findElement(SIGN_IN_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_FIELD_ID));
    }

}
