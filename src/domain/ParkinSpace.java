package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ParkinSpace {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private int flat;
		private String location;
		@OneToOne(mappedBy = "parkingSpace")
		private Employee employee;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getFlat() {
			return flat;
		}
		public void setFlat(int flat) {
			this.flat = flat;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public Employee getEmployee() {
			return employee;
		}
		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		
		
}
