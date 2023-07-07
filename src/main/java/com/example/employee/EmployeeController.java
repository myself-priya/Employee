package com.example.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empSer;

	@PostMapping(value = "/insert")
	public String addEmployee(@RequestBody EntityEmployee e) {
		return empSer.addEmployee(e);
	}

	@PostMapping(value = "/insertAll")
	public String addList(@RequestBody List<EntityEmployee> e) {
		return empSer.addList(e);
	}

	@GetMapping(value = "/getEmp/{id}") // view single data
	public EntityEmployee getId(@PathVariable int id) {
		return empSer.getId(id);
	}

	@GetMapping(value = "/findAll") // view all list
	public List<EntityEmployee> findAll() {
		return empSer.findAll();
	}

	@DeleteMapping(value = "/getDelete/{id}") // delete by id
	public String getDelete(@PathVariable int id) {
		return empSer.getDelete(id);
	}

	@GetMapping(value = "/getBySalary/{salary}")
	public List<EntityEmployee> getBySalary(@PathVariable int salary) {
		return empSer.getBySalary(salary);
	}

	@GetMapping(value = "/getByAge/{age}")
	public List<EntityEmployee> getByAge(@PathVariable int age) {
		return empSer.getByAge(age);
	}

	@GetMapping(value = "/getCount/{salary}")
	public Long getCount(@PathVariable int salary) {
		return empSer.getCount(salary);
	}

	@GetMapping(value = "/sort/{gender}")
	public List<EntityEmployee> sort(@PathVariable String gender) {
		return empSer.sort(gender);
	}
    @GetMapping(value="/getSalary/{salary1}/{salary2}")
    public List<EntityEmployee> getSalary(@PathVariable int salary1,@PathVariable int salary2){
    	return empSer.getSalary(salary1,salary2);
    	
    }
    
    @PostMapping(value="/insert2")
    public String postValue(@RequestBody EntityEmployee c) throws AgeException, Exception {
    	return empSer.postValue(c);
    }
    
    @GetMapping(value="/getName/{name}")
    public List<EntityEmployee> getByName(@PathVariable String name) throws NameNotFoundException,Exception{
    	return empSer.getByName(name);
    }
    	
}
