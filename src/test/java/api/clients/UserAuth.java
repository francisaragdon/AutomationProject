package api.clients;

import api.utils.RestUtil;
import constants.ApiConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class UserAuth {


    public RequestSpecification userAuthRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        return requestSpecBuilder.build();
    }

    private Map<String, String> createAuthBody() {
        Map<String, String> authBody = new HashMap<>();
        authBody.put("username", "admin");
        authBody.put("password", "password123");
        return authBody;
    }

    public Response authUser() {
     return RestUtil.doPost(userAuthRequestSpec(), ApiConstants.BASE_URI + ApiConstants.AUTH_ENDPOINT,createAuthBody());
    }
}
