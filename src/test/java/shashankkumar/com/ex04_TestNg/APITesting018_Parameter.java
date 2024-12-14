package shashankkumar.com.ex04_TestNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting018_Parameter {

    @Parameters("browser")
    @Test
    public void demo1(String value){
        System.out.println("Browser is "+value);
        if(value.equalsIgnoreCase("Chrome")){
            System.out.println("Exceute TC in chrome");
        }if (value.equalsIgnoreCase("firefox")){
            System.out.println("Execute TC in firefox");
        }
    }
}
