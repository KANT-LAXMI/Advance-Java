package pojos;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
@Entity
@Table(name="projects")
public class Project extends BaseEntity {
	@Column(length = 100,unique = true)
	private String title;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	private double funds;
	// Project *--->* Emp , owning side , cascading : save n update operatios to the child table (link table)
	@ManyToMany
	@JoinTable(name="Project_Employee",joinColumns =@JoinColumn(name="emp_id"),inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Employee>EmpSet=new HashSet<>();

	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<Employee> getEmpSet() {
		return EmpSet;
	}

	public void setEmpSet(Set<Employee> empSet) {
		EmpSet = empSet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public double getFunds() {
		return funds;
	}

	public void setFunds(double funds) {
		this.funds = funds;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [title=" + title + ", startDate=" + startDate + ", endDate=" + endDate + ", funds=" + funds
				+ "]";
	}
	

}
