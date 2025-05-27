//JobSeekerMgmtServiceImpl.java(12.03.2025)
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.JobSeeker;
import com.nt.repository.IJobSeekerRepository;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {
     @Autowired
     private IJobSeekerRepository jsRepo;
     
	@Override
	public String registerJobSeeker(JobSeeker js) {
		//Save The Object
		int idVal=jsRepo.save(js).getJsId();
		return "JobSeeker Is Saved With Id Value::"+idVal;
	}

	@Override
	public Iterable<JobSeeker> showAllJobSeeker() {
		return jsRepo.findAll();
	}

	@Override
	public double showJsAgeById(int id) {
        return jsRepo.findJsAgeById(id);
	}

}
