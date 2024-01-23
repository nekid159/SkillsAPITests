package APITests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import lib.Auth;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class ExistsAndNotifications {
    private static Cookie sessionCookie;

    @BeforeAll
    public static void setUp() {
        Auth auth = new Auth();
        sessionCookie = new Cookie.Builder("session-id", auth.getSession("60004392tes", "rvfa8424")).build();
    }

    @Test
    public void Exists ()
    {
        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .get("https://techdev.etm.ru/api/v1/brand-profile/exists");

        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");

    }
}