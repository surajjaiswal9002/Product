package com.Target.Product.Accloite;

public class EvenOddThreadSynchronized {

    private final int Max = 5;
    private int start = 1;

    public synchronized void oddThread(){
        while(start <= Max){
            while(start % 2 != 0){
                try{
                    wait();
                }catch(Exception e){

                }
            }

            System.out.println(" count : "+start);
            start++;
            notify();

        }
    }


    public synchronized void evenThread(){
        while(start <= Max){
            while(start % 2 == 0){
                try{
                    wait();
                }catch(Exception e){

                }
            }

            System.out.println(" count : "+start);
            start++;
            notify();

        }
    }

    public static void main(String[] args) {
        EvenOddThreadSynchronized e1 = new EvenOddThreadSynchronized();

        Thread odd = new Thread(() -> e1.oddThread());
        Thread even = new Thread(() -> e1.evenThread());

        odd.start();
        even.start();
    }
}
