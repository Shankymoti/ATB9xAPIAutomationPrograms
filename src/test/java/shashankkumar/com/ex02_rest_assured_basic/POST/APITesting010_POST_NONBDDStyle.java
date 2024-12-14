package shashankkumar.com.ex02_rest_assured_basic.POST;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting010_POST_NONBDDStyle {

    RequestSpecification r;
    Response response1;
    ValidatableResponse vr;


    @Description("To verify POST Request by non bdd style : Positive TC")
    @Test
public void test_nonBDDStyle(){
    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    r = RestAssured.given()
            .baseUri("https://restful-booker.herokuapp.com")
            .basePath("/auth")
            .contentType(ContentType.JSON)
            .log().all()
            .body(payload);

    response1 = r.when().log().all().post();

    vr = response1.then().log().all().statusCode(200);
    }
}
