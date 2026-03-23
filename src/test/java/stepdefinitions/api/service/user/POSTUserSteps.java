package stepdefinitions.api.service.user;

import api.model.users.POSTUserDto;
import api.service.userservice.POSTUser;
import context.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Map;

public class POSTUserSteps {

    private final ScenarioContext scenarioContext;
    private final POSTUser postUser = new POSTUser();
    Response response;

    public POSTUserSteps(ScenarioContext scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    @Given("User calls POST User with values:")
    public void user_calls_post_items_with_dt(DataTable table) {

        Map<String, String> map = table.asMap(String.class, String.class);
        response = postUser.postUserBodySpec(map);

        Assert.assertEquals(201, response.getStatusCode());
        System.out.println("Status code " + response.getStatusCode());

        if (response.getStatusCode() == 201) {
            POSTUserDto userDto = response.as(POSTUserDto.class);
            scenarioContext.set("POST_USER_RESPONSE", response);
            scenarioContext.set("POST_USER_RESPONSE_BODY", userDto);
            response = scenarioContext.get("POST_USER_RESPONSE", Response.class);
        }

    }



}
