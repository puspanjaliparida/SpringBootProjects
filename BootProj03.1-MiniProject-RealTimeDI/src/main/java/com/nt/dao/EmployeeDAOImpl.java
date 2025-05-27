//EmployeeDAOImpl.java(08/10/11/12.02.2025)
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

@Repository("empDAO")
public class EmployeeDAOImpl implements IEmployeeDAO {
      
	private static final String GET_EMPS_QUERY="SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private static final String INSERT_EMPLOYEE="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL,DEPTNO)VALUES(EMPNO_SEQ1.NEXTVAL,?,?,?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE EMP SET ENAME=?, JOB=?, SAL=?, DEPTNO=? WHERE EMPNO=?";
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
					   Employee emp=new Employee();
					   emp.setEno(rs.getInt(1));
					   emp.setEname(rs.getString(2));
					   emp.setDegs(rs.getString(3));
					   emp.setSalary(rs.getDouble(4));
					   emp.setDeptno(rs.getInt(5));
					   //Add Each Model Class Object To ResultSet
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
			ps.setString(1,emp.getEname());
			ps.setString(2,emp.getDegs());
			ps.setDouble(3,emp.getSalary());
			ps.setInt(4,emp.getDeptno());
			
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
	        ps.setString(2, emp.getDegs());
	        ps.setDouble(3, emp.getSalary());
	        ps.setInt(4, emp.getDeptno());
	        ps.setInt(5, emp.getEno());
	        
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
	public int deleteEmployee(int eno) throws Exception {
	    int result = 0;
	    try (
	        // Get Pooled Connection
	        Connection con = ds.getConnection();
	        // Create Prepared Statement Object Having The Pre-Compiled SQL Query
	        PreparedStatement ps = con.prepareStatement(DELETE_EMPLOYEE);
	    ) {
	        // Set Value To Query Parameter
	        ps.setInt(1,eno);
	        
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
