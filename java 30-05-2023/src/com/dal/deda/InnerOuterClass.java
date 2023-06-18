package com.dal.deda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class OuterClass { 


	public void printNames ( ) {
		System.out.println("soorya from outerclass");
	}
	
 class InnerClass{ 
		public void printNames2( ) { 
			System.out.println("soorya from innerclass");
		}
	}
}


public class InnerOuterClass {
List<Integer> list = new ArrayList<Integer>();

	
	public static void main(String[] args) {
	//	List<Integer> list =  Arrays.asList(1,2,3,4,5);
	//	Consumer<Integer> con = new Consumer<Integer>() {
		
		
		//public void accept(Integer i) {
			//	System.out.println(i);
		//	}
		
		
	//	list.forEach(con);
		
		OuterClass obj = new OuterClass();
		obj.printNames();
		
	
		
		OuterClass.InnerClass obj2 = obj.new InnerClass();
		obj2.printNames2();
		
		
		
		}

}
