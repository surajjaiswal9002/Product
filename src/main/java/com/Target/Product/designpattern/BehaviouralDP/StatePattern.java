package com.Target.Product.designpattern.BehaviouralDP;
// State Design Pattern is a behavioural desigan pattern, change the state internally like traffic ligfht


//State Interface
interface TrafficLightState {
 void handle(TrafficLight context);
}

//Concrete States
class RedState implements TrafficLightState {
 public void handle(TrafficLight context) {
     System.out.println("Traffic Light is RED. Stop!");
     context.setState(new GreenState());
 }
}

class GreenState implements TrafficLightState {
 public void handle(TrafficLight context) {
     System.out.println("Traffic Light is GREEN. Go!");
     context.setState(new BlackState()); // simulate yellow/off state
 }
}

class BlackState implements TrafficLightState {
 public void handle(TrafficLight context) {
     System.out.println("Traffic Light is BLACK. Caution/Off!");
     context.setState(new RedState());
 }
}

//Context
class TrafficLight {
 private TrafficLightState state;
 
 TrafficLight(TrafficLightState initialState) {
     this.state = initialState;
 }
 
 public void setState(TrafficLightState state) {
     this.state = state;
 }
 
 public void change() {
     state.handle(this);
 }
}

//Demo
public class StatePattern {
 public static void main(String[] args) {
     TrafficLight light = new TrafficLight(new RedState());
     
     for(int i=0; i<6; i++) { // simulate 6 cycles
         light.change();
     }
 }
}


