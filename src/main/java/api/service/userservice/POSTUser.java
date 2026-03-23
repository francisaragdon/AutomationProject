package api.service.userservice;

import api.constants.ApiConstants;
import api.utils.RestUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class POSTUser {

    public Map<String, Object> postUserBody(Map<String, String> map) {
        Map<String, Object> body = new HashMap<>();

        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey().toLowerCase();
                String value = entry.getValue();

                switch (key) {
                    case "name" -> body.put("name", value);
                    case "email" -> body.put("email", value);

                }
            }
        }

        return body;
    }

    public Response postUserBodySpec(Map<String, String> map) {
        return RestUtil.doPost(
                RequestSpecFactory.postUserRequestSpec(),
                ApiConstants.USERS_ENDPOINT,
                postUserBody(map)
        );
    }
}
