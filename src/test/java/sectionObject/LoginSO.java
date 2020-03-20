package sectionObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LoggedInPO;

public class LoginSO {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By signInLink = By.id("_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_qfkd____");
    private By nameField = By.id("_com_liferay_login_web_portlet_LoginPortlet_login");
    private By passwordField = By.id("_com_liferay_login_web_portlet_LoginPortlet_password");
    private By singInButton = By.className("lfr-btn-label");

    public LoginSO(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LoggedInPO doLogin(String user, String password){
        this.openLoginPopUp();
        driver.findElement(nameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(singInButton).click();
        return new LoggedInPO(driver);
    }

    public void openLoginPopUp(){
        driver.findElement(signInLink).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
    }

}
