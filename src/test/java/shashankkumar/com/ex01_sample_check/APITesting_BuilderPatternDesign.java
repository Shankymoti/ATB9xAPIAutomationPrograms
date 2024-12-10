package shashankkumar.com.ex01_sample_check;

public class APITesting_BuilderPatternDesign {
    public APITesting_BuilderPatternDesign step1(){
        System.out.println("Step1");
        return this;
    }
    public APITesting_BuilderPatternDesign step2(){
        System.out.println("Step2");
        return this;
    }
    public APITesting_BuilderPatternDesign step3(){
        System.out.println("Step3");
        return this;
    }

    public static void main(String[] args) {
        APITesting_BuilderPatternDesign bp = new APITesting_BuilderPatternDesign();
        bp.step1().step2().step3();

    }
}
