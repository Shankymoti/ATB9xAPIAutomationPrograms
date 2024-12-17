package shashankkumar.com.ex03_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting20_AlwaysRun {

    @Test
    public void test1(){
        Assert.assertTrue(true);
    }
    @Test(alwaysRun = true)
    public void test2(){
        Assert.assertTrue(true);
    }

 @Test(enabled = false)
    public void test3(){
        Assert.assertTrue(true);
    }

   /* @Test(alwaysRun = false)
    public void test4(){
        Assert.assertTrue(true);
    } */
}
