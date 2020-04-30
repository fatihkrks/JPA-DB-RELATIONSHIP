package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import domain.Employee;
import domain.Project;
import repository.EmployeeRepository;
import repository.EmployeeRepositoryImpl;

public class Test5 {
	public static void main(String[] args) {
			EntityManagerFactory factory=Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
			EntityManager entityManager=factory.createEntityManager();
			EmployeeRepository empRepo=new  EmployeeRepositoryImpl(entityManager);
			Employee employee=new Employee();
			employee.setName("fatih");
			 employee.setSurname("karakas"); 
			 employee.setSalary(1000);
			 
			 Employee employee2=new Employee();
				employee2.setName("berre");
				 employee2.setSurname("karakas"); 
				 employee2.setSalary(5000);
				 Employee employee3=new Employee();
					employee3.setName("irem");
					 employee3.setSurname("simsek"); 
					 employee3.setSalary(4000);
					 
					 empRepo.save(employee);
					 empRepo.save(employee2);
					 empRepo.save(employee3);
					 
					 Project project=new Project("Proje1");
					 Project project2=new Project("Proje2");
					 Project project3=new Project("Proje3");
					 empRepo.insertProject(project);
					 empRepo.insertProject(project2);
					 empRepo.insertProject(project3);
					 entityManager.getTransaction().begin();
					 employee.getProjects().add(project);
					 employee.getProjects().add(project3);
					 
					 employee2.getProjects().add(project2);
					 
					 employee3.getProjects().add(project);
					 employee3.getProjects().add(project2);
					 employee3.getProjects().add(project3);
					 entityManager.getTransaction().commit();
	}
}
