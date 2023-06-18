package com.dal.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.dal.dao.EmployeeDao;
import com.dal.model.Employee;

public class EmployeeController implements EmployeeInterface {
	EmployeeDao dao = new EmployeeDao();
	
	Scanner sc = new Scanner(System.in);
	Employee emp;
	List<Employee> emplist = new ArrayList<>();

	public void addEmployee()
	{
		emp = new Employee();
		System.out.println("Enter Eno");
		int eno = sc.nextInt();
		emp.setEmpno(eno);
		System.out.println(emp.getEmpno());
		System.out.println("Enter Ename");
		String ename = sc.next();
		emp.setEname(ename);
		System.out.println(emp.getEname());
		
		emplist.add(emp);
	}
	
	public void viewEmployee() {
		emplist.forEach(e -> System.out.println(e));
	}
	
	public void Serialize() {
		try{
			FileOutputStream fos = new FileOutputStream("dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(emplist);
			System.out.println("Serilized to file dedalus.txt");
			oos.close();
			fos.close();
			}
			catch(FileNotFoundException fnf)
			{
				System.out.println("No file");
			}
			catch(IOException ae)
			{
				System.out.println("No file");
			}
			
	}
	
	public void DeSerialize() {
		try {

			FileInputStream fis = new FileInputStream("dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			emplist = (ArrayList<Employee>) ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			for (Employee emp : emplist) {
				System.out.println(emp.getEmpno() + " " + emp.getEname());
			}
			ois.close();
			fis.close();

		} catch (FileNotFoundException fnf) {
			System.out.println("No file");
		} catch (ClassNotFoundException cnf) {
			System.out.println("No Emp class");
		} catch (IOException ae) {
			System.out.println("No file");
		}

	}
	
	public void updateEmployee() {
	    int empno = getUserInputInt("Enter the employee number to update:");
	    String ename = getUserInputString("Enter the new employee name:");

	    Employee empToUpdate = new Employee();
	    empToUpdate.setEmpno(empno);
	    empToUpdate.setEname(ename);

	    dao.updateEmployee(empno, empToUpdate);
	    System.out.println("updated !!!!!");
	}

	public void deleteEmployee() {
	    int empno = getUserInputInt("Enter the empid to delete:");

	    dao.deleteEmployee(empno);
	    System.out.println("deleted !!!!!!");
	}
	public void sortByNumber() {
        Employee[] empArray = emplist.toArray(new Employee[0]);
        Arrays.sort(empArray);
        System.out.println("Sorted Employee Array by Number: " + Arrays.toString(empArray));
    }

    public void sortByName() {
        Employee[] empArray = emplist.toArray(new Employee[0]);
        Arrays.sort(empArray, Employee.nameComparator);
        System.out.println("Sorted Employee Array by Name: " + Arrays.toString(empArray));
    }

	private int getUserInputInt(String message) {
	    System.out.println(message);
	    return sc.nextInt();
	}

	private String getUserInputString(String message) {
	    System.out.println(message);
	    return sc.next();
	}

}