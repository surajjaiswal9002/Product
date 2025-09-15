package com.Target.Product.ThreadExample;

class Printer {
    private boolean isOddTurn = true; // Odd starts first
    
    public synchronized void printOdd(int number) {
        while (!isOddTurn) { // not odd's turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Odd: " + number);
        isOddTurn = false;
        notify(); // signal even thread
    }

    public synchronized void printEven(int number) {
        while (isOddTurn) { // not even's turn
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Even: " + number);
        isOddTurn = true;
        notify(); // signal odd thread
    }
}

class OddThread implements Runnable {
    private int limit;
    private Printer printer;

    public OddThread(int limit, Printer printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i += 2) {
            printer.printOdd(i);
        }
    }
}

class EvenThread implements Runnable {
    private int limit;
    private Printer printer;

    public EvenThread(int limit, Printer printer) {
        this.limit = limit;
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 2; i <= limit; i += 2) {
            printer.printEven(i);
        }
    }
}

public class OddEvenWaitNotify {
    public static void main(String[] args) {
        Printer printer = new Printer();
        int limit = 10;

        Thread oddThread = new Thread(new OddThread(limit, printer));
        Thread evenThread = new Thread(new EvenThread(limit, printer));

        oddThread.start();
        evenThread.start();
    }
}
