package shashankkumar.com.ex04_Assertion;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class APITesting024_RestAssured_TestNG_AssertJ_Assertion {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;


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
                              validatableResponse.body("booking.lastname",Matchers.equalTo("Singh"));
                              validatableResponse.body("booking.bookingdates.checkin",Matchers.equalTo("2024-01-01"));
                              validatableResponse.body("booking.additionalneeds", Matchers.equalTo("Breakfast"));

       // TestNG Assertions  -

       // SoftAssert vs
       // HardAssert -
       // This means that if any assertion fails,
       // the remaining statements in that test method will not be executed.

       // Use these path Testng and AssertJ
       bookingId = response.then().extract().path("bookingid");
       String firstName = response.then().extract().path("booking.firstname");
       String lastName = response.then().extract().path("booking.lastname");
       String checkIn = response.then().extract().path("booking.bookingdates.checkin");

    //TestNG Assertion

       Assert.assertNotNull(bookingId);
       Assert.assertEquals(firstName, "Shashank");
       Assert.assertNotEquals(lastName,"Kumar");
       Assert.assertEquals(checkIn, "2024-01-01");

       //AssertJ  Assertion ( 3rd- Lib to Assertions)

       assertThat(bookingId).isPositive().isNotNegative().isNotNull();
       assertThat(firstName).isEqualTo("Shashank").isAlphanumeric().isNotNull().isNotBlank().isNotEmpty();

   }

}
