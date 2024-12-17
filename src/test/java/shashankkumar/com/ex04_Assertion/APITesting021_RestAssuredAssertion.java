package shashankkumar.com.ex04_Assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class APITesting021_RestAssuredAssertion {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
   @Test
    public void test_RestAssuresAssertion() {

        String payloadPOST = "{\n" +
                "    \"firstname\" : \"Shashank\",\n" +
                "    \"lastname\" : \"Singh\",\n" +
                "    \"totalprice\" : 1234,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification = RestAssured.given().log().all();
                                requestSpecification.baseUri("https://restful-booker.herokuapp.com");
                                requestSpecification.basePath("/booking");
                                requestSpecification.contentType(ContentType.JSON);
                                requestSpecification.body(payloadPOST);
        response = requestSpecification.when().log().all().post();

        validatableResponse = response.then().log().all();
                              validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()
                              validatableResponse.body("bookingid", Matchers.notNullValue());
                              validatableResponse.body("booking.firstname",Matchers.equalTo("Shashank"));
                              validatableResponse.body("booking.bookingdates.checkin",Matchers.equalTo("2024-01-01"));
                              validatableResponse.body("booking.additionalneeds", Matchers.equalTo("Breakfast"));
    }

}
