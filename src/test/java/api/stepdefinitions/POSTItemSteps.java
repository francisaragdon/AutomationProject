package api.stepdefinitions;

import api.clients.POSTItem;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.Map;


public class POSTItemSteps {
    Response response;
    POSTItem postItem = new POSTItem();

    @Then("User calls POST Items with {string}")
    public void user_calls_post_items_with(String overrideField) {
        Map<String, String> overrides = postItem.parseOverrideField(overrideField);
        response = postItem.userPostItem(overrides);
    }
}
