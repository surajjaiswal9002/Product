package com.Target.Product.designpattern;

public class SingleTonDP {
    // step1 - private static variable to hold the single instance
    private static SingleTonDP instance;

    //step2 - private constructor to prevent instantiation
    private SingleTonDP() {

    }

    // step3 public static method to return the instance ( Thread  safe with synchronized)
   /* public static synchronized SingleTonDP getInstance(){
        if(instance == null){
            instance = new SingleTonDP();
        }
        return instance;
    }
*/


    //Double check
    public static SingleTonDP getInstance() {
        if (instance == null) {
            synchronized (SingleTonDP.class) {
                if (instance == null) {
                    instance = new SingleTonDP();
                }
            }

        }
        return instance;
    }

    public static void main(String[] args) {
        SingleTonDP s1 = SingleTonDP.getInstance();
        SingleTonDP s2 = SingleTonDP.getInstance();

        System.out.println(s1 == s2);

    }
}



