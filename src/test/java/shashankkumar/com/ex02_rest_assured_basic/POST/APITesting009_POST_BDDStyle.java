package shashankkumar.com.ex02_rest_assured_basic.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting009_POST_BDDStyle {

    @Description("Verify POST Request: Positive")
    @Test
    public void test_post_BddStyle(){

        /*
        Required Stuff
        baseURI, basePath, contentType(header), body(payload)...
         */

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)
                .log().all().body(payload)
                .when().log().all().post()
                .then().log().all().statusCode(200);
    }
}
