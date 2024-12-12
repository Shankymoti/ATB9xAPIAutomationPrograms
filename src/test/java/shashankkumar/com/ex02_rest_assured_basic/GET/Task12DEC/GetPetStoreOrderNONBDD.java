package shashankkumar.com.ex02_rest_assured_basic.GET.Task12DEC;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetPetStoreOrderNONBDD {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Description("To get order details Positive TC")
    @Test
    public void test_getOrderDetailsPositiveTC() {
        int id = 9;
        r = RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order/"+id);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);


    }

    @Description("To get order details negative TC2")
    @Test
    public void test_getOrderDetailsNegativeTC() {
        int id = 100000000;
        r = RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order/"+id);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);


    }

    @Description("To get order details negative TC2")
    @Test
    public void test_getOrderDetailsNegativeTC3() {
       String id = "11a";
        r = RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order/"+id);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);


    }


}
