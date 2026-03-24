package stepdefinitions.web;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.ConfigReader;
import web.pages.LoginPage;

public class LoginPageSteps {

    protected LoginPage loginPage;

    public LoginPageSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("User is in login page")
    public void navigate_to_login_page() {
        loginPage.navigateToLoginPage(ConfigReader.getTestApp());

    }

    @When("User login with valid credentials")
    public void login_with_valid_credentials() {
        loginPage.login(ConfigReader.getUsernameAdmin(), ConfigReader.getPasswordAdmin());

    }

}
