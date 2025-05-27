//CollegeMgmtServiceImpl.java(21/22.03.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Faculty;
import com.nt.entity.Student;
import com.nt.repository.IFacultyRepository;
import com.nt.repository.IStudentRepository;

@Service
public class CollegeMgmtServiceImpl implements ICollegeMgmtService {
    @Autowired
	private IFacultyRepository facultyRepo;
    @Autowired
	private IStudentRepository studentRepo;
    
	@Override
	public String registerDetailsUsingFacultiesInfo(List<Faculty> list) {
		List<Faculty> list1=facultyRepo.saveAll(list);
		List<Integer> ids=list1.stream().map(Faculty::getFid).collect(Collectors.toList());
		return list1.size()+"Faculties And The Associated Students Are Saved With The Id Values"+ids;
	}

	@Override
	public String registerFacultiesUsingStudentsInfo(List<Student> list) {
		List<Student> list1=studentRepo.saveAll(list);
		List<Integer> ids=list1.stream().map(Student::getSid).collect(Collectors.toList());
		return list1.size()+"Students And The Associated Faculties Are Saved With The Id Values"+ids;
	}

	@Override
	public List<Faculty> showFacultiesAndTheirStudents() {
		return facultyRepo.findAll();
	}

	@Override
	public List<Student> showStudentsAndTheirFaculties() {
		return studentRepo.findAll();
	}

	@Override
	public String removeCertainStudentsFromFaculties(int fid, int stud1, int stud2) {
		// Load The Given Faculty
				Optional<Faculty> opt=facultyRepo.findById(fid);
				if(opt.isPresent()) {
					Faculty fac=opt.get();
					//Get Students Of The Faculty
					Set<Student> list=fac.getStudents();
					list.forEach(stud->{
						if(stud.getSid()==stud1 || stud.getSid()==stud2) {
							stud.setFaculties(null);
						}
					});
					//Update The Faculty INfo
					facultyRepo.save(fac);
					return "Students Are Removed From The Faculty";
				}
				return "Faculty Not Found";
			}
}
