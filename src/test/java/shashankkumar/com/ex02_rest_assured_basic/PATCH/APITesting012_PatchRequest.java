package shashankkumar.com.ex02_rest_assured_basic.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting012_PatchRequest {

    /*
    Requirement :  baseUri, basePath, patch method, contentType, payload, tokenid, booking id etc...
     */
    @Description("To Verify Patch request")
    @Test
    public void test_PatchRequest(){
        String tokenId = "19fb01e7dddd9ac";
        String bookingId = "2077";
        String payload = "{\n" +
                "    \"firstname\" : \"James\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";


        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",tokenId);
        requestSpecification.body(payload).log().all();

        Response response =  requestSpecification.when().log().all().patch();

        ValidatableResponse vr = response.then();
        vr.log().all().statusCode(200);
    }
}
