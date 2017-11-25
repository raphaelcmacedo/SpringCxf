package com.ws.service;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ws.entity.Employee;
import com.ws.repository.EmployeeRepository;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<Employee> listAll() {
		return repository.listAll();
	}

	public Employee findById(@PathParam("id") int id) {
		return repository.findById(id);
	}

	public Employee save(Employee site) {
		return repository.save(site);
	}

	public void delete(@PathParam("id") int id) {
		Employee site = repository.findById(id);
		repository.delete(site);
	}
}
