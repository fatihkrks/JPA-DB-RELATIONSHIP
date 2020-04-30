package repository;

import domain.Department;
import domain.Employee;
import domain.ParkinSpace;
import domain.Phone;
import domain.Project;

public interface EmployeeRepository {
		public void save(Employee employee);
		
		public  void insertDepartment(Department department);
		
		public void parkingSpaceAdd(ParkinSpace parkingSpace);
		
		public void insertPhone(Phone phone);
		
		public void insertProject(Project project);
}
