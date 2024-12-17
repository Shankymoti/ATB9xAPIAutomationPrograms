package shashankkumar.com.ex04_Assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting022_TestNGAssertion {

    @Test
    public void test_hardAssertionExample(){
        System.out.println("Start the program");
        Boolean is_neeru_male = false;
        Assert.assertTrue(is_neeru_male);
        System.out.println("End of program");
        Assert.assertEquals("shashank","Shashank");
        Assert.assertEquals("Shashank","Shashank");
    }

    @Test
    public void test_SoftAssertionExample(){
        SoftAssert sa = new SoftAssert();
        sa.assertTrue(false);
        System.out.println("This Line will be executed");
        sa.assertAll(); // This will report all collected errors.
    }
}
