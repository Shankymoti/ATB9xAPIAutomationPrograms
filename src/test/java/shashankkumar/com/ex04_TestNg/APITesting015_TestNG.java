package shashankkumar.com.ex04_TestNg;

import org.testng.annotations.Test;

public class APITesting015_TestNG {
//priority is rarely used in framework
    @Test(priority = 5)
    public void t1(){
        System.out.println("t1");
    }

    @Test(priority = 3)
    public void t2(){
        System.out.println("t2");
    }
    @Test(priority = 0)
    public void t3(){
        System.out.println("t3");
    }

    @Test
    public void t4(){
        System.out.println("t4");
    }
    @Test(priority = 1)
    public void t5(){
        System.out.println("t5");
    }

    @Test(priority = -2)
    public void t6(){
        System.out.println("t6");
    }
}
