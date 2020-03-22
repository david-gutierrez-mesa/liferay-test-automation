package pagePartsObject;

import browserManager.DriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LoggedInPO;
import users.RegisteredUser;

import static paths.LiferayPaths.*;

public class LoginPPO {
    protected WebDriverWait wait;

    public LoginPPO(WebDriverWait wait) {
        this.wait = wait;
    }

    public LoggedInPO doLogin(RegisteredUser user){
        this.openLoginPopUp();
        DriverManager.getDriver().findElement(NAME_FIELD_ID).clear();
        DriverManager.getDriver().findElement(NAME_FIELD_ID).sendKeys(user.getUserName());
        DriverManager.getDriver().findElement(PASSWORD_FIELD_ID).sendKeys(user.getUserPassword());
        DriverManager.getDriver().findElement(SIGN_IN_BUTTON).click();
        return new LoggedInPO();
    }

    public void openLoginPopUp(){
        DriverManager.getDriver().findElement(SIGN_IN_LINK).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(NAME_FIELD_ID));
    }

}
