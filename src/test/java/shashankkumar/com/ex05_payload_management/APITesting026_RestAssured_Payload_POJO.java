package shashankkumar.com.ex05_payload_management;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class APITesting026_RestAssured_Payload_POJO {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    Integer bookingId;


   @Test
    public void test_MapPayload() {

//        String payloadPOST = "{\n" +
//                "    \"firstname\" : \"Shashank\",\n" +
//                "    \"lastname\" : \"Singh\",\n" +
//                "    \"totalprice\" : 1234,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2024-01-01\",\n" +
//                "        \"checkout\" : \"2024-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";


/*
       Map<String, Object> jsonBodyUsingMap = new LinkedHashMap();
       jsonBodyUsingMap.put("firstname", "Shashank");
       jsonBodyUsingMap.put("lastname","Singh");
       jsonBodyUsingMap.put("totalprice",1234);
       jsonBodyUsingMap.put("depositpaid",true);

       Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
       bookingDatesMap.put("checkin","2024-01-01");
       bookingDatesMap.put("checkout", "2024-01-01");

       jsonBodyUsingMap.put("bookingdates",bookingDatesMap);
       jsonBodyUsingMap.put("additionalneeds", "Breakfast");

       System.out.println(jsonBodyUsingMap); // it will not in json format
       // Map -> Json ??
       // {firstname=Shashank, lastname=Singh, totalprice=1234, depositpaid=true, bookingdates={checkin=2024-01-01, checkout=2024-01-01}, additionalneeds=Breakfast}
       // to make this java object into json,we can use ( GSON, Jackson API)
       //Gson is a Java library that converts Java objects into JSON and vice versa
       // add gson dependency in pom.xml and then it will automatically convert jsonBodyUsingMap in json, not need to do anything

      */

       // POJO

       Booking booking = new Booking();
       booking.setFirstname("Shashank");
       booking.setLastname("Singh");
       booking.setTotalprice(1234);
       booking.setDepositpaid(true);

       BookingDates bookingDates =  new BookingDates();
       bookingDates.setCheckin("2024-01-01");
       bookingDates.setCheckout("2024-01-01");

       booking.setBookingdates(bookingDates);

       booking.setAdditionalneeds("Breakfast");








       requestSpecification = RestAssured.given().log().all();
                                requestSpecification.baseUri("https://restful-booker.herokuapp.com");
                                requestSpecification.basePath("/booking");
                                requestSpecification.contentType(ContentType.JSON);
                                requestSpecification.body(booking);
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
