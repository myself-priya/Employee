package com.example.employee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empDao;
//	@Autowired
//	EmployeeRepository empRepo;

	// List<EntityEmployee> allEmployee=empdao.findAll();

	public String addEmployee(EntityEmployee e) {
		return empDao.addEmployee(e);
	}

	public String addList(List<EntityEmployee> e) {
		return empDao.addList(e);
	}

	public EntityEmployee getId(int id) {
		return empDao.getId(id);
	}

	public List<EntityEmployee> findAll() {
		return empDao.findAll();
	}

	public String getDelete(int id) {
		return empDao.getDelete(id);
	}

	public List<EntityEmployee> getBySalary(int salary) { // no need to execute in dao execute in service
		List<EntityEmployee> allEmployee = empDao.findAll();// (findAll is method name in dao)

		return allEmployee.stream().filter(x -> x.getSalary() > salary).collect(Collectors.toList());
	}

	public List<EntityEmployee> getByAge(int age) { // no need to execute in dao execute in service
		List<EntityEmployee> allEmployee = empDao.findAll();
		return allEmployee.stream().filter(x -> x.getAge() > age).collect(Collectors.toList());
	}

	public Long getCount(int salary) { // no need to execute in dao execute in service
		List<EntityEmployee> allEmployee = empDao.findAll();
		return allEmployee.stream().filter(x -> x.getSalary() > salary).count();
	}

	public List<EntityEmployee> sort(String gender) { // no need to execute in dao execute in service
		List<EntityEmployee> allEmployee = empDao.findAll();
		return allEmployee.stream().filter(x -> x.getGender().equals(gender) && x.getSalary() > 40000)
				.collect(Collectors.toList());
	}

	public List<EntityEmployee> getSalary(int salary1, int salary2) {
		return empDao.getSalary(salary1, salary2);
	}

	public String postValue(EntityEmployee c) throws AgeException, Exception { // AgeException
		try {
			if (c.getAge() < 18) {
				throw new AgeException("the given age is uneligible");
			} else {
				return empDao.postValue(c);

			}
		} catch (AgeException a) {
			return "the given data is underAge";
		}
	}

	public List<EntityEmployee> getByName(String name) throws NameNotFoundException {
		if (empDao.getByName(name).isEmpty()) {
			throw new NameNotFoundException("name is not found");
		} else {
			return empDao.getByName(name);
		}
	}

}
