package shashankkumar.com.ex01_sample_check;

import io.restassured.RestAssured;

public class APITesting002 {
    public static void main(String[] args) {
        //Gherkins Steps

        //Given() -> pre req. -> url, Header, param, query param, body, Auth..
        //When() -> action -> HTTP method -> GET, POST, DELETE, PUT....
        //Then() -> validation - > status code 200, field validation like firstName = shashank

        // BASE URL :  https://api.zippopotam.us/IN/560048
        //baseUri : https://api.zippopotam.us
        //basePath : /IN/560048

        RestAssured
                .given()
                   .baseUri("https://api.zippopotam.us")
                   .basePath("/IN/560048")
                .when()
                   .get()
                .then()
                   .log().all()
                   .statusCode(404); //Expected status code <404> but was <200>.


    }
}
