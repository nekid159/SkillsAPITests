package APITests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import lib.Auth;

import java.util.HashMap;
import java.util.Map;

public class ExistsAndNotifications {
    Auth Auth = new Auth();

    // private String sessionId = Auth.getSession();

    @Test
    public void Exists ()
    {
        String sessionId = Auth.getSession("60004392tes", "rvfa8424");
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .get("https://techdev.etm.ru/api/v1/brand-profile/exists");

        int statusCode = responseExists.getStatusCode();
        responseExists.prettyPrint();
        System.out.println("Status Code: " + statusCode);

    }
}