package shashankkumar.com.ex02_rest_assured_basic.GET.Task12DEC;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetPetStoreOrderBDDStyle {
    @Description(" Positive Test Case 1")
    @Test
public void test_PositiveTC1(){
       int id =11;
        RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order/"+id)
                .when().log().all().get()
                .then().log().all().statusCode(200);
}

    @Description(" Negative Test Case 2")
    @Test
    public void test_NegativeTC2(){
        int id =1000000000;
        RestAssured.given()
                .baseUri("https://petstore.swagger.io")
                .basePath("/v2/store/order/"+id)
                .when().log().all().get()
                .then().statusCode(200);
    }



}
