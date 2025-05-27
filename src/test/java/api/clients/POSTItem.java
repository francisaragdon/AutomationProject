package api.clients;

import api.utils.RestUtil;
import constants.ApiConstants;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class POSTItem {

    public RequestSpecification userAuthRequestSpec() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON);
        return requestSpecBuilder.build();
    }


    private Map<String, Object> createPOSTItemBody(Map<String, String> overrides) {
        Map<String, Object> postItem = new HashMap<>();
        postItem.put("name", "admin");

        Map<String, String> data = new HashMap<>();
        data.put("year", "2025");
        data.put("price", "200");
        data.put("CPU model", "Ryzen 5");
        data.put("Hard disk size", "200gb");

        postItem.put("data", data);

        if (overrides != null) {
            for (Map.Entry<String, String> entry : overrides.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();

                if (key.equalsIgnoreCase("name")) {
                    postItem.put("name", value);
                } else {
                    data.put(key, value);
                }
            }
        }

        return postItem;
    }


    public Response userPostItem(Map<String, String> overrides) {
        return RestUtil.doPost(userAuthRequestSpec(), ApiConstants.BASE_URI + ApiConstants.OBJECTS_ENDPOINT, createPOSTItemBody(overrides));
    }

    public Map<String, String> parseOverrideField(String field) {
        Map<String, String> overrides = new HashMap<>();
        if (field != null && !field.trim().isEmpty()) {
            String[] pairs = field.split(",");
            for (String pair : pairs) {
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    overrides.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        }
        return overrides;
    }


}
