import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Tests {

    @Test
    public void testHello()
    {
        Map<String, String> params = new HashMap<>();
        //params.put("sdf","sdf");

        JsonPath response = RestAssured
                .get("https://techdev.etm.ru/api/v1/events")
                .jsonPath();

        String answer = response.get("answer");
        System.out.println(answer);

    }
}
