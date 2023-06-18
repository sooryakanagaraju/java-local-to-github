package taskDoa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ApplicationContext context = new ClassPathXmlApplicationContext("spr-props.xml");

	        DaoClass dao = (DaoClass) context.getBean("dao");
	        System.out.println(dao.getDbname() + "  " + dao.getUname() + "  " + dao.getPassword());
	        System.out.println(DaoClass.getMyConnection());
	}

}
