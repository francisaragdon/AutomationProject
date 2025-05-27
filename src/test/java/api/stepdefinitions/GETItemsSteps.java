package api.stepdefinitions;

import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import api.clients.GETItems;


public class GETItemsSteps {
    Response response;
    GETItems getItems = new GETItems();

    @Then("User calls GET items")
    public void user_calls_get_booking() {
        response = getItems.userGetItems();

    }
}
