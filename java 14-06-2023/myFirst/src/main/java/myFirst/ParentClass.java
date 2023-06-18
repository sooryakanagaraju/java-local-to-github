package myFirst;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParentClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("sooryaFirst.xml");
		ChildClass wel = (ChildClass)context.getBean("wel");
		System.out.println(wel.Hello());

	}

}
