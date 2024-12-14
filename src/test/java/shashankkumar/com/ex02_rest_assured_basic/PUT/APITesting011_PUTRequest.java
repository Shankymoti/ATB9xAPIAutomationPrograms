package shashankkumar.com.ex02_rest_assured_basic.PUT;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PUTRequest {

    /* Required:
    baseUri,basePath, payload(body), header(contentType), tokenid, bookingId .....
     */
    @Description(" To verify PUT Request")
    @Test
    public void test_PUTRequest(){

        String tokenID = "8c34c7ba2be8cd0";
        String bookingID = "3324";
        String payload = "{\n" +
                "    \"firstname\" : \"shashank\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",tokenID);
        requestSpecification.body(payload).log().all();

        Response response1 = requestSpecification.when().put();

        ValidatableResponse vr = response1.then().log().all();
        vr.statusCode(200);

    }
}
