package com.dal.factory;

interface Vehicle {
    void drive();
}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a car.");
    }
}

class Motorcycle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Riding a motorcycle.");
    }
}


class VehicleFactory {
    public Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) {
            return new Car();
        } else if (type.equalsIgnoreCase("motorcycle")) {
            return new Motorcycle();
        } else {
            throw new IllegalArgumentException("Invalid vehicle type.");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        VehicleFactory factory = new VehicleFactory();

 
        Vehicle car = factory.createVehicle("car");
        car.drive(); 


        Vehicle motorcycle = factory.createVehicle("motorcycle");
        motorcycle.drive(); 
    }
}