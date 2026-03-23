package api.service.userservice;

import api.service.auth.TokenManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

public class RequestSpecFactory {

    public static RequestSpecification getUserByIdRequestSpec(String id) {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addQueryParam("id", id)
                .build();
    }

    public static RequestSpecification postUserRequestSpec() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", TokenManager.getToken())
                .setBaseUri(ConfigReader.getApiBaseUriUserService())
                .setContentType(ContentType.JSON)
                .build();
    }
}
