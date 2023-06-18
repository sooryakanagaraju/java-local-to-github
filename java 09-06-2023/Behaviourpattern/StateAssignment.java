package com.dal.Behaviourpattern;

interface TrafficLightState {
    void switchOnLight(TrafficLight trafficLight);
    void switchOffLight(TrafficLight trafficLight);
    void next(TrafficLight trafficLight);
}

class TrafficLight {
    private TrafficLightState state;
    
    public TrafficLight() {
        state = new RedState();
    }
    
    public void setState(TrafficLightState state) {
        this.state = state;
    }
    
    public void switchOnLight() {
        state.switchOnLight(this);
    }
    
    public void switchOffLight() {
        state.switchOffLight(this);
    }
    
    public void next() {
        state.next(this);
    }
}

class RedState implements TrafficLightState {
    @Override
    public void switchOnLight(TrafficLight trafficLight) {
        System.out.println("Traffic light is already on");
    }
    
    @Override
    public void switchOffLight(TrafficLight trafficLight) {
        System.out.println("Switching traffic light off");
        trafficLight.setState(new OffState());
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("green");
        trafficLight.setState(new GreenState());
    }
}

class GreenState implements TrafficLightState {
    @Override
    public void switchOnLight(TrafficLight trafficLight) {
        System.out.println("Traffic light is already on");
    }
    
    @Override
    public void switchOffLight(TrafficLight trafficLight) {
        System.out.println("Switching traffic light off");
        trafficLight.setState(new OffState());
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("yellow");
        trafficLight.setState(new YellowState());
    }
}

class YellowState implements TrafficLightState {
    @Override
    public void switchOnLight(TrafficLight trafficLight) {
        System.out.println("Traffic light is already on");
    }
    
    @Override
    public void switchOffLight(TrafficLight trafficLight) {
        System.out.println("Switching traffic light off");
        trafficLight.setState(new OffState());
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("red");
        trafficLight.setState(new RedState());
    }
}

class OffState implements TrafficLightState {
    @Override
    public void switchOnLight(TrafficLight trafficLight) {
        System.out.println("Switching traffic light on");
        trafficLight.setState(new RedState());
    }
    
    @Override
    public void switchOffLight(TrafficLight trafficLight) {
        System.out.println("Traffic light is already off");
    }
    
    @Override
    public void next(TrafficLight trafficLight) {
        System.out.println("Cannot switch to next state. Traffic light is off.");
    }
}

public class StateAssignment {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.switchOnLight();
        trafficLight.next();
        trafficLight.next();
        trafficLight.switchOffLight();
        trafficLight.switchOffLight();
        trafficLight.switchOnLight();
        trafficLight.next();
        trafficLight.switchOnLight();
    }
}

