package shashankkumar.com.ex02_rest_assured_basic.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting013_DeleteRequest {

    /*
    Requirement : baseUri, basePath, tokenid(cookies), contentType, booking id, delete req method
     */
@Description("To verify Delete Request")
    @Test
    public void test_Delete_Request(){
        String tokenID = "9e5a0c1141557a6";
        String bookingID = "2166";

        RequestSpecification requestSpecification = RestAssured.given().log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",tokenID);

        Response response = requestSpecification.when().log().all().delete();

        ValidatableResponse vr = response.then().log().all();
        vr.statusCode(201);


    }
}
