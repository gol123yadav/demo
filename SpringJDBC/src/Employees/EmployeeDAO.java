package Employees;

import java.util.List;

import javax.rmi.CORBA.StubDelegate;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {

	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void addEmployee(Employee e)
	{
		String insert="insert into employees values('"+e.getName()+"','"+e.getEmpID()+"',"+e.getSalary()+")";
    	this.jdbcTemplate.update(insert);	
	}
	
	public List<Employee> getbyID(String id)
	{
	  String read="select * from employees where empID='"+id+"'";
     	List<Employee> employees =this.jdbcTemplate.query(read,new EmployeeMapper());
     	return employees;
	}
	
	public void deleleByID(String id) {
		String read="Delete from employees where empID='"+id+"'";
		this.jdbcTemplate.execute(read);
	}
	
	
}
