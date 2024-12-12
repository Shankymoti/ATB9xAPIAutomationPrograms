package shashankkumar.com.ex02_rest_assured_basic.GET;

import io.restassured.RestAssured;

public class APITesting006_GET_BDDStyle {
    public static void main(String[] args) {
            String pincode = "560048";

        RestAssured.given().log().all()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);


            pincode ="-1";
            RestAssured.given()
                    .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                    .when().get()
                    .then().log().all().statusCode(404);
    }
}
