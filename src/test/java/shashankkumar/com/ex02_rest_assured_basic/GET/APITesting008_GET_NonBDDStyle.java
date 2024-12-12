package shashankkumar.com.ex02_rest_assured_basic.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting008_GET_NonBDDStyle {


   /* @Description("Verify the GET Request Positive")
    @Test
    public void test_GET_NonBDD(){
        String pincode = "560048";
        RequestSpecification r = RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode);

        Response response = r.when().log().all().get();

        ValidatableResponse vr = response.then().log().all().statusCode(200);
    }  */


    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("To verify GET Request Positive")
    @Test
    public void test_GET_NonBDD(){
        String pincode = "560048";
        r = RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Description("To verify Get Request negative : Input : -1")
    @Test
    public void test_GETNonBDD_Negative(){
        String pincode = "-1";
        r = RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Description("To Verify Get Request negative : Input : @#$%")
    @Test
    public void test_GetNonBDD_NegativeCase2(){
        String pincode = "@#$%";
        r = RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }
}
