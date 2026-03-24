package stepdefinitions.api.service.user;

import api.model.users.POSTUserRequest;
import api.model.users.POSTUserResponse;
import api.service.userservice.POSTUser;
import context.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

        //Arrange
        Map<String, String> map = table.asMap(String.class, String.class);

        POSTUserRequest userRequestDto = new POSTUserRequest();
        userRequestDto.setName(map.get("name"));
        userRequestDto.setEmail(map.get("email"));

        scenarioContext.set("POST_USER_REQUEST", userRequestDto);

        //Act
        response = postUser.postUserBodySpec(map);
        POSTUserResponse userResponseDto = response.as(POSTUserResponse.class);
        scenarioContext.set("POST_USER_RESPONSE", userResponseDto);

        Assert.assertEquals("Status code " + response.getStatusCode(),
                201, response.getStatusCode());

    }

    @Then("Validate POST User response")
    public void validate_post_user_response() {

        //Assert
        POSTUserRequest requestDTO = scenarioContext.get("POST_USER_REQUEST", POSTUserRequest.class);
        POSTUserResponse responseDTO = scenarioContext.get("POST_USER_RESPONSE", POSTUserResponse.class);

        Assert.assertEquals(requestDTO.getEmail(),responseDTO.getEmail());
        Assert.assertEquals(requestDTO.getName(),responseDTO.getName());


    }


}
