package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employee_New_Name")
public class Employee {
	@Id
	@TableGenerator(name = "EMP_GEN_DETAILED",table = "KEY_GEN",pkColumnName = "ID_NAME",valueColumnName = "COUNT",initialValue = 5)
	@GeneratedValue(generator = "EMP_GEN_DETAILED")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_surname")
	private String surname;
	@Column(name = "emp_salary")
	private int salary;
	@Column(name = "emp_type")
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
//	@Temporal(TemporalType.TIME)
	private Date startDate;
	
	@Column(name = "emp_image")
	@Lob
	private byte[] image;
	//Many employee
	//One department
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;
	
	@OneToOne
	@JoinColumn(name = "ps_id" ,unique = true)
	private ParkinSpace parkingSpace;
	
	@OneToMany
	@JoinColumn(name = "EMP_ID")
//	@JoinTable(name = "EMP_PHN",
//	joinColumns = @JoinColumn(name="EMP_ID"),
//	inverseJoinColumns = @JoinColumn(name="PHN_ID")
//	)
	private List<Phone> phones=new  ArrayList<>();
	
	@ManyToMany
	private List<Project> projects=new ArrayList<>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public ParkinSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkinSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	

}
