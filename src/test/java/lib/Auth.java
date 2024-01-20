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

    @Test
    public void getSession()
    {
        Map<String, String> params = new HashMap<>();
        params.put("log", "9160058830");
        params.put("pwd", "Dd17549bb");

        Response responseGetAuth = RestAssured
                .given()
                .queryParams(params)
                .contentType(ContentType.JSON)
                .post("https://idev.etm.ru/api/ipro/user/login")
                .andReturn();
       // String sessionId = responseGetAuth.jsonPath().getString("data.session");



        String authCoockie = responseGetAuth.getCookie("session-id");
        Map<String, String> cookies = new HashMap<>();
        cookies.put("session-id", authCoockie);

        Response responseForCheck = RestAssured
                .given()
                .queryParams(params)
                .cookies(cookies)
                .when()
                .post("https://idev.etm.ru/api/ipro/user/login")
                .andReturn();

        responseGetAuth.prettyPrint();
    }

    public void authCookie() {

    }



}
