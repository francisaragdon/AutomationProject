package api.clients;

import api.utils.RestUtil;
import constants.ApiConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETItems {

    public RequestSpecification userAuthRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        return requestSpecBuilder.build();
    }

    public Response userGetItems() {
        return RestUtil.doGet(userAuthRequestSpec(), ApiConstants.BASE_URI + ApiConstants.OBJECTS_ENDPOINT);
    }
}
