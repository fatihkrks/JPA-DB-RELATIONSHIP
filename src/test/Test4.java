package test;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;
import domain.Phone;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class Test4 {
 public static void main(String[] args) {
	 EntityManagerFactory factory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
	 EntityManager entityManager=factory.createEntityManager();
	 EmployeeRepository empRepo=new EmployeeRepositoryImpl(entityManager);
	 Employee employee=new Employee();
	 employee.setName("fatih");
	 employee.setSurname("karakas"); 
	 employee.setSalary(1000);
	 Phone phone1=new Phone("555500", "MOBILE");
	 Phone phone2=new Phone("216200", "HOME");
	 Phone phone3=new Phone("216500", "WORK");
	 
	empRepo.insertPhone(phone1);
	empRepo.insertPhone(phone2);
	empRepo.insertPhone(phone3);
	
	employee.getPhones().add(phone1);
	employee.getPhones().add(phone2);
	employee.getPhones().add(phone3);
	 empRepo.save(employee);
}
}
