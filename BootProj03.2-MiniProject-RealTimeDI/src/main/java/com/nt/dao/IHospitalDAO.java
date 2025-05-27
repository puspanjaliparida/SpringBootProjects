//IHospitalDAO.java(Interface)(12.02.2025)
package com.nt.dao;

import java.util.List;

import com.nt.model.Hospital;

public interface IHospitalDAO {
        public List<Hospital> getHospitalByDegs(String degs1,String degs2,String degs3,String degs4,String degs5) throws Exception;
        public int insertHospital(Hospital hospital) throws Exception;
        public int updateHospital(Hospital hospital) throws Exception;
        public int deleteHospital(int hospitalId) throws Exception;
}
