//IHospitalService.java(Interface)(12.02.2025)
package com.nt.service;

import java.util.List;

import com.nt.model.Hospital;

public interface IHospitalService {
        public List<Hospital> fetchAllHospitalByDegs(String degs1,String degs2,String degs3,String degs4,String degs5) throws Exception;
        public String registerHospital(Hospital hospital)throws Exception;
        public String modifyHospital(Hospital hospital)throws Exception;
        public String removeHospital(int hospitalId)throws Exception;
}
