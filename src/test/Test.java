package test;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Department;
import domain.Employee;
import domain.EmployeeType;
import domain.ParkinSpace;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class Test {
		public static void main(String[] args) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
			EntityManager entityManager=factory.createEntityManager();
			EmployeeRepository empRepository=new EmployeeRepositoryImpl(entityManager);
			Employee employee=new Employee();
			employee.setName("fatih");
			 employee.setSurname("karakas"); 
			 employee.setSalary(1000);
			
			 ParkinSpace ps=new ParkinSpace();
				ps.setFlat(-1);
				ps.setLocation("A-1"); 
				empRepository.parkingSpaceAdd(ps);
				employee.setParkingSpace(ps);
		
				 empRepository.save(employee);
			
			entityManager.close();
			factory.close();
			
			
		/*
		 * Employee employee=new Employee(); employee.setName("fatih");
		 * employee.setSurname("karakas"); employee.setSalary(1000); EmployeeType
		 * empType=EmployeeType.FULL_TIME; employee.setEmployeeType(empType); Date
		 * date=new Date(); employee.setStartDate(date);
		 * byte[]data="content".getBytes(); employee.setImage(data); Department
		 * department=new Department(); department.setDeptName("IT-Dept");
		 * empRepository.insertDepartment(department);
		 * employee.setDepartment(department); empRepository.save(employee);
		 * entityManager.close(); factory.close();
		 */
		}
}
