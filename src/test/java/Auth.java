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
    public void AuthFL(){

        Map<String, String> body = new HashMap<>();
        Response responseGetAuth = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .post("https://idev.etm.ru/api/ipro/user/login?log=9692161158&pwd=20101999d")
                .andReturn();
        String sessionId = responseGetAuth.jsonPath().getString("data.session");

        System.out.println(sessionId);

        //responseGetAuth.prettyPrint();

    }

}
