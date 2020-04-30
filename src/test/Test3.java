package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Department;
import domain.Employee;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class Test3 {
	public static void main(String[] args) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		EntityManager entityManager=factory.createEntityManager();
		EmployeeRepository empRepository=new EmployeeRepositoryImpl(entityManager);
		Employee employee=new Employee();
		employee.setName("fatih");
		 employee.setSurname("karakas"); 
		 employee.setSalary(1000);
		 Employee employee2=new Employee();
			employee2.setName("fatih");
			 employee2.setSurname("karakas"); 
			 employee2.setSalary(1000);
			 empRepository.save(employee);
			 empRepository.save(employee2);
			 
			 Department department=new Department();
			 department.setDeptName("IT-Dept");
			 empRepository.insertDepartment(department);
			 entityManager.getTransaction().begin();
			 employee.setDepartment(department);
			 employee2.setDepartment(department);
			 entityManager.getTransaction().commit();
	}
}
