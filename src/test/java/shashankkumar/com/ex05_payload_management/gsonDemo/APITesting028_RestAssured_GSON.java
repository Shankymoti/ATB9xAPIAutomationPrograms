package shashankkumar.com.ex05_payload_management.gsonDemo;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting028_RestAssured_GSON {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void test_positiveTC_gson() {
        Booking booking = new Booking();

        booking.setFirstname("Shashank");
        booking.setLastname("Singh");
        booking.setTotalprice(1234);

        booking.setDepositpaid(true);

        Bookingdates bookingdate = new Bookingdates();
        bookingdate.setCheckin("2024-01-01");
        bookingdate.setCheckout("2024-01-01");

        booking.setBookingdates(bookingdate);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

 //Java obj to JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString  = response.asString();

        validatableResponse =  response.then().log().all();
        validatableResponse.statusCode(200);


        // Case 1 : extract -> Direct Extraction

        String firstName = response.then().extract().path("booking.firstname");
        System.out.println(firstName);

        // Case 2 : JsonPath.getString("") -> JSONPATH Extraction

        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String firstname = jsonPath.getString("booking.firstname");
        System.out.println(bookingId);
        System.out.println(firstname);
        Integer totalPrice = jsonPath.getInt("booking.totalprice");
        System.out.println(totalPrice);


        // Case 3 - DeSer - Extraction
        BookingResponse bookingResponse = gson.fromJson(jsonResponseString, BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getTotalprice());

        assertThat(bookingResponse.getBookingid()).isPositive().isNotNull().isNotZero().isNotNegative();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Shashank").isAlphanumeric().isNotBlank().isNotEmpty();



    }
}
