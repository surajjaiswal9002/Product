package com.Target.Product.Java;
import ch.qos.logback.core.net.SyslogOutputStream;

class A {
    public void show1(){
        System.out.println("Parent class show1");
    }
    public static void show2(){
        System.out.println("Parent class show2");
    }


    void show(Object obj){
        System.out.print("hello Parent show obj  A \n ");
    }
    void show(String str){
        System.out.print("hello Parent show str A \n " );
    }


}
class B extends A {
    public void show1(){
        System.out.println(" B Child class show1");
    }
    public static void show2(){
        System.out.println("Child class show2 B");
    }
    public void show3(){
        System.out.println("Child class show3");
    }

    void show(int in){
        System.out.print("\n hello Parent show in  B  \n");
    }
    

}
public class InheritanceTest {

    public static void main(String[] args) {
        A a = new B();
        a.show1();  //B show 1
        a.show2();  // A show 2  becouse static
        //a.show3();  // compilation error due to class A not having show3()
        System.out.println(" ******************** 0001 ");
        a.show("hello");  // call A --> show string method
        a.show(10); // call A --> show object method due to autoboxing



        System.out.println(" ******************** ");
        B b = new B();
        b.show1();  // B show 1
        b.show2();  // B show 2
        b.show3();  // B show 3
        b.show("hello");  // A show string nmethod
        b.show(10);   // B show Integer method


        System.out.println(" ******************** ");
        //   B c = new A();  // Not possible

        System.out.println(" ******************** 00000000 ");
        A ab = new B();
         //A.show1();  //compilation error
        A.show2();  // A parent class
        //ab.show3();  // compilation error

        System.out.println(" ******************** 00000000 ");
        B ac = new B();
         //B.show1();  //compilation error
        B.show2();  // A parent class
        //B.show3();  // compilation error

    }
}


//Write a query to find max salary department wise ?


