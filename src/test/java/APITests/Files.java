package APITests;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import lib.Auth;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Files {
    lib.Auth Auth = new Auth();
    private String sessionId = Auth.getSession("60004392tes", "rvfa8424");



    @Test
    public void GetFiles()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .get("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }

    @Test
    public void DOCXTest()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\DOCXTest.docx");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }

    @Test
    public void XLSXest()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\XLSXTest.xlsx");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }

    @Test
    public void CDRTest()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\CDRTest.cdr");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }

    @Test
    public void PDFTest()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\PDFTest.pdf");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        //responseExists.prettyPrint();
    }

    @Test
    public void AITest()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\AITest.ai");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }

    @Test
    public void EPSTest()
    {
        Cookie sessionCookie = new Cookie.Builder("session-id", sessionId).build();
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\EPSTest.eps");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionId)
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }
}
