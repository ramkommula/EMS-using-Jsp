package net.javaguides.ems.controller;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import net.javaguides.ems.entity.Employee;

@Service()
public class EmployeeDao 
{
	@Autowired
	JdbcTemplate jdbcTemplate;





	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
			jdbcTemplate; }

	public List<Map<String,Object>> getWorkAt()
	{
		List<Map<String,Object>> data  = null;
		String sql ="select id,CompanyName from workat";
		
		data = jdbcTemplate.queryForList(sql);
		
		return data;
		
	}

	public List<Map<String,Object>> getDepartment(Long id)
	{
		List<Map<String,Object>> data  = null;
		String sql ="select id,DepartmentName from department where workat='"+id.toString()+"'";
		
		data = jdbcTemplate.queryForList(sql);
		
		return data;
		
	} 
	
	public List<Employee> getAllEmployees()
	{
		//List<Map<String,String>> data  = new ArrayList<Map<String, String>>();

//select * from employee
		return jdbcTemplate.query("select a.id,a.first_name,a.last_name,a.email,"
				+ "a.gender,a.birthday,a.marriage,b.companyname as workat "
				+ ",c.departmentname as department from employee a "
				+ " left join workat b on a.workat=b.id "
				+ "	left join department c on c.id=a.department ", new RowMapper<Employee>()
		{
			public Employee mapRow(ResultSet rs, int row) throws SQLException
			{
				Employee emp = new Employee();


				emp.setId(rs.getLong("id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email")); 
				emp.setGender(rs.getString("gender"));
				emp.setMarriage(rs.getString("marriage"));
				emp.setBirthday(rs.getDate("birthday").toString());
				emp.setWorkat(rs.getString("workat"));
				//emp.setWorkat(rs.getString("workat"));
				//emp.setWorkat(rs.getString("workat"));
				emp.setDepartment(rs.getString("department"));


				return emp;

			}
		});
	}

	/*
	 * public long saveEmployee(Employee p) {
	 * 
	 * //firstName,lastName,email,gender,marriage,birthday,workat,department String
	 * sql="insert into employee(first_name,last_name,email,gender,marriage,birthday,workat,department) values "
	 * + "('"+p.getFirstName()+"','"+p.getLastName()+"','"+p.getEmail()+"','"+p.
	 * getGender()
	 * +"','"+p.getMarriage()+"','"+p.getBirthday()+"','"+p.getWorkat()+"','"+p.
	 * getDepartment()+"')"; //p.getBirthday() System.out.println("SQL ::"+sql);
	 * 
	 * return jdbcTemplate.update(sql);
	 * 
	 * 
	 * }
	 */

		public Boolean saveEmployee(Employee p)
	{
		 String query="insert into employee "
		 		+ "(first_name,last_name,email,gender,marriage,birthday,workat,department"
		 		+ ") values"
		 		+ "(?,?,?,?,?,?,?,?)"; 
		    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>()
		    {  
		    @Override  
		    public Boolean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException 
		    {
		    	//ps.setLong(1, p.getId());
		    	ps.setString(1, p.getFirstName());
		    	ps.setString(2, p.getLastName());
		    	ps.setString(3, p.getEmail());
		    	ps.setString(4, p.getGender());
		    	ps.setString(5, p.getMarriage());
		    	ps.setString(6, p.getBirthday());
		    	ps.setString(7, p.getWorkat());
		    	ps.setString(8, p.getDepartment());
		    	
		    	//System.out.println("Query :: "+ps.toString());

		    	return ps.execute();
		    }
		    });
	} 




	public Employee getEmployeeById(Long id)
	{
		String sql="select * from employee where id=?";  

		//return jdbcTemplate.queryForObject("select * from employee where id=?",new BeanPropertyRowMapper<Employee>(Employee.class), new Object[]{id});    

		return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Employee>(Employee.class),new Object[]{id});    
	}

	public long updateEmployee(Employee p)
	{
		String sql="update employee set first_name='"+p.getFirstName()+"', last_name='"+p.getLastName()+"'"
				+ ",email='"+p.getEmail()+"',gender='"+p.getGender()+"',marriage='"+p.getMarriage()+"',"
				+ "birthday='"+p.getBirthday()+"',workat='"+p.getWorkat()+"',department='"+p.getDepartment()+"'"
				+ " where id='"+p.getId().toString()+"'";    
		System.out.println("Query::"+sql);
		return jdbcTemplate.update(sql); 
	}

	public long deleteEmployeeById(Long id)
	{
		String sql="delete from employee where id="+id+"";    
		return jdbcTemplate.update(sql);   
	}

}
