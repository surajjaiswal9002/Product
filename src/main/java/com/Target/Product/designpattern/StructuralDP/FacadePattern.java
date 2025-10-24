package com.Target.Product.designpattern.StructuralDP;

// facade DP is a structural Dp, 
//Example - Checkout process involved multiple systems: payment services, inventory services, and Delivery Services

//Subsystems
class Amplifier {
 public void on() { System.out.println("Amplifier ON"); }
 public void setVolume(int level) { System.out.println("Volume set to " + level); }
 public void off() { System.out.println("Amplifier OFF"); }
}

class DVDPlayer {
 public void on() { System.out.println("DVD Player ON"); }
 public void play(String movie) { System.out.println("Playing movie: " + movie); }
 public void off() { System.out.println("DVD Player OFF"); }
}

class Projector {
 public void on() { System.out.println("Projector ON"); }
 public void setInput(String input) { System.out.println("Projector input set to " + input); }
 public void off() { System.out.println("Projector OFF"); }
}

//Facade
class HomeTheaterFacade {
 private Amplifier amp;
 private DVDPlayer dvd;
 private Projector projector;

 public HomeTheaterFacade(Amplifier amp, DVDPlayer dvd, Projector projector) {
     this.amp = amp;
     this.dvd = dvd;
     this.projector = projector;
 }

 public void watchMovie(String movie) {
     System.out.println("Get ready to watch a movie...");
     amp.on();
     amp.setVolume(5);
     dvd.on();
     dvd.play(movie);
     projector.on();
     projector.setInput("DVD");
 }

 public void endMovie() {
     System.out.println("Shutting down the theater...");
     dvd.off();
     projector.off();
     amp.off();
 }
}

//Client
public class FacadePattern {
 public static void main(String[] args) {
     Amplifier amp = new Amplifier();
     DVDPlayer dvd = new DVDPlayer();
     Projector projector = new Projector();

     HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, dvd, projector);
     homeTheater.watchMovie("Inception");
     System.out.println();
     homeTheater.endMovie();
 }
}

