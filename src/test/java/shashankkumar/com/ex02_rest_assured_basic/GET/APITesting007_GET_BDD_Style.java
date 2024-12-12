package shashankkumar.com.ex02_rest_assured_basic.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting007_GET_BDD_Style {

    @Test
    public void test_Get_Req_Positive(){
        String pincode = "560048";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(200);
    }

    @Test
    public void test_Get_Req_Negative(){
        String pincode = "-1";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().get()
                .then().log().all().statusCode(404);
    }
}
