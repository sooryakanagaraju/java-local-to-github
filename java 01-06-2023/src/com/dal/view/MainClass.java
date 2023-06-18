package com.dal.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.BiPredicate;

import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;
import com.dal.exception.UserNotFoundException;
import com.dal.dao.*;


public class MainClass {

	public static void main(String[] args) {
		System.out.println("Welcome to EMS :)");
		EmployeeController ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String ch = null;
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			String username = br.readLine();
			System.out.println("Enter password");
			String password = br.readLine();
			BiPredicate<String, String> res = (un, pwd) -> un.equals("soorya")&&pwd.equals("pass");
			if (res.test(username, password)) {
		
		do {
			System.out.println("Enter your choice");
			System.out.println("1. Add Employee");s
			System.out.println("2. View Employee");
			System.out.println("3. Serialize");
			System.out.println("4. Deserialze");
			System.out.println("5. update employee");
			System.out.println("6. Delete employee");
			System.out.println("6. sort by number");
			System.out.println("7. sort by name");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				ec.addEmployee();
				break;
			}

			case 2: {
				ec.viewEmployee();
				break;
			}
			case 3: {
				ec.Serialize();
				break;
			}
			case 4: {
				ec.DeSerialize();
				break;
			}
			case 5:
            	ec.updateEmployee();
            	break;
            case 6:
            	ec.deleteEmployee();
                break;
		    case 7:
            	ec.sortByNumber();
            	break;
            case 8:
            	ec.sortByName();
            	break;
		

			default: {
				System.out.println("Enter a valid number");
				break;
			}

			
			}

			System.out.println("Do u want to continue Y | y");
			ch = sc.next();

		} while (ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system.");
		System.exit(0);
			
	}else {
		System.out.println("sorry wrong login");
		throw new UserNotFoundException();
		
	}
			

}	catch(UserNotFoundException | IOException une) {
	System.out.println(une);

}
	}}