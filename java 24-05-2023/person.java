package com.Java;

public class Person  implements Action{
	 @Override
	    public void startRun() {
	        System.out.println("Running...");
	    }

	    @Override
	    public void stopRun() {
	        System.out.println("stopping...");
	    }

	    @Override
	    public void Jogging() {
	        System.out.println("jogging...");
	    }

	    @Override
	    public void Walking() {
	        System.out.println("walking...");
	    }
	
 public static void main(String[] args) {
 	Person person = new Person();
     Person.startRun();
     Person.stopRun();
     Person.Jogging();
     Person.Walking();
 }
}
