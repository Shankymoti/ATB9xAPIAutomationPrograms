package shashankkumar.com.ex03_TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting016_Groups {

    @Test(groups = {"qa","sanity","prod"})
    public void sanityRun(){
        System.out.println("QA");
        System.out.println("SANITY");
        Assert.assertTrue(true);
    }

    @Test(groups = {"reg","P0"})
    public void regressionRun(){

        System.out.println("Regression");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa"})
    public void smokeRun(){
        System.out.println("SANITY");
        Assert.assertTrue(false);

    }
}
