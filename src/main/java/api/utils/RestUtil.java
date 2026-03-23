package api.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RestUtil {
    public static Response doPost(RequestSpecification spec, String endpoint, Object body) {
        return io.restassured.RestAssured
                .given()
                .spec(spec)
                .body(body)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response doGet(RequestSpecification spec, String endpoint) {
        return io.restassured.RestAssured
                .given()
                .spec(spec)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public static Response doPut(RequestSpecification spec, String endpoint, Object body) {
        return io.restassured.RestAssured
                .given()
                .spec(spec)
                .body(body)
                .log().all()
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
    
}
