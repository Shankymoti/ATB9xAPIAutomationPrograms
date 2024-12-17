package shashankkumar.com.ex03_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting017_dependsOnMethod {

    @Test
    public void serverStartedOk(){
        System.out.println("server Started ok");
        Assert.assertTrue(true);
    }
    @Test(dependsOnMethods = "serverStartedOk")
    public void method1(){
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test
    public void method2(){
        System.out.println("method2");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method3(){
        System.out.println("method3");
        Assert.assertTrue(true);
    }

}
