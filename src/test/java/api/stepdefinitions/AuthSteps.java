package api.stepdefinitions;

import api.clients.UserAuth;
import constants.ApiConstants;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

public class AuthSteps {
    Response response;
    UserAuth userAuth = new UserAuth();
    @When("I am an authorized user with valid credentials")
    public void user_calls_auth() {
        response = userAuth.authUser();
        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        ApiConstants.AUTH_TOKEN = response.jsonPath().getString("token");
        Assert.assertEquals(200, statusCode);
    }


}
