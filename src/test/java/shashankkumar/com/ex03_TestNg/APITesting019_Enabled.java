package shashankkumar.com.ex03_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting019_Enabled {

    @Test
    public void test1(){
        Assert.assertTrue(true);
    }
    @Test(enabled = false)
    public void test2(){
        Assert.assertTrue(true);
    }

    @Test
    public void test3(){

        Assert.assertTrue(true);
    }

    @Test(enabled = true)//default
    public void test4(){
        Assert.assertTrue(true);
    }
}
