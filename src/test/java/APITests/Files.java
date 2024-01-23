package APITests;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;
import lib.Auth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Files {
    private static Cookie sessionCookie;
    @BeforeAll
    public static void setUp() {
        Auth auth = new Auth();
        sessionCookie = new Cookie.Builder("session-id", auth.getSession("60004392tes", "rvfa8424")).build();
    }
    @Test
    public void GetFiles()
    {
        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .get("https://techdev.etm.ru/api/v1/brand-profile/files");

        int statusCode = responseExists.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        responseExists.prettyPrint();
    }

    @Test
    public void DOCXTest()
    {
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\DOCXTest.docx");
        Map<String, Object> body = new HashMap<>();

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        System.out.println(sessionCookie.getValue());

        String fileName = responseExists.jsonPath().getString("data.original_file_name");
        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");
        Assertions.assertEquals("DOCXTest.docx", fileName, "wrong DOCX name");
    }

    @Test
    public void XLSXTest()
    {
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\XLSXTest.xlsx");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        String fileName = responseExists.jsonPath().getString("data.original_file_name");
        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");
        Assertions.assertEquals("XLSXTest.xlsx", fileName, "wrong XLSX name");
    }

    @Test
    public void CDRTest()
    {
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\CDRTest.cdr");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        System.out.println(sessionCookie.getValue());


        String fileName = responseExists.jsonPath().getString("data.original_file_name");
        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");
        Assertions.assertEquals("CDRTest.cdr", fileName, "wrong CDR name");
    }

    @Test
    public void PDFTest()
    {
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\PDFTest.pdf");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        String fileName = responseExists.jsonPath().getString("data.original_file_name");
        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");
        Assertions.assertEquals("PDFTest.pdf", fileName, "wrong PDF name");
    }

    @Test
    public void AITest()
    {
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\AITest.ai");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        String fileName = responseExists.jsonPath().getString("data.original_file_name");
        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");
        Assertions.assertEquals("AITest.ai", fileName, "wrong AI name");
    }

    @Test
    public void EPSTest()
    {
        File file = new File("C:\\MyJava\\SkillsAPITests\\src\\files\\EPSTest.eps");
        Map<String, Object> body = new HashMap<>();
        body.put("document_type_id", 1);

        Response responseExists = RestAssured
                .given()
                .cookie(sessionCookie)
                .header("Authorization", sessionCookie.getValue())
                .multiPart("document_type_id", "1")
                .multiPart("document", file)
                .post("https://techdev.etm.ru/api/v1/brand-profile/files");

        String fileName = responseExists.jsonPath().getString("data.original_file_name");
        Assertions.assertEquals(200, responseExists.statusCode(), "not 200");
        Assertions.assertEquals("EPSTest.eps", fileName, "wrong EPS name");
    }
}
