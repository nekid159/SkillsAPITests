package lib;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
public class Auth {


    public String getSession(String login, String password)
    {
        Map<String, String> params = new HashMap<>();
        params.put("log", login);
        params.put("pwd", password);

        Response responseGetAuth = RestAssured
                .given()
                .queryParams(params)
                .contentType(ContentType.JSON)
                .post("https://idev.etm.ru/api/ipro/user/login")
                .andReturn();
       String sessionId = responseGetAuth.jsonPath().getString("data.session");
       return sessionId;
    }
}
