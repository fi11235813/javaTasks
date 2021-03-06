package telran.lessons._40_EmployeesClientApplication.dto;

import java.io.Serializable;

public class CompanySalary implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 13L;
	String company;
	double avgSalary;

	public CompanySalary() {

	}

	public CompanySalary(String company, double avgSalary) {
		super();
		this.company = company;
		this.avgSalary = avgSalary;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(double avgSalary) {
		this.avgSalary = avgSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
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
		CompanySalary other = (CompanySalary) obj;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompanySalary [company=" + company + ", avgSalary=" + avgSalary + "]";
	}

}
