//EmployeeMySQLDAOImpl.java(14.02.2025)
package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("empPostgreSQLDAO")
public class EmployeePostgreSQLImpl implements IEmployeeDAO {
      
	private static final String GET_EMPS_QUERY ="SELECT EMPNO, ENAME, SAL, JOB, DEPTNO FROM EMP WHERE JOB IN (?, ?, ?)";
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,SAL,JOB,DEPTNO) VALUES(?,?,?,?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE EMP SET ENAME=?, SAL=?, JOB=?, DEPTNO=? WHERE EMPNO=?";
	private static final String DELETE_EMPLOYEE = "DELETE FROM EMP WHERE EMPNO=?";

	@Autowired
	private DataSource ds;

	//For Retrieving Records
	@Override
	public List<Employee> getEmployeesByDegs(String degs1, String degs2, String degs3) throws Exception {
		   List<Employee> list=new ArrayList<>();;
		   try(Connection con=ds.getConnection();
				   PreparedStatement ps=con.prepareStatement(GET_EMPS_QUERY);){
			   //Set Values To Query Parameters
			   ps.setString(1, degs1);
			   ps.setString(2, degs2);
			   ps.setString(3, degs3);
			   //Execute The SQL Query
			   try(ResultSet rs=ps.executeQuery()){
				   //Copy Each Record Of The ResultSet Object To Model Class Object
				   while(rs.next()) {
					   //Copy Each Record To Employee Class Object
					   Employee emp = new Employee();
			            emp.setEmpno(rs.getInt("empno"));
			            emp.setEname(rs.getString("ename"));
			            emp.setSal(rs.getDouble("sal"));
			            emp.setJob(rs.getString("job"));
			            emp.setDeptno(rs.getInt("deptno"));
			            list.add(emp);
				   }
			   }//Try 2
		   }//Try 1
		   catch(SQLException se) {
			   se.printStackTrace();
			   throw se;
		   }
		   catch(Exception e) {
			   e.printStackTrace();
			   throw e;
		   }
		return list;
	}//Method
	
	//For Inserting Records
	@Override
	public int insertEmployee(Employee emp)throws Exception{
		int result=0;
		try(//Get Pooled Connection
				Connection con=ds.getConnection();
				//Create Prepared Statement Object Having The Pre-Compiled SQL Query
				PreparedStatement ps=con.prepareStatement(INSERT_EMPLOYEE);
				){
			//Set Values To Query Parameters
			ps.setInt(1,emp.getEmpno());
			ps.setString(2,emp.getEname());
			ps.setDouble(3,emp.getSal());
			ps.setString(4,emp.getJob());
			ps.setInt(5,emp.getDeptno());
			
			//Execute The SQL Query
			result=ps.executeUpdate();
		}
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}//Method
	
	//For Updating Records
	@Override
	public int updateEmployee(Employee emp) throws Exception {
	    int result = 0;
	    try (
	        // Get Pooled Connection
	        Connection con = ds.getConnection();
	        // Create Prepared Statement Object Having The Pre-Compiled SQL Query
	        PreparedStatement ps = con.prepareStatement(UPDATE_EMPLOYEE);
	    ) {
	        // Set Values To Query Parameters
	    	 ps.setString(1, emp.getEname());  
	    	 ps.setDouble(2, emp.getSal());  
	         ps.setString(3, emp.getJob());   
	         ps.setInt(4, emp.getDeptno()); 
	         ps.setInt(5, emp.getEmpno());  
	        
	        // Execute The SQL Query
	        result = ps.executeUpdate();
	    }
	    catch (SQLException se) {
	        se.printStackTrace();
	        throw se;
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return result;
	}//Method
	
	//For Deleting Records
	@Override
	public int deleteEmployee(int empno) throws Exception {
	    int result = 0;
	    try (
	        // Get Pooled Connection
	        Connection con = ds.getConnection();
	        // Create Prepared Statement Object Having The Pre-Compiled SQL Query
	        PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEE);
	    ) {
	        // Set Value To Query Parameter
	        ps.setInt(1,empno);
	        
	        // Execute The SQL Query
	        result = ps.executeUpdate();
	    }
	    catch (SQLException se) {
	        se.printStackTrace();
	        throw se;
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return result;
	}//Method
}//Class
