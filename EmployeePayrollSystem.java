/* Project of Employee Payroll System.*/

import java.util.ArrayList;
abstract class Employee
{
	private String name;
	private int id;
	
	public Employee(String name,int id)
	{
		this.name = name;
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getId()
	{
		return id;
	}
	
	abstract double calculateSalary();
	
    public String toString()
	{
		return "Employee[name = "+name+" , id = "+id+" , Salary = "+calculateSalary()+"]";
	}
}

class FullTimeEmployee extends Employee
{
	private double monthlySalary;
	
	public FullTimeEmployee(String name,int id, double monthlySalary)
	{
		super(name,id);
		this.monthlySalary = monthlySalary;
	}
	public double calculateSalary()
	{
		return monthlySalary;
	}
	
}

class PartTimeEmployee extends Employee
{
	private int hourworked;
	private double hourlyRate;
	
	public PartTimeEmployee(String name,int id,int hourworked,double hourlyRate)
	{
		super(name,id);
		this.hourworked = hourworked;
		this.hourlyRate = hourlyRate;
	}
	
	public double calculateSalary()
	{
		return hourlyRate*hourworked;
	}
}

class PayrollSystem
{
	private ArrayList<Employee> employeelist;
	
	public PayrollSystem()
	{
		employeelist = new ArrayList<>();
	}
	
	public void addEmployee(Employee employee)
	{
		employeelist.add(employee);
	}
	
	public void removeEmployee(int id)
	{
		Employee employeeToRemove = null;
		for(Employee employee : employeelist)
		{
			if(employee.getId() == id)
			{
				employeeToRemove = employee;
				break;
			}
		}
		if(employeeToRemove != null)
		{
			employeelist.remove(employeeToRemove);
		}
	}
	
	public void displayEmployee()
	{
		for(Employee employee : employeelist)
		{
			System.out.println(employee);
		}
	}
}
class EmployeePayrollSystem
{
	public static void main(String... s)
	{
		PayrollSystem payrollSystem = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Vikash", 1, 70000);
		PartTimeEmployee emp2 = new PartTimeEmployee("Kamal",  2,  40, 100);
		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		
		System.out.println("Initial Employee details : ");
		payrollSystem.displayEmployee();
		
		System.out.println("Removing Employee");
		payrollSystem.removeEmployee(2);
		System.out.println("Remaining Employee Details : ");
		payrollSystem.displayEmployee();
	}
}