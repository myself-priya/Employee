package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository empRepo;

	public String addEmployee(EntityEmployee e) {
		empRepo.save(e);
		return "Success";
	}

	public String addList(List<EntityEmployee> e) {
		empRepo.saveAll(e);
		return "Success";
	}

	public EntityEmployee getId(int id) {
		return empRepo.findById(id).get();
	}

	public List<EntityEmployee> findAll() {
		return empRepo.findAll();
	}

	public String getDelete(int id) {
		empRepo.deleteById(id);
		return "Successfully deleted";
	}
    public List<EntityEmployee> getSalary(int salary1,int salary2){
    	return empRepo.getSalaryOf(salary1,salary2);
    }
    public String postValue(EntityEmployee c) throws AgeException,Exception {
    	 empRepo.save(c);
    	 return "Success";
    }

	public List<EntityEmployee> getByName(String name) {
		return empRepo.getByName(name);
	}
    
      
}
