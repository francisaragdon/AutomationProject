package web.pages;

import org.openqa.selenium.By;
import web.factory.DriverManager;

public class LoginPage extends BasePage{

    public LoginPage(DriverManager driverManager) {
        super(driverManager);
    }

    private final By username_txtbox = By.id("user-name");

    private final By password_txtbox = By.id("password");

    private final By submit_btn = By.id("login-button");

    private final By login_logo = By.id("login_logo");

    public void enterUsername(String username) {
        driver.findElement(username_txtbox).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(password_txtbox).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(submit_btn).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void navigateToLoginPage(String url){
        navigateToUrl(url);
    }

    public boolean isLoginLogoVisible (){
        return isVisible(login_logo);
    }
}
