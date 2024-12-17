package shashankkumar.com.ex03_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting021_InvocationCount {

    @Test(invocationCount = 2)
    public void test(){
        Assert.assertTrue(true);
    }
}
