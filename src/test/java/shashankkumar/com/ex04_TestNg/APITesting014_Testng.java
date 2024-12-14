package shashankkumar.com.ex04_TestNg;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting014_Testng {


    @BeforeTest
    public void tokenID(){
        System.out.println("3");
    }
    @BeforeTest
    public void bookingId(){
        System.out.println("1");
    }


    @Test
    public void putReq(){
        System.out.println("1");
    }

    @AfterTest
    public void closeAll(){
        System.out.println("4");
    }
}
