//HospitalDAOImpl.java(12.02.2025)
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

import com.nt.model.Hospital;

@Repository("hospitalDAO")
public class HospitalDAOImpl implements IHospitalDAO {
      
	private static final String GET_HOSPITAL_QUERY = 
		    "SELECT HOSPITALID, HOSPITALNAME, LOCATION, PHONENUMBER, ESTABLISHEDYEAR " + 
		    "FROM HOSPITAL WHERE TRIM(UPPER(LOCATION)) IN (TRIM(UPPER(?)), TRIM(UPPER(?)), TRIM(UPPER(?)), TRIM(UPPER(?)), TRIM(UPPER(?))) " + 
		    "ORDER BY LOCATION";
	private static final String INSERT_HOSPITAL = 
		    "INSERT INTO HOSPITAL(HOSPITALID, HOSPITALNAME, LOCATION, PHONENUMBER, ESTABLISHEDYEAR) VALUES (HOSPITAL_SEQ1.NEXTVAL, ?, ?, ?, ?)";
	private static final String UPDATE_HOSPITAL = 
		    "UPDATE HOSPITAL SET HOSPITALNAME=?, LOCATION=?, PHONENUMBER=?, ESTABLISHEDYEAR=? WHERE HOSPITALID=?";
	private static final String DELETE_HOSPITAL = "DELETE FROM HOSPITAL WHERE HOSPITALID = ?";
	
	@Autowired
	private DataSource ds;

	@Override
	public List<Hospital> getHospitalByDegs(String degs1, String degs2, String degs3,String degs4,String degs5) throws Exception {
		   List<Hospital> list=new ArrayList<>();;
		   try(Connection con=ds.getConnection();
				   PreparedStatement ps=con.prepareStatement(GET_HOSPITAL_QUERY)){
			   //Set Values To Query Parameters
			   ps.setString(1, degs1);
			   ps.setString(2, degs2);
			   ps.setString(3, degs3);
			   ps.setString(4, degs4);
			   ps.setString(5, degs5);
			   //Execute The SQL Query
			   try(ResultSet rs=ps.executeQuery()){
				   //Copy Each Record Of The ResultSet Object To Model Class Object
				   while(rs.next()) {
					   //Copy Each Record To Employee Class Object
					   Hospital hospital=new Hospital();
					   hospital.setHospitalid(rs.getInt(1));
					   hospital.setHospitalname(rs.getString(2));
					   hospital.setLocation(rs.getString(3));
					   hospital.setPhonenumber(rs.getDouble(4));
					   hospital.setEstablishedyear(rs.getInt(5));
					   //Add Each Model Class Object To Result Set
					   list.add(hospital);
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
	
	@Override
	public int insertHospital(Hospital hospital) throws Exception {
	    int result = 0;
	    try (
	        // Get Pooled Connection
	        Connection con = ds.getConnection();
	        // Create Prepared Statement Object Having The Pre-Compiled SQL Query
	        PreparedStatement ps = con.prepareStatement(INSERT_HOSPITAL);
	    ) {
	        // Set Values To Query Parameters
	        ps.setString(1, hospital.getHospitalname());
	        ps.setString(2, hospital.getLocation());
	        ps.setDouble(3, hospital.getPhonenumber());
	        ps.setInt(4, hospital.getEstablishedyear());
	        
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
	
	@Override
	public int updateHospital(Hospital hospital) throws Exception {
	    int result = 0;
	    try (
	        // Get Pooled Connection
	        Connection con = ds.getConnection();
	        // Create Prepared Statement Object Having The Pre-Compiled SQL Query
	        PreparedStatement ps = con.prepareStatement(UPDATE_HOSPITAL);
	    ) {
	        // Set Values To Query Parameters
	        ps.setString(1, hospital.getHospitalname());
	        ps.setString(2, hospital.getLocation());
	        ps.setDouble(3, hospital.getPhonenumber());
	        ps.setInt(4, hospital.getEstablishedyear());
	        ps.setInt(5, hospital.getHospitalid());  
	        
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
	
	 @Override
	    public int deleteHospital(int hospitalId) throws Exception {
	        int result = 0;
	        try (
	            // Get Pooled Connection
	            Connection con = ds.getConnection();
	            // Create PreparedStatement Object Having Pre-Compiled SQL Query
	            PreparedStatement ps = con.prepareStatement(DELETE_HOSPITAL);
	        ) {
	            // Set Value To Query Parameter
	            ps.setInt(1, hospitalId);
	            
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
	    }
}//Class
