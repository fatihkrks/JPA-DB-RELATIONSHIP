package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;
import domain.ParkinSpace;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class test2 {
	public static void main(String[] args) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
			EntityManager entityManager=factory.createEntityManager();
			EmployeeRepository empRepo=new EmployeeRepositoryImpl(entityManager);
			Employee employee=new Employee();
			employee.setName("fatih");
			employee.setSurname("karakas");
			employee.setSalary(5000);
			ParkinSpace ps=new ParkinSpace();
			ps.setFlat(-1);
			ps.setLocation("S-10");
			empRepo.parkingSpaceAdd(ps);
			employee.setParkingSpace(ps);
			empRepo.save(employee);
	}
}
